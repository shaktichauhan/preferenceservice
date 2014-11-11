package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.readersdigest.onepass.jpa.EntityManagerHelper;
import com.readersdigest.onepass.jpa.OpPerson;

/**
 * A data access object (DAO) providing persistence and search support for
 * OpPerson entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.jpa.OpPerson
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OpPersonDAO implements IOpPersonDAO {
	// property constants
	public static final String FIRST_NM = "firstNm";
	public static final String LAST_NM = "lastNm";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OpPerson entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPersonDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPerson entity) {
		EntityManagerHelper.log("saving OpPerson instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpPerson refresh(OpPerson entity) {
		EntityManagerHelper.log("refresh OpPerson instance", Level.INFO, null);
		try {
			getEntityManager().refresh(entity);
			EntityManagerHelper.log("refresh successful", Level.INFO, null);
			return entity;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("refresh failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OpPerson entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPersonDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPerson entity) {
		EntityManagerHelper.log("deleting OpPerson instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OpPerson.class, entity.getPersonId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OpPerson entity and return it or a copy of it
	 * to the sender. A copy of the OpPerson entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OpPersonDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to update
	 * @return OpPerson the persisted OpPerson entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPerson update(OpPerson entity) {
		EntityManagerHelper.log("updating OpPerson instance", Level.INFO, null);
		try {
			OpPerson result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpPerson findById(Integer id) {
		EntityManagerHelper.log("finding OpPerson instance with id: " + id, Level.INFO, null);
		try {
			OpPerson instance = getEntityManager().find(OpPerson.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OpPerson entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPerson property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPerson> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OpPerson> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding OpPerson instance with property: " + propertyName + ", value: " + value,
				Level.INFO, null);
		try {
			final String queryString = "select model from OpPerson model where model." + propertyName
					+ "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	public List<OpPerson> findByFirstNm(Object firstNm) {
		return findByProperty(FIRST_NM, firstNm);
	}

	public List<OpPerson> findByLastNm(Object lastNm) {
		return findByProperty(LAST_NM, lastNm);
	}

	/**
	 * Find all OpPerson entities.
	 * 
	 * @return List<OpPerson> all OpPerson entities
	 */
	@SuppressWarnings("unchecked")
	public List<OpPerson> findAll() {
		EntityManagerHelper.log("finding all OpPerson instances", Level.INFO, null);
		try {
			final String queryString = "select model from OpPerson model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
