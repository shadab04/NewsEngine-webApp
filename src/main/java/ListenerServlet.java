import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql;
import java.sql.Connection;

public class ListenerServlet extends HttpServlet
    {
        public void service(HttpServletRequest  req, HttpServletResponse res)
        {

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<html><body>");
            ServletContext ctx=getServletContext();
            Connection c=(Connection) ctx.getAttribute("con");
            try
            {
//Thread.sleep(15000);
            }
            catch(Exception e){}
            out.println("</body></html>");
        }
        public void destroy(){}
        public ServletConfig getServletConfig()
        {
            return null;
        }
        public String getServletInfo(){
            return null;
        }

    }






}

}
