import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/*")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();

        try (Connection conn = DBConnection.getConnection()) {
            if ("/register".equals(path)) {
                String query = "INSERT INTO usuarios (nombre, email, contrasena) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, jsonObject.get("name").getAsString());
                stmt.setString(2, jsonObject.get("email").getAsString());
                stmt.setString(3, jsonObject.get("password").getAsString());
                stmt.executeUpdate();
                response.getWriter().write("Registro exitoso.");
            } else if ("/login".equals(path)) {
                String query = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, jsonObject.get("email").getAsString());
                stmt.setString(2, jsonObject.get("password").getAsString());
                ResultSet rs = stmt.executeQuery();
                PrintWriter out = response.getWriter();
                if (rs.next()) {
                    out.write("Inicio de sesión exitoso.");
                } else {
                    out.write("Credenciales incorrectas.");
                }
            }
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
