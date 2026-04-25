package com.davidbellerati.controller;

import com.davidbellerati.dao.MaterialDAO;
import com.davidbellerati.vo.MaterialVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/material")
public class MaterialServlet extends GenericServlet<MaterialVO> {

    private MaterialDAO dao = new MaterialDAO();
    private static final String DASHBOARD_JSP = "view/MaterialDashboard.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<MaterialVO> materials = dao.getAll();
        request.setAttribute("materials", materials);
        request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (isEmpty(action)) {
            request.setAttribute("errorMessage", "Acción no especificada.");
            List<MaterialVO> materials = dao.getAll();
            request.setAttribute("materials", materials);
            request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
            return;
        }

        try {
            switch (action) {
                case "saveRow": {
                    List<MaterialVO> materials = dao.getAll();
                    for (MaterialVO m : materials) {
                        String nameParam = request.getParameter("name_" + m.getId());
                        String amountParam = request.getParameter("amount_" + m.getId());
                        
                        if (!isEmpty(nameParam) && !isEmpty(amountParam)) {
                            try {
                                int amount = Integer.parseInt(amountParam);
                                
                                if (amount < 0) {
                                     request.setAttribute("errorMessage", "La cantidad para '" + m.getName() + "' no puede ser negativa.");
                                     List<MaterialVO> errorMaterials = dao.getAll();
                                     request.setAttribute("materials", errorMaterials);
                                     request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                                     return;
                                }

                                m.setName(nameParam);
                                m.setAmount(amount);
                                dao.update(m);
                            } catch (NumberFormatException e) {
                                request.setAttribute("errorMessage", "Cantidad inválida para el material '" + m.getName() + "'. Solo se permiten números enteros.");
                                List<MaterialVO> errorMaterials = dao.getAll();
                                request.setAttribute("materials", errorMaterials);
                                request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                                return;
                            }
                        }
                    }
                    response.sendRedirect("material");
                    break;
                }

                case "addRow": {
                    String name = request.getParameter("name");
                    String amountStr = request.getParameter("amount");
                    
                    if (isEmpty(name) || isEmpty(amountStr)) {
                        request.setAttribute("errorMessage", "El nombre y la cantidad son obligatorios para agregar un material.");
                        List<MaterialVO> materials = dao.getAll();
                        request.setAttribute("materials", materials);
                        request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                        return;
                    }

                    try {
                        int amount = Integer.parseInt(amountStr);
                        
                        if (amount < 0) {
                             request.setAttribute("errorMessage", "La cantidad para el nuevo material no puede ser negativa.");
                             List<MaterialVO> materials = dao.getAll();
                             request.setAttribute("materials", materials);
                             request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                             return;
                        }

                        MaterialVO m = new MaterialVO(name, amount);
                        dao.add(m);
                        
                        response.sendRedirect("material");
                    } catch (NumberFormatException e) {
                        request.setAttribute("errorMessage", "Cantidad inválida. Solo se permiten números enteros.");
                        List<MaterialVO> materials = dao.getAll();
                        request.setAttribute("materials", materials);
                        request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                    }
                    break;
                }

                case "deleteRow": {
                    String idStr = request.getParameter("id");
                    
                    if (isEmpty(idStr)) {
                         request.setAttribute("errorMessage", "No se especificó el ID del material a eliminar.");
                         List<MaterialVO> materials = dao.getAll();
                         request.setAttribute("materials", materials);
                         request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                         return;
                    }

                    try {
                        int id = Integer.parseInt(idStr);
                        MaterialVO m = dao.getFromId(id);
                        if (m != null) {
                            dao.remove(m);
                        } else {
                            request.setAttribute("errorMessage", "No se encontró el material con ID " + id + " para eliminar.");
                            List<MaterialVO> materials = dao.getAll();
                            request.setAttribute("materials", materials);
                            request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                            return;
                        }
                        
                        response.sendRedirect("material");
                    } catch (NumberFormatException e) {
                        request.setAttribute("errorMessage", "ID de material inválido.");
                        List<MaterialVO> materials = dao.getAll();
                        request.setAttribute("materials", materials);
                        request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                    }
                    break;
                }

                default:
                    request.setAttribute("errorMessage", "Acción no reconocida: " + action);
                    List<MaterialVO> materials = dao.getAll();
                    request.setAttribute("materials", materials);
                    request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error interno del servidor al procesar la acción: " + action);
            List<MaterialVO> materials = dao.getAll();
            request.setAttribute("materials", materials);
            request.getRequestDispatcher(DASHBOARD_JSP).forward(request, response);
        }
    }
}