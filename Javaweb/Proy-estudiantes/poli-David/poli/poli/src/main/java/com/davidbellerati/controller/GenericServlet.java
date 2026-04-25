package com.davidbellerati.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GenericServlet<T> extends HttpServlet {

    /**
     * Escribe un mensaje en la respuesta HTTP.
     */
    protected void writeMessage(HttpServletResponse response, String msg) throws IOException {
        response.getWriter().write(msg);
        response.getWriter().flush();
    }

    /**
     * Verifica si un String es null o está vacío.
     */
    protected boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * Método GET que debe ser implementado por cada servlet hijo.
     */
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;

    /**
     * Método POST que debe ser implementado por cada servlet hijo.
     */
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;
}
