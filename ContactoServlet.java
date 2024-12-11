import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "ContactoServlet", urlPatterns = {"ContactoServlet"})
public class ContactoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter ("nombre");
        String email = request.getParameter ("email");
        String asunto = request.getParameter("asunto");
        String mensaje = request.getParameter("mensaje");

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Formulario recibido</h2>");
        response.getWriter().println("<p>Nombre: " + nombre + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Asunto: " + asunto + "</p>");
        response.getWriter().println("<p>Mensaje: " + mensaje + "</p>");
        response.getWriter().println("</body></html>");

        // Redirigir de nuevo al formulario después de procesar
        response.sendRedirect("contacto.jsp");
    }
}
