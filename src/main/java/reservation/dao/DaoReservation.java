package reservation.dao;

import java.util.List;

import reservation.model.Reservation;

public interface DaoReservation extends DaoGeneric<Reservation, Long> {

	Reservation findByKeyWithPassagers(Long key);

	List<Reservation> findAllWithPassagers();

	Reservation findByKeyWithVols(Long key);

	List<Reservation> findAllWithVols();

	Reservation findByKeyWithVolsAndPassagers(Long key);

	List<Reservation> findAllWithVolsAndPassagers();

	Reservation findByKeyWithClient(Long key);

	List<Reservation> findAllWithClient();

}
