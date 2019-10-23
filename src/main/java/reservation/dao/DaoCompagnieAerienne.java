package reservation.dao;

import java.util.List;

import reservation.model.CompagnieAerienne;

public interface DaoCompagnieAerienne extends DaoGeneric<CompagnieAerienne, Long> {

	CompagnieAerienne findByKeyWithVols(Long key);

	List<CompagnieAerienne> findAllWithVols(Long key);

}
