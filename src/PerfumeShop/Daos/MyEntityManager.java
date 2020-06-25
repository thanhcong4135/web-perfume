package PerfumeShop.Daos;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance;
	private EntityManager em;
	
	public MyEntityManager() {
		em = Persistence.createEntityManagerFactory("ShopPerfume").createEntityManager();
	}
	
	public static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
}
