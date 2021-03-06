/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SolicitudesDAO;
import Modelo.SolicitudesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Washington
 */
public class GestionSolicitudes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            SolicitudesDTO objDto = new SolicitudesDTO();
            SolicitudesDAO objDao = new SolicitudesDAO();

            if (request.getParameter("Boton").equals("Solicitud Nueva")) {
                objDto.setId_Solicitud(Integer.parseInt(request.getParameter("Id_Solicitud")));
                objDto.setFecha(request.getParameter("Fecha"));
                objDto.setCargo(Integer.parseInt(request.getParameter("Cargo")));
                objDto.setPerfil(request.getParameter("Perfil"));
                objDto.setExperiencia(request.getParameter("Experiencia"));
                objDto.setConocimiento(request.getParameter("Conocimiento"));
                objDto.setEstudio(request.getParameter("Estudio"));
                objDto.setDepartamento(Integer.parseInt(request.getParameter("Departamento")));
                objDto.setCoordinadorSolicitante(Integer.parseInt(request.getParameter("CoordinadorSolicitante")));
                String Estado = objDao.IngresarSolicitud(objDto);
                RequestDispatcher Rd = request.getRequestDispatcher("solicitudesCrear.jsp?mensaje=" + Estado);
                Rd.forward(request, response);
                
            }else if (request.getParameter("Boton").equals("BorrarSol") ){
                objDto.setId_Solicitud(Integer.parseInt(request.getParameter("pos")));
               
                String Estado = objDao.BorrarSolicitud(objDto);
              
                request.setAttribute("mensaje",Estado);
                 RequestDispatcher Rd = request.getRequestDispatcher("solicitudesListar.jsp");
                Rd.forward(request, response);
                
            }else if (request.getParameter("Boton").equals("Actualizar") ){
                objDto.setId_Solicitud(Integer.parseInt(request.getParameter("Id_Solicitud")));
                objDto.setFecha(request.getParameter("Fecha"));
                objDto.setCargo(Integer.parseInt(request.getParameter("Cargo")));
                objDto.setPerfil(request.getParameter("Perfil"));
                objDto.setExperiencia(request.getParameter("Experiencia"));
                objDto.setConocimiento(request.getParameter("Conocimiento"));
                objDto.setEstudio(request.getParameter("Estudio"));
                objDto.setDepartamento(Integer.parseInt(request.getParameter("Departamento")));
                objDto.setCoordinadorSolicitante(Integer.parseInt(request.getParameter("CoordinadorSolicitante")));
//                request.setAttribute("mensaje",Estado);
                RequestDispatcher Rd = request.getRequestDispatcher("solicitudesListar.jsp");
                Rd.forward(request, response);
                
//                RequestDispatcher Rd = request.getRequestDispatcher("usuariosBorrar.jsp?mensaje=" + Estado);
//                Rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
