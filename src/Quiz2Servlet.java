

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Quiz2Servlet
 */
public class Quiz2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz2Servlet() {
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
		HttpSession Answ2=request.getSession();
		int result2=0;
		try {
			if(session.getAttribute("User")!=null||session.getAttribute("Pass")!=null)
			{
				if(request.getParameter("ans_q4")!=null)
				{
					String Q1=(String)request.getParameter("ans_q4");
					if(Q1.equals("System Calls"))
					{
						result2++;
						
					}
			
				}
				
				if(request.getParameter("ans_q5")!=null)
				{
					String Q2=(String)request.getParameter("ans_q5");
					if(Q2.equals("all of the mentioned"))
					{
						result2++;
					}
					
				}
				if(request.getParameter("ans_q6")!=null)
				{
					String Q3=(String)request.getParameter("ans_q6");
					if(Q3.equals("device driver filesystem"))
					{
						result2++;
					}
					
				}
				/*pw.println("Before Adding previuos Result is  :"+result2);*/
				result2+=(int)Answ2.getAttribute("ANSWER");
				/*pw.println("After Adding previuos Result is  :"+result2);*/
				Answ2.setAttribute("ANSWER", result2);
				response.sendRedirect("QuizPage3.html");
			}
			else
			{
				response.sendRedirect("LoginPage.html");
			}
		}
		catch(Exception e)
		{
			
		}
	}

}
