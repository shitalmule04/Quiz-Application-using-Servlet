

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import java.sql.*;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		String Enrollment=request.getParameter("enrollment");
		String Name=request.getParameter("_name");
		String _Class=request.getParameter("_Class");
		String Dept=request.getParameter("dept");
		String mobile=request.getParameter("mobileReg");
		String password=request.getParameter("password");
		String Email=request.getParameter("Email");
		String conpass=request.getParameter("passwdReg2");
		int Roll_no=0;
		try
		{
			Roll_no=Integer.parseInt(Enrollment);
		}catch(Exception e) {
			out.println("The value that you have Entered  in Enrollment field is not an number");
			
		}
		if(!password.equals(conpass))
		{
			JOptionPane.showMessageDialog(null,"Password field and confirm password should be same..!!");
			response.sendRedirect("RegistrationPage.html");
		
		if(mobile.length()==0||password.length()==0||(Name.length()==0)||(Dept.equals("none"))||(_Class.equals("none"))||Roll_no==0||Email.length()==0)
		{
			out.println("<html><body>");
			out.println("<script> alert('Please Make sure That you fill all the fileds')</script>");
			out.println("</body></html>");
			response.sendRedirect("RegistrationPage.html");
		}
		}
		else
		{
			HttpSession session= request.getSession();
			if(session.getAttribute("Uname")!=null||session.getAttribute("passw")!=null)
			{
				out.println("<h4 style=\"color:red\">You have Already Registered</h4>");
				response.sendRedirect("LoginPage.html");
			}
			else
			{	
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/quizapplication","root","123");
					Statement statement=con.createStatement();
					int result=statement.executeUpdate("insert into login values('"+Name+"','"+Email+"','"+password+"','"+mobile+"','"+_Class+"','"+Dept+"')");
					if(result>0)
					{
						session.setAttribute("Uname", Name);
						session.setAttribute("passw",password);
						out.println("<script>alert('Successfully Registered')</script>");
						response.sendRedirect("RegistrationPage.html");
					}
					else
					{
						out.println("<h4 style=\"color:red\"></h4>");
						response.sendRedirect("RegistrationPage.html");
					}	
					
				}
			
				catch(ClassNotFoundException e)
				{
					out.println("Class Not found ");
				}
				catch(Exception excep)
				{
					out.println("Could not foud "+excep.toString());
				}
				
			}
		}
			
		}
	}

