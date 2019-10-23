package reservation.dao;

import java.util.List;

import reservation.model.Aeroport;

public interface DaoAeroport extends DaoGeneric<Aeroport, Integer> {
	
	public Aeroport findByKeyWithVille(Integer key);
	
	public List<Aeroport> findAllWithVille();
	
	public Aeroport findByKeyWithEscale(Integer key);
	
	public List<Aeroport> findAllWithEscale();

}
