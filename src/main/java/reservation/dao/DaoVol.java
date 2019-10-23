package reservation.dao;

import java.util.List;

import reservation.model.Vol;

public interface DaoVol extends DaoGeneric<Vol, Integer> {
	
	public Vol findByKeyWithReservation(Integer key) ;
	
	public List<Vol> findAllWithReservation();
	
	public Vol findByKeyWithEscale(Integer key) ;
	
	public List<Vol> findAllWithEscale();
	
	public Vol findByKeyWithCompagnie(Integer key) ;
	
	public List<Vol> findAllWithCompagnie();
	
	public Vol findByKeyWithAeroport(Integer key) ;
	
	public List<Vol> findAllWithAeroport();

}
