package reservation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import reservation.model.Aeroport;
import reservation.model.Vol;
import reservation.util.EntityManagerFactorySingleton;

public class DaoVolJpaImpl implements DaoVol{
	
	@Override
	public void insert(Vol obj) {
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
	public Vol update(Vol obj) {
		Vol s = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			s = em.merge(obj);
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
		return s;
	}

	@Override
	public void delete(Vol obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Vol s = em.merge(obj);
			for (Personne p : s.getPersonnes()) {
				p.setVol(null);
			}
			em.remove(s);
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
	public void deleteByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Vol v = em.find(Vol.class, key);
			for (Aeroport a : v.getAeroportArrivee()) {
				a.setVolArrivee(null);
			}
			em.remove(v);
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
	public Vol findByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Vol s = null;
		s = em.find(Vol.class, key);
		em.close();
		return s;
	}

	@Override
	public List<Vol> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> vols = null;
		Query query = em.createQuery("from vol v");
		vols = query.getResultList();
		em.close();
		return vols;
	}

}
