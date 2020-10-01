package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TeamItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables that request the inputs of the user
		String city = request.getParameter("city");
		String nickName = request.getParameter("team");
		String numOfPlayers = request.getParameter("numOfPlayers");
		//Using the model and controller to add input to a table
		TeamItem li = new TeamItem(city, nickName, Integer.parseInt(numOfPlayers));
		TeamItemHelper dao = new TeamItemHelper();
		dao.insertItem(li);
		
		//Sends user back to the homepage to enter another store
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
