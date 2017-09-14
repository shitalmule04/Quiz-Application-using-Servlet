

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(30);
		
		try
		{
			if(session.getAttribute("User")==null||session.getAttribute("Pass")==null)
			{
				if(request.getParameter("agree")!=null)
				{
					response.sendRedirect("QuizPage1.html");
				}
				else
				{
					response.sendRedirect("HomePage.html");
				}
			}
			else
			{
				response.sendRedirect("QuizPage1.html");
			}
			
			
		}catch(Exception excp)
		{
			
			response.sendRedirect("HomePage.html");
		}
	}

}
