

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String	Login_Username;
		String	Login_Password;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.length()==0||password.length()==0)
		{
			response.sendRedirect("LoginPage.html");
		}
		else
		{
			HttpSession session= request.getSession();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/quizapplication","root","123");
		    		Statement st=(Statement) con.createStatement();
		    		ResultSet rs=st.executeQuery("select * from login where emailid='"+username+"' and password='"+password+"'");
		    		
		    		while(rs.next())
					{
						Login_Username=rs.getString(1);
						Login_Password=rs.getString(2);
						if(Login_Username.length()==0)
						{					
							response.sendRedirect("LoginPage.html");
						}
						else
						{	
							session.setAttribute("User",Login_Username);
							session.setAttribute("Pass",Login_Password);
							response.sendRedirect("HomePage.html");							
						}
					}
				
				}
				catch(Exception e)
				{
					out.println("Class Not found "+e.toString());
				}
		}
	}

}
