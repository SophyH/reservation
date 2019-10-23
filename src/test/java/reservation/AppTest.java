package reservation;

import reservation.dao.DaoAeroport;
import reservation.dao.DaoAeroportFactory;
import reservation.dao.DaoClient;
import reservation.dao.DaoClientFactory;
import reservation.dao.DaoPassager;
import reservation.dao.DaoPassagerFactory;
import reservation.dao.DaoReservation;
import reservation.dao.DaoReservationFactory;
import reservation.dao.DaoVol;
import reservation.dao.DaoVolFactory;
import reservation.util.EntityManagerFactorySingleton;

public class AppTest {
	public static void main(String[] args) {

		DaoReservation daoReservation = DaoReservationFactory.getInstance();

		DaoClient daoClient = DaoClientFactory.getInstance();

		DaoPassager daoPassager = DaoPassagerFactory.getInstance();

		DaoVol daoVol = DaoVolFactory.getInstance();

		DaoAeroport daoAeroport = DaoAeroportFactory.getInstance();

		daoVol.findByKeyWithCompagnie((long) 1);

		EntityManagerFactorySingleton.close();

	}

}
