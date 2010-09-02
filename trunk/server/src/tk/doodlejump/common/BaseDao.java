package tk.doodlejump.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.jdo.PersistenceManager;

import tk.doodlejump.pmf.PMF;

/**
 * DBA common manage class
 * 
 * @author Yongxiu
 * 
 */

public class BaseDao <E, K> {

	private Class<E> EClass = null;
	
    public boolean create(E entity) {
    	PersistenceManager pm = PMF.get().getPersistenceManager();

        try {
            pm.makePersistent(entity);
        } finally {
            pm.close();
        }
    	return true;
    }


    public boolean delete(K key) {
    	return true;
    }

    public List<E> getAllEntity() {
    	return null;
    }


    public E getById(K key) {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	
    	E e = pm.getObjectById(getEClass(), key);
    	
    	return e;
    }

	@SuppressWarnings("unchecked")
	private Class<E> getEClass(){
        if(EClass == null) {
                ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
                EClass = (Class<E>) type.getActualTypeArguments()[0];
        }

        return EClass;
    }

    public void update(E entity) {
    	
    }
	
}
