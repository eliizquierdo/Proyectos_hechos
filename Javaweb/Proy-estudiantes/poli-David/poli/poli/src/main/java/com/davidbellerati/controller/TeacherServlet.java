package com.davidbellerati.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davidbellerati.dao.TeacherDAO;
import com.davidbellerati.vo.TeacherVO;

@WebServlet("/teacher")
public class TeacherServlet extends GenericServlet<TeacherVO> {

    private TeacherDAO dao = new TeacherDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action) || "teacherDashboard".equals(action)) {
            try {
                List<TeacherVO> list = dao.getAll();
                request.setAttribute("showList", list);

                String error = request.getParameter("error");
                String msg = request.getParameter("msg");

                if (!isEmpty(error)) {
                    switch (error) {
                        case "ci": request.setAttribute("errorMessage", "Error: La Cédula de Identidad ya existe."); break;
                        case "format": request.setAttribute("errorMessage", "Error de formato: Verifique que Cédula, Teléfono y Salario sean valores numéricos."); break;
                        case "date": request.setAttribute("errorMessage", "Error de formato: La Fecha de Nacimiento debe ser AAAA-MM-DD."); break;
                        case "edad": request.setAttribute("errorMessage", "Error de validación: El profesor debe tener al menos 18 años."); break;
                        case "missing": request.setAttribute("errorMessage", "Error de datos: " + (isEmpty(msg) ? "Faltan campos obligatorios." : msg)); break;
                        case "notfound": request.setAttribute("errorMessage", "Error: El profesor no existe en la base de datos."); break;
                        case "db_error": 
                            String dbMsg = isEmpty(msg) ? "Ocurrió un problema en la base de datos." : msg;
                            request.setAttribute("errorMessage", "Error de base de datos: " + dbMsg); 
                            break;
                        default: request.setAttribute("errorMessage", "Error desconocido al procesar la solicitud."); break;
                    }
                }
                
                request.getRequestDispatcher("view/TeacherDashboard.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                writeMessage(response, "Error desconocido al cargar datos: " + e.getMessage());
            }
        } else {
            writeMessage(response, "Error 404: Acción no válida para GET.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action)) {
            response.sendRedirect("teacher?action=teacherDashboard&error=missing&msg=Acción no especificada.");
            return;
        }

        try {
            if ("saveAllRows".equals(action)) {
                
                List<TeacherVO> teachers = dao.getAll(); 
                
                for (TeacherVO t : teachers) {
                    int id = t.getId();
                    String name = request.getParameter("name_" + id);
                    
                    if (name == null) continue; 
                    
                    String ciStr = request.getParameter("ci_" + id);
                    String dobStr = request.getParameter("dateOfBirth_" + id);
                    String phoneStr = request.getParameter("phoneNumber_" + id);
                    String salaryStr = request.getParameter("salary_" + id);
                    String emerg = request.getParameter("emergencyService_" + id);
                    String addr = request.getParameter("homeAddress_" + id);

                    if (isEmpty(ciStr) || isEmpty(dobStr) || isEmpty(phoneStr) || isEmpty(salaryStr)) {
                        response.sendRedirect("teacher?action=teacherDashboard&error=missing&msg=Faltan datos obligatorios al guardar cambios.");
                        return;
                    }

                    int newCI = Integer.parseInt(ciStr);
                    int newPhone = Integer.parseInt(phoneStr);
                    float newSalary = Float.parseFloat(salaryStr);
                    LocalDate dob = LocalDate.parse(dobStr);

                    t.setName(name);
                    t.setCI(newCI);
                    t.setDateOfBirth(dob);
                    t.setPhoneNumber(newPhone);
                    t.setSalary(newSalary);
                    t.setEmergencyService(emerg);
                    t.setHomeAddress(addr);

                    dao.update(t);
                }
                response.sendRedirect("teacher?action=teacherDashboard");
                return;
            
            } else if ("addRow".equals(action)) {
                TeacherVO t = new TeacherVO();

                String name = request.getParameter("name");
                String ciStr = request.getParameter("ci");
                String dobStr = request.getParameter("dateOfBirth");
                String phoneStr = request.getParameter("phoneNumber");
                String emerg = request.getParameter("emergencyService");
                String addr = request.getParameter("homeAddress");
                String salaryStr = request.getParameter("salary");

                if (isEmpty(name) || isEmpty(ciStr) || isEmpty(dobStr) || isEmpty(phoneStr) || isEmpty(salaryStr)) {
                     response.sendRedirect("teacher?action=teacherDashboard&error=missing&msg=Faltan campos obligatorios para agregar.");
                     return;
                }
                
                int newCI = Integer.parseInt(ciStr);
                int newPhone = Integer.parseInt(phoneStr);
                float newSalary = Float.parseFloat(salaryStr);

                for (TeacherVO existing : dao.getAll()) {
                    if (existing.getCI() == newCI) {
                        response.sendRedirect("teacher?action=teacherDashboard&error=ci");
                        return;
                    }
                }
                t.setCI(newCI);

                LocalDate dob = LocalDate.parse(dobStr);
                int years = Period.between(dob, LocalDate.now()).getYears();
                if (years < 18) {
                    response.sendRedirect("teacher?action=teacherDashboard&error=edad");
                    return;
                }

                t.setName(name);
                t.setDateOfBirth(dob);
                t.setPhoneNumber(newPhone);
                t.setEmergencyService(emerg);
                t.setHomeAddress(addr);
                t.setSalary(newSalary);

                dao.add(t);
                response.sendRedirect("teacher?action=teacherDashboard");
                return;
            
            } else if ("deleteRow".equals(action)) {
                String idStr = request.getParameter("id");
                if (!isEmpty(idStr)) {
                    try {
                        int id = Integer.parseInt(idStr);
                        TeacherVO t = dao.getFromId(id);
                        if (t != null) {
                            dao.remove(t);
                            response.sendRedirect("teacher?action=teacherDashboard");
                            return;
                        }
                    } catch (Exception e) {
                        String msg = "Error al intentar eliminar. Verifique que el profesor no esté asociado a clases u otros registros (Integridad referencial).";
                        response.sendRedirect("teacher?action=teacherDashboard&error=db_error&msg=" + msg);
                        return;
                    }
                }
                response.sendRedirect("teacher?action=teacherDashboard&error=notfound");
                return;
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("teacher?action=teacherDashboard&error=format");
            return;
        } catch (DateTimeParseException e) {
            response.sendRedirect("teacher?action=teacherDashboard&error=date");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("teacher?action=teacherDashboard&error=db_error");
            return;
        }
        
        response.sendRedirect("teacher?action=teacherDashboard&error=missing&msg=Acción no reconocida.");
    }
}