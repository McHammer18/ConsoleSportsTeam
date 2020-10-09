package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/ListNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		LeagueHelper dao = new LeagueHelper();
		String act = request.getParameter("doThisToList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllListServlet").forward(request, response);
			
		}
		else if (act.equals("delete")) {
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				League leagueToDelete = dao.searchForLeagueById(tempId);
				
				dao.deleteLeague(leagueToDelete);
			}
			catch(NumberFormatException e)
			{
				System.out.println("Forgot to click a button");
			}
			finally {
				getServletContext().getRequestDispatcher("/viewAllListServlet").forward(request, response);
			}
		}
		
		else if (act.contentEquals("edit"))
		{
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				League leagueToEdit = dao.searchForLeagueById(tempId);
				request.setAttribute("leagueToEdit", leagueToEdit);
				
				request.setAttribute("month",  leagueToEdit.getStartDate().getMonthValue());
				request.setAttribute("day",  leagueToEdit.getStartDate().getDayOfMonth());
				request.setAttribute("year",  leagueToEdit.getStartDate().getYear());
				
				LeagueHelper daoForItems = new LeagueHelper();
				
				request.setAttribute("allLeagues", daoForItems.showAllLeagues());
				
				if(daoForItems.showAllLeagues().isEmpty())
				{
					request.setAttribute("allLeagues", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
				
			}
			catch(NumberFormatException e)
			{
				getServletContext().getRequestDispatcher("/viewAllListServlet").forward(request, response);
			}
		}
		else if(act.contentEquals("add"))
		{
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	}

}
