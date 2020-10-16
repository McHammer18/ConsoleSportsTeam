package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;
import model.Player;
import model.TeamItem;

/**
 * Servlet implementation class CreateNewLeagueServlet
 */
@WebServlet("/createNewLeagueServlet")
public class CreateNewLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewLeagueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamItemHelper tih = new TeamItemHelper();
		String leagueName = request.getParameter("leagueName");
		System.out.println("League Name: " + leagueName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String playerName = request.getParameter("playerName");
		LocalDate ld;
		
		try
		{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<TeamItem> selectedItemsInLeague = new ArrayList<TeamItem>();
		
		if (selectedItems != null && selectedItems.length > 0)
		{
			for(int i = 0; i <selectedItems.length; i ++)
			{
				System.out.println(selectedItems[i]);
				TeamItem ti = tih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInLeague.add(ti);
			}
		}
		
		Player player = new Player(playerName);
		League l = new League(leagueName, ld, player);
		l.setListOfItems(selectedItemsInLeague);
		LeagueHelper lh = new LeagueHelper();
		lh.insertNewLeague(l);
		
		System.out.println("Success!");
		System.out.println(l.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
