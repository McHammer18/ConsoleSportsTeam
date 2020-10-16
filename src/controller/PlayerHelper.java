package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleSportsTeam");
	
	public void insertPlayer(Player p)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
		return allPlayers;
	}
	
	//find player method
	public Player findPlayer(String nameToLookUp)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createNamedQuery("select ph from Player ph where ph.playerName = :selectedName", Player.class);
		
		typedQuery.setParameter("SelectedName", nameToLookUp);
		
		Player foundPlayer;
		try
		{
			foundPlayer = typedQuery.getSingleResult();
		}
		catch(NoResultException ex)
		{
			foundPlayer = new Player(nameToLookUp);
		}
		
		em.close();
		
		return foundPlayer;
	}
}
