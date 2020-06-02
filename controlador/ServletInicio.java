
package com.emergentes.controlador;
import com.emergentes.conexionbd.conexionbd;
import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimlp;
import com.emergentes.modelo.Aviso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miriam
 */
@WebServlet(name = "ServletInicio", urlPatterns = {"/ServletInicio"})
public class ServletInicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            AvisoDAO dao = new AvisoDAOimlp();
            // para recibir id
            int id;
            //para gestionar registros
            Aviso avi = new Aviso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            switch(action){
                
                case"add":
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("aviso", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                   id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    //request.getRequestDispatcher("ServletInicio").forward(request, response);
                    response.sendRedirect(request.getContextPath()+"/ServletInicio");
                    break;
                default:
                    List<Aviso> lista =dao.getAll();
                    request.setAttribute("avisos", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                
                    break;
            }
        }catch(Exception ex){
            System.out.println("error" + ex.getMessage());
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AvisoDAO dao = new AvisoDAOimlp();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        Aviso avi = new Aviso();
        avi.setId(id);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        if(id == 0){
            //nuevo registro
            try{
             dao.insert(avi);
             response.sendRedirect("ServletInicio");
             //response.sendRedirect(request.getContextPath()+"/ServletInicio");
            } catch(Exception ex){
                System.out.println("error"+ ex.getMessage());
            }
        }
        else{
            //actualizacion de un registro
            try{
             dao.insert(avi);
             response.sendRedirect("ServletInicio");
             //response.sendRedirect(request.getContextPath()+"/ServletInicio");
            } catch(Exception ex){
                System.out.println("error"+ ex.getMessage());
            }
        
        }
        
    }

}
