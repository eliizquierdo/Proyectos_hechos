package com.davidbellerati.controller;

import com.davidbellerati.dao.MemberDAO;
import com.davidbellerati.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.davidbellerati.controller.GenericServlet; 

@WebServlet("/member")
public class MemberServlet extends GenericServlet<MemberVO> {

    private MemberDAO memberDAO = new MemberDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action)) {
            action = "memberDashboard";
        }

        switch (action) {
            case "memberDashboard":
                List<MemberVO> list = memberDAO.getAll();
                request.setAttribute("showList", list);
                
                String error = request.getParameter("error");
                String msg = request.getParameter("msg");
                if (!isEmpty(error)) {
                    if ("ci".equals(error)) {
                        request.setAttribute("errorMessage", "Error: La Cédula de Identidad ya existe o es inválida.");
                    } else if ("format".equals(error)) {
                        request.setAttribute("errorMessage", "Error de formato: Verifique que la Cédula y el Teléfono sean números.");
                    } else if ("date".equals(error)) {
                        request.setAttribute("errorMessage", "Error de formato: La Fecha de Nacimiento debe ser AAAA-MM-DD.");
                    } else if ("missing".equals(error)) {
                        request.setAttribute("errorMessage", "Error de datos: " + (isEmpty(msg) ? "Faltan campos obligatorios." : msg));
                    } else {
                        request.setAttribute("errorMessage", "Error desconocido al procesar la solicitud.");
                    }
                }
                
                request.getRequestDispatcher("view/MemberDashboard.jsp").forward(request, response);
                break;

            default:
                writeMessage(response, "Error 404: Página no encontrada.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (isEmpty(action)) {
            writeMessage(response, "Acción inválida");
            return;
        }

        switch (action) {

            case "saveRow": {
                List<MemberVO> members = memberDAO.getAll();

                for (MemberVO m : members) {
                    int id = m.getId();

                    String name = request.getParameter("name_" + id);
                    String ciStr = request.getParameter("ci_" + id);
                    String dobStr = request.getParameter("dateOfBirth_" + id);
                    String phoneStr = request.getParameter("phoneNumber_" + id);
                    String homeAddress = request.getParameter("homeAddress_" + id);
                    String emergencyService = request.getParameter("emergencyService_" + id);
                    
                    if (isEmpty(name) || isEmpty(ciStr)) continue;

                    try {
                        int newCI = Integer.parseInt(ciStr);

                        Integer existingId = memberDAO.getIdByCI(newCI);
                        if (existingId != null && existingId != id) {
                            response.sendRedirect("member?action=memberDashboard&error=ci");
                            return;
                        }

                        m.setName(name);
                        m.setCI(newCI);
                        
                        if (!isEmpty(dobStr)) {
                            m.setDateOfBirth(LocalDate.parse(dobStr));
                        }
                        
                        if (!isEmpty(phoneStr)) {
                            m.setPhoneNumber(Integer.parseInt(phoneStr));
                        }
                        
                        m.setHomeAddress(homeAddress);
                        m.setEmergencyService(emergencyService);

                        memberDAO.update(m);
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato de número al guardar fila: " + e.getMessage());
                        response.sendRedirect("member?action=memberDashboard&error=format");
                        return;
                    } catch (DateTimeParseException e) {
                        System.err.println("Error de formato de fecha al guardar fila: " + e.getMessage());
                        response.sendRedirect("member?action=memberDashboard&error=date");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.sendRedirect("member?action=memberDashboard&error=db");
                        return;
                    }
                }
                response.sendRedirect("member?action=memberDashboard");
                break;
            }

            case "addRow": {
                try {
                    MemberVO m = new MemberVO();

                    String ciStr = request.getParameter("ci");
                    if (isEmpty(ciStr)) throw new IllegalArgumentException("La Cédula es obligatoria.");
                    int newCI = Integer.parseInt(ciStr);

                    if (memberDAO.getIdByCI(newCI) != null) {
                        response.sendRedirect("member?action=memberDashboard&error=ci");
                        return;
                    }
                    m.setCI(newCI);

                    String name = request.getParameter("name");
                    if (isEmpty(name)) throw new IllegalArgumentException("El Nombre es obligatorio.");
                    m.setName(name);

                    String dobStr = request.getParameter("dateOfBirth");
                    if (isEmpty(dobStr)) throw new IllegalArgumentException("La Fecha de Nacimiento es obligatoria.");
                    m.setDateOfBirth(LocalDate.parse(dobStr));

                    String phoneStr = request.getParameter("phoneNumber");
                    if (isEmpty(phoneStr)) throw new IllegalArgumentException("El Teléfono es obligatorio.");
                    m.setPhoneNumber(Integer.parseInt(phoneStr));
                    
                    String homeAddress = request.getParameter("homeAddress");
                    if (isEmpty(homeAddress)) throw new IllegalArgumentException("La Dirección es obligatoria.");
                    m.setHomeAddress(homeAddress);

                    String emergencyService = request.getParameter("emergencyService");
                    if (isEmpty(emergencyService)) throw new IllegalArgumentException("El Servicio de Emergencia es obligatorio.");
                    m.setEmergencyService(emergencyService);

                    memberDAO.add(m);
                    response.sendRedirect("member?action=memberDashboard");
                } catch (NumberFormatException e) {
                    response.sendRedirect("member?action=memberDashboard&error=format");
                } catch (DateTimeParseException e) {
                    response.sendRedirect("member?action=memberDashboard&error=date");
                } catch (IllegalArgumentException e) {
                    response.sendRedirect("member?action=memberDashboard&error=missing&msg=" + e.getMessage().replace(" ", "%20"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("member?action=memberDashboard&error=db");
                }
                break;
            }

            case "deleteRow": {
                String idStr = request.getParameter("id");
                if (isEmpty(idStr)) {
                    response.sendRedirect("member?action=memberDashboard&error=id");
                    return;
                }

                try {
                    int id = Integer.parseInt(idStr);
                    MemberVO m = memberDAO.getFromId(id);
                    if (m == null) {
                        response.sendRedirect("member?action=memberDashboard&error=notfound");
                        return;
                    }

                    memberDAO.remove(m);
                    response.sendRedirect("member?action=memberDashboard");
                } catch (NumberFormatException e) {
                    response.sendRedirect("member?action=memberDashboard&error=idformat");
                }
                break;
            }

            default:
                writeMessage(response, "Acción inválida");
        }
    }
}