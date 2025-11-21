package com.example.newsapp.auth;

import org.mindrot.jbcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifier = req.getParameter("identifier"); // username or email
        String password = req.getParameter("password");

        if (identifier == null || password == null || identifier.isBlank() || password.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid credentials.");
            return;
        }

        try {
            Optional<UserRecord> userOpt = userDAO.findByUsernameOrEmail(identifier.trim());
            if (userOpt.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username/email or password.");
                return;
            }

            UserRecord user = userOpt.get();
            boolean matches = BCrypt.checkpw(password, user.getPasswordHash());

            if (!matches) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username/email or password.");
                return;
            }

            // Authentication success: create a session
            HttpSession session = req.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setMaxInactiveInterval(60 * 60 * 2); // 2 hours

            // Redirect to home (your app main page)
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

