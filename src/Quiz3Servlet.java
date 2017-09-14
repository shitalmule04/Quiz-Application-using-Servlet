

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Quiz3Servlet
 */
public class Quiz3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz3Servlet() {
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
		HttpSession Answ3=request.getSession();
		int result2=0;
		try
		{
			if(session.getAttribute("User")!=null||session.getAttribute("Pass")!=null)
			{
				if(request.getParameter("ans7")!=null)
				{
					/* Ans:D. MS DOS */
					String Q7=(String)request.getParameter("ans7");
					if(Q7.equals("D"))
					{
						result2++;
					}
			
				}
				
				if(request.getParameter("ans8")!=null)
				{
					String Q8=(String)request.getParameter("ans8");
					/* Ans: A. Operating System */
					if(Q8.equals("A"))
					{
						result2++;
					}
					
				}
				if(request.getParameter("ans9")!=null)
				{
					String Q9=(String)request.getParameter("ans9");
					/* Ans :B. Operating system */
					if(Q9.equals("B"))
					{
						result2++;
					}
					
				}
				if(request.getParameter("ans10")!=null)
				{
					/* Ans : A. To make the most efficient use of the computer hardware  */
					String Q10=(String)request.getParameter("ans10");
					if(Q10.equals("A"))
					{
						result2++;
					}
					
				}
				result2+=(int)Answ3.getAttribute("ANSWER");
				
				Answ3.setAttribute("ANSWER", result2);
				//response.sendRedirect("QuizPage3.html");
			}
			else
			{
				response.sendRedirect("LoginPage.html");
			}
		
			
		}
		catch(Exception exc)
		{
			
		}
		
		
		pw.println("<html><head></head><body style=\"bg-clor: #f1e65f;\">");
		pw.println("<br><br><br><br>");
		pw.println("<font color=\"#6e141b\">");
		pw.println("<center><h1 style=\"border-style: groove; border-color: #074703 \">");
		pw.println("<br>");
		pw.println("UserName : "+session.getAttribute("User")+"\n");
		pw.println("");
		pw.println("<br>You Scored "+result2+ " out of 10 ");
		pw.println("</font>");
		session.invalidate();
		pw.println("<br><a href=\"LoginPage.html\" >Log out</a>");
		pw.println("<br>");
		pw.println("</h1></center>");
		pw.println("<br>");
		pw.println("</body></html>");
		
	}

}
