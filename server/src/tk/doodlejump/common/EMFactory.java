package tk.doodlejump.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Factory for EntityManager's
 * @author Gleidson Moura
 *
 */
public class EMFactory {
	private static EntityManagerFactory emfInstance = null;

	private EMFactory() {

	}

	public static EntityManagerFactory get() {
		if(emfInstance == null) {
			emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
		}
		return emfInstance;
	}
}
