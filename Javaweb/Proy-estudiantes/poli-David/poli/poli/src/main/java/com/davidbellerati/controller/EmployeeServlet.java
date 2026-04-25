package com.davidbellerati.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davidbellerati.*;
import com.davidbellerati.dao.EmployeeDAO;
import com.davidbellerati.vo.EmployeeVO;

@WebServlet("/employee")
public class EmployeeServlet extends GenericServlet<EmployeeVO> {
    
    private EmployeeDAO employeeDao = new EmployeeDAO();

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
                List<EmployeeVO> employees = employeeDao.getAll();

                for (EmployeeVO e : employees) {
                    int id = e.getId();

                    String name = request.getParameter("name_" + id);
                    String ciStr = request.getParameter("ci_" + id);
                    String dobStr = request.getParameter("dateOfBirth_" + id);
                    String phoneStr = request.getParameter("phoneNumber_" + id);
                    String homeAddress = request.getParameter("homeAddress_" + id);
                    String emergencyService = request.getParameter("emergencyService_" + id);
                    String salary = request.getParameter("salary_" + id);
                    String category = request.getParameter("category_" + id);

                    if (isEmpty(name) || isEmpty(ciStr) || isEmpty(category)) continue;

                    try {
                        int newCI = Integer.parseInt(ciStr);

                        Integer existingId = employeeDao.getIdByCi(newCI);
                        if (existingId != null && existingId != id) {
                            response.sendRedirect("employee?action=employeeDashboard&error=ci");
                            return;
                        }

                        e.setName(name);
                        e.setCI(newCI);
                        e.setCategory(category);
                        
                        if (!isEmpty(dobStr)) e.setDateOfBirth(LocalDate.parse(dobStr));
                        if (!isEmpty(phoneStr)) e.setPhoneNumber(Integer.parseInt(phoneStr));
                        if (!isEmpty(salary)) e.setSalary(Double.parseDouble(salary));

                        e.setHomeAddress(homeAddress);
                        e.setEmergencyService(emergencyService);

                        employeeDao.update(e);

                    } catch (NumberFormatException ex) {
                        response.sendRedirect("employee?action=employeeDashboard&error=format");
                        return;
                    } catch (DateTimeParseException ex) {
                        response.sendRedirect("employee?action=employeeDashboard&error=date");
                        return;
                    } catch (Exception ex) {
                        response.sendRedirect("employee?action=employeeDashboard&error=db");
                        return;
                    }
                }
                response.sendRedirect("employee?action=employeeDashboard");
                break;
            }

            case "addRow": {
                try {
                    EmployeeVO e = new EmployeeVO();

                    String ciStr = request.getParameter("ci");
                    if (isEmpty(ciStr)) throw new IllegalArgumentException("La Cédula es obligatoria.");
                    int newCI = Integer.parseInt(ciStr);

                    if (employeeDao.getIdByCi(newCI) != null) {
                        response.sendRedirect("employee?action=employeeDashboard&error=ci");
                        return;
                    }
                    e.setCI(newCI);

                    String name = request.getParameter("name");
                    if (isEmpty(name)) throw new IllegalArgumentException("El Nombre es obligatorio.");
                    e.setName(name);

                    String dobStr = request.getParameter("dateOfBirth");
                    if (isEmpty(dobStr)) throw new IllegalArgumentException("La Fecha de Nacimiento es obligatoria.");
                    e.setDateOfBirth(LocalDate.parse(dobStr));

                    String phoneStr = request.getParameter("phoneNumber");
                    if (isEmpty(phoneStr)) throw new IllegalArgumentException("El Teléfono es obligatorio.");
                    e.setPhoneNumber(Integer.parseInt(phoneStr));

                    String homeAddress = request.getParameter("homeAddress");
                    if (isEmpty(homeAddress)) throw new IllegalArgumentException("La Dirección es obligatoria.");
                    e.setHomeAddress(homeAddress);

                    String emergencyService = request.getParameter("emergencyService");
                    if (isEmpty(emergencyService)) throw new IllegalArgumentException("El Servicio de Emergencia es obligatorio.");
                    e.setEmergencyService(emergencyService);

                    String salary = request.getParameter("salary");
                    if (isEmpty(salary)) throw new IllegalArgumentException("El Salario es obligatorio.");
                    e.setSalary(Double.parseDouble(salary));

                    String category = request.getParameter("category");
                    if (isEmpty(category)) throw new IllegalArgumentException("La Categoria es obligatoria.");
                    e.setCategory(category);

                    employeeDao.add(e);
                    response.sendRedirect("employee?action=employeeDashboard");

                } catch (NumberFormatException e) {
                    response.sendRedirect("employee?action=employeeDashboard&error=format");
                } catch (DateTimeParseException e) {
                    response.sendRedirect("employee?action=employeeDashboard&error=date");
                } catch (IllegalArgumentException e) {
                    response.sendRedirect("employee?action=employeeDashboard&error=missing&msg=" + e.getMessage().replace(" ", "%20"));
                } catch (Exception e) {
                    response.sendRedirect("employee?action=employeeDashboard&error=db");
                }
                break;
            }

            case "deleteRow": {
                String idStr = request.getParameter("id");
                if (isEmpty(idStr)) {
                    response.sendRedirect("employee?action=employeeDashboard&error=id");
                    return;
                }

                try {
                    int id = Integer.parseInt(idStr);
                    EmployeeVO e = employeeDao.getFromId(id);

                    if (e == null) {
                        response.sendRedirect("employee?action=employeeDashboard&error=notfound");
                        return;
                    }

                    employeeDao.remove(e);
                    response.sendRedirect("employee?action=employeeDashboard");

                } catch (NumberFormatException e) {
                    response.sendRedirect("employee?action=employeeDashboard&error=idformat");
                }
                break;
            }

            default:
                writeMessage(response, "Acción inválida");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action)) action = "employeeDashboard";

        switch (action) {
            case "employeeDashboard":
                List<EmployeeVO> list = employeeDao.getAll();
                request.setAttribute("showList", list);

                String error = request.getParameter("error");
                String msg = request.getParameter("msg");

                if (!isEmpty(error)) {
                    if ("ci".equals(error)) request.setAttribute("errorMessage", "Error: La Cédula ya existe o es inválida.");
                    else if ("format".equals(error)) request.setAttribute("errorMessage", "Error: Formato numérico inválido.");
                    else if ("date".equals(error)) request.setAttribute("errorMessage", "Error: Formato de fecha incorrecto.");
                    else if ("missing".equals(error)) request.setAttribute("errorMessage", isEmpty(msg) ? "Faltan datos obligatorios." : msg);
                    else request.setAttribute("errorMessage", "Error desconocido al procesar la solicitud.");
                }

                request.getRequestDispatcher("view/EmployeeDashboard.jsp").forward(request, response);
                break;

            default:
                writeMessage(response, "Error 404: Página no encontrada.");
        }
    }
}
