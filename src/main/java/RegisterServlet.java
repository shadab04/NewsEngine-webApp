import org.mindrot.jbcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Basic validation
        if (username == null || email == null || password == null
                || username.isBlank() || email.isBlank() || password.length() < 8) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input. Make sure fields are filled and password is at least 8 characters.");
            return;
        }

        try {
            // Hash password (work factor 12 recommended)
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

            boolean created = userDAO.createUser(username.trim(), email.trim(), hashed);
            if (created) {
                // on success, redirect to login page with success message (query param)
                resp.sendRedirect(req.getContextPath() + "/login.html?registered=1");
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to create user.");
            }
        } catch (SQLException e) {
            // Unique constraint could fail: send user-friendly message
            String msg = e.getMessage();
            if (msg != null && msg.toLowerCase().contains("duplicate")) {
                resp.sendError(HttpServletResponse.SC_CONFLICT, "Username or email already exists.");
            } else {
                throw new ServletException(e);
            }
        }
    }
}
