/**
 * 
 */
package br.com.loteria.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Everton
 *
 */
public class JpaUtil {
	
	private static EntityManagerFactory factory; 
	
	static{
		factory = Persistence.createEntityManagerFactory("LoteriaPU");
	}

	public static EntityManager getEntityManager(){
		// Caso esteja fechada por outro processo, abre uma novamente
		if(!factory.isOpen()){
			factory = Persistence.createEntityManagerFactory("LoteriaPU");
		}
		
		return factory.createEntityManager();
	}
	
	public static void close(){
		factory.close();
	}

}
