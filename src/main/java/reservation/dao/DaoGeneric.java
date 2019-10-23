package reservation.dao;

import java.util.List;

public interface DaoGeneric <T, K> {
	void insert(T obj); // cette m�thode insert ne renvoie rien 
	
	T update (T obj);
	
	void delete (T obj);
	
	void deleteByKey (K key); // on d�finit un autre type K que l'on d�finira plus tard 
	
	T findByKey (K key);
	
	List <T> findAll();

}