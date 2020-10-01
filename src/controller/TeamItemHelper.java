package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TeamItem;

public class TeamItemHelper {
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("ConsoleSportsTeam");
	//Method to insert new items to the table
	public void insertItem(TeamItem ti) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ti);
		em.getTransaction().commit();
		em.close();
	}
	//Method to show all items in the table
	public List<TeamItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<TeamItem> allItems = em.createQuery("SELECT i FROM TeamItem i").getResultList();
		return allItems;
	}
	
	public	void	deleteItem(TeamItem	toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TeamItem> typedQuery = em.createQuery("select ti	from TeamItem ti where ti.city = :selectedCity and ti.nickName = :selectedNickName and ti.numOfPlayers = :selectedNumOfPlayers", TeamItem.class);
		
		typedQuery.setParameter("selectedCity",	toDelete.getCity());
		typedQuery.setParameter("selectedNickName",	toDelete.getNickName());
		typedQuery.setParameter("selectedNumOfPlayers", toDelete.getNumOfPlayers());
		
		//gives one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		TeamItem result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	public List<TeamItem> searchForItemByCity(String cityName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TeamItem> typedQuery	= em.createQuery("select ti from TeamItem ti where ti.city = :selectedCity", TeamItem.class);
		typedQuery.setParameter("selectedCity",	cityName);
		List<TeamItem> foundItems =	typedQuery.getResultList();
		em.close();
		return	foundItems;
		}
	public List<TeamItem> searchforItemByNickName(String nickName) {
		EntityManager em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TeamItem> typedQuery = em.createQuery("select ti from TeamItem ti where ti.nickName = :selectedNickName",	TeamItem.class);
		typedQuery.setParameter("selectedNickName",	nickName);
		List<TeamItem> foundItems =	typedQuery.getResultList();
		em.close();
		return	foundItems;
	}
	public TeamItem searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TeamItem found = em.find(TeamItem.class, idToEdit);
		em.close();
		return	found;
	}
	public void updateItem(TeamItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	public void cleanUp() {
		emfactory.close();
	}
	
	
}
