package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TeamItem;

public class TeamItemHelper {
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("ConsoleSportsTeam");
	
	public void insertItem(TeamItem ti) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ti);
		em.getTransaction().commit();
		em.close();
	}
}
