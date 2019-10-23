package reservation;

import reservation.dao.DaoPassager;
import reservation.dao.DaoPassagerFactory;
import reservation.model.Passager;
import reservation.util.EntityManagerFactorySingleton;

public class AppTest {
	public static void main(String[] args) {

		DaoPassager daoPassager = DaoPassagerFactory.getInstance();

		Passager p = new Passager();
		p.setNomPassager("huk");
		p.setPrenomPassager("sophie");

		daoPassager.insert(p);

		EntityManagerFactorySingleton.close();

	}

}
