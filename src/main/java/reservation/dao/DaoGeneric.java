package reservation.dao;

import java.util.List;

public interface DaoGeneric <T, K> {
	void insert(T obj); // cette méthode insert ne renvoie rien 
	
	T update (T obj);
	
	void delete (T obj);
	
	void deleteByKey (K key); // on définit un autre type K que l'on définira plus tard 
	
	T findByKey (K key);
	
	List <T> findAll();

}