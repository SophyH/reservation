package reservation;

import reservation.dao.DaoClient;
import reservation.dao.DaoClientFactory;
import reservation.dao.DaoPassager;
import reservation.dao.DaoPassagerFactory;
import reservation.dao.DaoReservation;
import reservation.dao.DaoReservationFactory;
import reservation.util.EntityManagerFactorySingleton;

public class AppTest {
	public static void main(String[] args) {

		DaoReservation daoReservation = DaoReservationFactory.getInstance();

		DaoClient daoClient = DaoClientFactory.getInstance();

		DaoPassager daoPassager = DaoPassagerFactory.getInstance();

		EntityManagerFactorySingleton.close();

	}

}
