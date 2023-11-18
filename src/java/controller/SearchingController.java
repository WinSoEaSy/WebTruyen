/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BooksDAO;
import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Books;

/**
 *
 * @author Admin
 */
@WebServlet(name="SearchingController", urlPatterns={"/search"})
public class SearchingController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchingController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchingController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       BooksDAO bDAO = new BooksDAO();
        
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("keyname");

        ArrayList<Books> blist = bDAO.loadBooksByName(name);
        out.print("<div class=\"relative relative-content\">\n"
                + "                            <span class=\"page-title\">Ket qua cho: "+name+"</span>\n"
                + "                        </div>\n"
                + "                        <div class=\"items\">");
        for (Books b : blist) {
            out.print("<div class=\"item item1\">\n"
                    + "                                    <div class=\"ct-image ct-top\"><a href=\"#\"><img src=\""+b.getBookImg()+"\" width=\"100%\" height=\"100%\" alt=\"alt\"/><a></div>\n"
                    + "                                    <div class=\"ct-info ct-foot\">\n"
                    + "                                        <span class=\"nt-name\">"+b.getBookName()+"</span>\n"
                    + "                                        <div class=\"new-chapter\">\n"
                    + "                                            <span class=\"chapter-latest\"><a href=\"#\">"+b.getLike()+"</a></span>\n"
                    + "                                            <span class=\"chapter-latest-time\">+"+b.getView()+"</span>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>");
        }
        out.print("</div>");
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
