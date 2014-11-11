package com.readersdigest.onepass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.impl.ServiceValidator;

/**
 * Servlet implementation class EmailRegistrationValidation
 */
public class EmailRegistrationValidation extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailRegistrationValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String emailAddress = request.getParameter("emailAddress");
        PrintWriter out = response.getWriter();
        ServiceValidator serviceValidator = new ServiceValidator();
//
//        try {
//           // serviceValidator.uniqueEmailValidation(emailAddress);
//        } catch (ServiceException e) {
//            out.print("ERROR");
//            return;
//        }

        out.print("SUCCESS");
    }

}
