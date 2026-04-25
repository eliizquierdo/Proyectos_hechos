package com.davidbellerati.controller;

import com.davidbellerati.dao.ActivityDAO;
import com.davidbellerati.dao.MemberDAO;
import com.davidbellerati.dao.TeacherDAO;
import com.davidbellerati.vo.ActivityVO;
import com.davidbellerati.vo.MemberVO;
import com.davidbellerati.vo.TeacherVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.davidbellerati.controller.GenericServlet;

@WebServlet("/activity")
public class ActivityServlet extends GenericServlet<ActivityVO> {

    private ActivityDAO dao = new ActivityDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private MemberDAO memberDAO = new MemberDAO();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action)) action = "activityDashboard";

        if ("activityDashboard".equals(action)) {
            List<ActivityVO> list = dao.getAll();
            List<TeacherVO> teachers = teacherDAO.getAll();
            List<MemberVO> members = memberDAO.getAll();

            request.setAttribute("activities", list);
            request.setAttribute("teachers", teachers);
            request.setAttribute("members", members);

            String error = request.getParameter("error");
            if ("ci_not_found".equals(error)) {
                request.setAttribute("errorMessage", "Error: La Cédula de Identidad ingresada no pertenece a un Miembro o Profesor existente.");
            } else if ("ci_format".equals(error)) {
                request.setAttribute("errorMessage", "Error de formato: La Cédula debe ser un valor numérico.");
            } else if ("missing_teacher".equals(error)) {
                request.setAttribute("errorMessage", "Error: Debe asignar un Profesor válido a la actividad.");
            } else if ("db_error".equals(error)) {
                request.setAttribute("errorMessage", "Error: Ocurrió un error en la base de datos.");
            }
            
            request.getRequestDispatcher("view/ActivityDashboard.jsp").forward(request, response);
        } else {
            writeMessage(response, "Error 404: Página no encontrada.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");

        String action = request.getParameter("action");

        List<TeacherVO> teachers = teacherDAO.getAll();
        request.setAttribute("teachers", teachers);

        if (isEmpty(action)) {
            writeMessage(response, "Acción inválida");
            return;
        }

        try {
            switch (action) {
                case "saveRow":
                    List<ActivityVO> activities = dao.getAll();
                    for (ActivityVO a : activities) {
                        String name = request.getParameter("name_" + a.getId());
                        String entry = request.getParameter("entryHour_" + a.getId());
                        String depart = request.getParameter("departHour_" + a.getId());
                        String teacherCiStr = request.getParameter("asignedTeacher_" + a.getId());
                        String newMemberCiStr = request.getParameter("newMember_" + a.getId());
                        
                        if (name != null && teacherCiStr != null && !teacherCiStr.isEmpty()) {
                            try {
                                Integer teacherId = teacherDAO.getIdByCI(Integer.parseInt(teacherCiStr));
                                
                                if (teacherId == null) {
                                    response.sendRedirect("activity?action=activityDashboard&error=ci_not_found");
                                    return;
                                }
                                
                                a.setName(name);
                                a.setEntryHour(entry);
                                a.setDepartHour(depart);
                                TeacherVO t = new TeacherVO();
                                t.setId(teacherId);
                                a.setAsignedTeacher(t);
                                dao.update(a);
                            } catch (NumberFormatException e) {
                                response.sendRedirect("activity?action=activityDashboard&error=ci_format");
                                return;
                            }
                        } else if (name != null) {
                            response.sendRedirect("activity?action=activityDashboard&error=missing_teacher");
                            return;
                        }
                        
                        if (newMemberCiStr != null && !newMemberCiStr.isEmpty()) {
                            try {
                                Integer memberId = memberDAO.getIdByCI(Integer.parseInt(newMemberCiStr));
                                if (memberId == null) {
                                    response.sendRedirect("activity?action=activityDashboard&error=ci_not_found");
                                    return;
                                }
                                dao.addMemberToActivity(a.getId(), memberId); 
                            } catch (NumberFormatException e) {
                                response.sendRedirect("activity?action=activityDashboard&error=ci_format");
                                return;
                            }
                        }
                    }
                    response.sendRedirect("activity?action=activityDashboard");
                    return;

                case "addRow":
                    ActivityVO newActivity = new ActivityVO();
                    
                    String teacherCiStrNew = request.getParameter("asignedTeacher");
                    
                    if (isEmpty(teacherCiStrNew)) {
                        response.sendRedirect("activity?action=activityDashboard&error=missing_teacher");
                        return;
                    }
                    
                    Integer teacherIdNew = null;
                    try {
                        teacherIdNew = teacherDAO.getIdByCI(Integer.parseInt(teacherCiStrNew));
                    } catch (NumberFormatException e) {
                        response.sendRedirect("activity?action=activityDashboard&error=ci_format");
                        return;
                    }

                    if (teacherIdNew == null) {
                        response.sendRedirect("activity?action=activityDashboard&error=ci_not_found");
                        return;
                    }
                    
                    newActivity.setName(request.getParameter("name"));
                    newActivity.setEntryHour(request.getParameter("entryHour"));
                    newActivity.setDepartHour(request.getParameter("departHour"));

                    TeacherVO t = new TeacherVO();
                    t.setId(teacherIdNew);
                    newActivity.setAsignedTeacher(t);
                    dao.add(newActivity);
                    response.sendRedirect("activity?action=activityDashboard");
                    return;

                case "deleteRow":
                    String idStr = request.getParameter("id");
                    if (!isEmpty(idStr)) {
                        int id = Integer.parseInt(idStr);
                        ActivityVO a = dao.getFromId(id);
                        if (a != null) dao.remove(a);
                    }
                    response.sendRedirect("activity?action=activityDashboard");
                    return;

                default:
                    if (action.startsWith("addMember_")) {
                        int activityId = Integer.parseInt(action.split("_")[1]);
                        String memberCiStr = request.getParameter("newMember_" + activityId);

                        if (!isEmpty(memberCiStr)) {
                            Integer memberId = null;
                            try {
                                memberId = memberDAO.getIdByCI(Integer.parseInt(memberCiStr));
                            } catch (NumberFormatException e) {
                                response.sendRedirect("activity?action=activityDashboard&error=ci_format");
                                return;
                            }
                            
                            if (memberId == null) {
                                response.sendRedirect("activity?action=activityDashboard&error=ci_not_found");
                                return;
                            }
                            dao.addMemberToActivity(activityId, memberId);
                        }
                        response.sendRedirect("activity?action=activityDashboard");
                        return;
                    }

                    if (action.startsWith("deleteMember_")) {
                        String[] parts = action.split("_");
                        if (parts.length == 3) {
                            int actId = Integer.parseInt(parts[1]);
                            int memId = Integer.parseInt(parts[2]);
                            dao.removeMemberFromActivity(actId, memId);
                        }
                        response.sendRedirect("activity?action=activityDashboard");
                        return;
                    }
                    writeMessage(response, "Acción inválida");
            }
        } catch (NumberFormatException e) {
             response.sendRedirect("activity?action=activityDashboard&error=ci_format");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("activity?action=activityDashboard&error=db_error");
        }
    }
}