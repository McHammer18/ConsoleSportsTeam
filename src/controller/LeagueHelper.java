package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.League;

public class LeagueHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleSportsTeam");
	
	public void insertNewLeague(League l)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<League> showAllLeagues()
	{
		EntityManager em = emfactory.createEntityManager();
		List<League> allLeagues = em.createNamedQuery("SELECT l FROM League l").getResultList();
		return allLeagues;
	}
	
	//Mehtod for deleteing list items
	public void deleteLeague(League toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<League> typedQuery = em.createNamedQuery("select league from League league where league.id = :selectedId", League.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		League result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//Method for searchinng by League ID
	public League searchForLeagueById(Integer tempId)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		League found = em.find(League.class, tempId);
		em.close();
		return found;
	}
	
	//method to update league
	public void updateLeague(League toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.clear();
	}
}
