package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import appLayer.user;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user userobject = new user();

        request.setAttribute("username",request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        if (userobject.isValidCredentials(request.getParameter("loginname"),request.getParameter("password"))){
            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }
        else{
            request.setAttribute("errorMessage", "Invalid login or password, try again");
            request.getRequestDispatcher("/login.jsp").forward(request,response);


        }

        request.getRequestDispatcher("/welcome.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doGet-version");
        out.print("login-name" + request.getParameter("loginname") + "Password:" + request.getParameter("password"));
    }
}
