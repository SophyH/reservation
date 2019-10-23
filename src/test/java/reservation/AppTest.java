package reservation;

import reservation.dao.DaoPassager;
import reservation.dao.DaoPassagerFactory;
import reservation.dao.DaoReservation;
import reservation.dao.DaoReservationFactory;
import reservation.model.ClientEI;
import reservation.model.Passager;
import reservation.model.Reservation;
import reservation.util.EntityManagerFactorySingleton;

public class AppTest {
	public static void main(String[] args) {

		DaoReservation daoReservation = DaoReservationFactory.getInstance();

		Reservation r = new Reservation();
		r.setClient(new ClientEI());

		DaoPassager daoPassager = DaoPassagerFactory.getInstance();

		Passager p = new Passager();
		p.setNomPassager("huk");
		p.setPrenomPassager("sophie");

		daoPassager.insert(p);

		EntityManagerFactorySingleton.close();

	}

}
