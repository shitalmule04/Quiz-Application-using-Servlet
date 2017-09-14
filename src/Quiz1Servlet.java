

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Quiz1Servlet
 */
public class Quiz1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz1Servlet() {
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
PrintWriter pw=response.getWriter();
		
		HttpSession session=request.getSession();
		HttpSession Answ1=request.getSession();
		int result=0;
		try
		{
			if(session.getAttribute("User")!=null||session.getAttribute("Pass")!=null)
			{
				if(request.getParameter("ans_q1")!=null)
				{
					String Q1=(String)request.getParameter("ans_q1");
					if(Q1.equals("Macintosh"))
					{
						result++;
					}
			
				}
				
				if(request.getParameter("ans_q2")!=null)
				{
					String Q2=(String)request.getParameter("ans_q2");
				
					if(Q2.equals("tee"))
					{
						result++;
					}
					
				}
				if(request.getParameter("ans_q3")!=null)
				{
					String Q3=(String)request.getParameter("ans_q3");
					if(Q3.equals("Regular files"))
					{
						result++;
					}
					
				}
				pw.println(result);
				Answ1.setAttribute("ANSWER", result);
				
				response.sendRedirect("QuizPage2.html");
			}
			else
			{
				response.sendRedirect("LoginPage.html");
			}
			
		}
		catch(Exception exc)
		{
			
		}
	
	}

}
