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
 * Servlet implementation class EditLeaguesServlet
 */
@WebServlet("/editLeaguesServlet")
public class EditLeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeaguesServlet() {
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
		TeamItemHelper tih = new TeamItemHelper();
		PlayerHelper ph = new PlayerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		League leagueToUpdate = dao.searchForLeagueById(tempId);
		
		String newLeageName = request.getParameter("leagueName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String playerName = request.getParameter("playerName");
		
		Player newPlayer = ph.findPlayer(playerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException ex)
		{
			ld = LocalDate.now();
		}
		
		try
		{
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<TeamItem> selectedItemsInLeague = new ArrayList<TeamItem>();
			
			for(int i = 0; i < selectedItems.length; i ++)
			{
				System.out.println(selectedItems[i]);
				TeamItem ti = tih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInLeague.add(ti);
			}
			leagueToUpdate.setListOfItems(selectedItemsInLeague);
		}
		catch(NullPointerException ex)
		{
			List<TeamItem> selecetedItemsInLeague = new ArrayList<TeamItem>();
			leagueToUpdate.setListOfItems(selecetedItemsInLeague);
		}
		
		leagueToUpdate.setLeagueName(newLeageName);
		leagueToUpdate.setStartDate(ld);
		leagueToUpdate.setPlayer(newPlayer);
		
		dao.updateLeague(leagueToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListServlet").forward(request, response);
	}

}
