package reservation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import reservation.model.Passager;
import reservation.model.Reservation;
import reservation.model.Vol;
import reservation.util.EntityManagerFactorySingleton;

class DaoReservationJpaImpl implements DaoReservation {

	@Override
	public void insert(Reservation obj) {
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Reservation update(Reservation obj) {
		Reservation r = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			r = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return r;
	}

	@Override
	public void delete(Reservation obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Reservation r = em.merge(obj);
			for (Passager p : r.getPassagers()) {
				p.setReservation(null);
			}
			for (Vol v : r.getVols()) {
				v.setReservation(null);
			}
			em.remove(r);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Reservation r = em.find(Reservation.class, key);
			for (Passager p : r.getPassagers()) {
				p.setReservation(null);
			}
			for (Vol v : r.getVols()) {
				v.setReservation(null);
			}
			em.remove(r);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Reservation findByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Reservation r = null;
		r = em.find(Reservation.class, key);
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Reservation> reservations = null;
		Query query = em.createQuery("from Reservation r");
		reservations = query.getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation findByKeyWithPassagers(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Reservation r = null;
		Query query = em.createNamedQuery("Reservation.findByKeyWithPassagers");
		query.setParameter("key", key);
		try {
			r = (Reservation) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAllWithPassagers() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Reservation> reservations = null;
		Query query = em.createNamedQuery("Reservation.findAllWithPassagers");
		reservations = query.getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation findByKeyWithVols(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Reservation r = null;
		Query query = em.createNamedQuery("Reservation.findByKeyWithVols");
		query.setParameter("key", key);
		try {
			r = (Reservation) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAllWithVols() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Reservation> reservations = null;
		Query query = em.createNamedQuery("Reservation.findAllWithVols");
		reservations = query.getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation findByKeyWithVolsAndPassagers(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Reservation r = null;
		Query query = em.createNamedQuery("Reservation.findByKeyWithVolsAndPassagers");
		query.setParameter("key", key);
		try {
			r = (Reservation) query.getSingleResult();
		} catch (NoResultException e) {

		}
		em.close();
		return r;
	}

	@Override
	public List<Reservation> findAllWithVolsAndPassagers() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Reservation> reservations = null;
		Query query = em.createNamedQuery("Reservation.findAllWithVolsAndPassagers");
		reservations = query.getResultList();
		em.close();
		return reservations;
	}

}
