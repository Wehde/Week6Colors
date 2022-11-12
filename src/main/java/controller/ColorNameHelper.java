/**
 * @author Kilian Wehde - kewehde
 * CIS175 - Fall 2022
 * Oct 1, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ColorName;

public class ColorNameHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6Colors");
	
	public void insertName(ColorName name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(name);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ColorName> getAllNames(){
		EntityManager em = emfactory.createEntityManager();
		List<ColorName> allNames = em.createQuery("SELECT name FROM ColorName name ORDER BY name.hexColor.hexColor, name.name", ColorName.class).getResultList();
		em.close();
		return allNames;
	}
	
	public void deleteName(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ColorName> typedQuery = em.createQuery("SELECT name FROM ColorName name WHERE name.id = :selectedName", ColorName.class);
		
		typedQuery.setParameter("selectedName", id);
		typedQuery.setMaxResults(1);
		ColorName result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
