package reservation.dao;

import java.util.List;

import reservation.model.Reservation;

public interface DaoReservation extends DaoGeneric<Reservation, Long> {

	DaoReservation findByKeyWithPassagers(Long key);

	List<DaoReservation> findAllWithPassagers();

	DaoReservation findByKeyWithVols(Long key);

	List<DaoReservation> findAllWithVols();

	DaoReservation findByKeyWithVolsAndPassagers(Long key);

	List<DaoReservation> findAllWithVolsAndPassagers();

}
