package py.una.pol.par.client;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import py.una.pol.par.entity.Product;

/**
 *
 * @author Juan
 */
@WebServlet(name = "RestProductServlet", urlPatterns = {"/RestProductServlet"})
public class RestProductServlet extends HttpServlet {
    
    public static final byte PETICION_GET = 0;
    public static final byte PETICION_POST = 1;
    public static final byte PETICION_PUT = 2;
    public static final byte PETICION_DELETE = 3;
    private byte tipoPeticion;
    
    ProductoModelo pm = new ProductoModelo();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RestProductServlet at " + request.getContextPath() + "</h1>");
            
            switch (tipoPeticion) {
                case PETICION_GET:
                    // Consultar uno o mas productos
                    String param1 = request.getParameter("id");
                    if (param1==null){
                        pm.getProducts();
                    }
                    else{
                        int p1 = parseInt(param1);
                        pm.getProductById(p1);
                    }
                    break;
                    
                case PETICION_POST:
                    // Añadir nuevo Producto
                    Product prd1 = (Product) request;
                    pm.addProduct(prd1);
                    break;
                    
                case PETICION_PUT:
                    // Actualizar un Producto
                    Product prd2 = (Product) request;
                    pm.updateProduct(prd2);
                    break;
                    
                case PETICION_DELETE:
                    // Eliminar un Producto
                    String param2 = request.getParameter("id");
                    int p2 = parseInt(param2);
                    pm.removeProduct(p2);
                    break;
                    
                default:
                    break;
            }
 
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
    
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
        tipoPeticion = PETICION_GET;
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
        tipoPeticion = PETICION_POST;
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_DELETE;
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tipoPeticion = PETICION_PUT;
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Este Servlet contiene la logica de un diseño MVC para el microservicio de Productos";
    }

}
