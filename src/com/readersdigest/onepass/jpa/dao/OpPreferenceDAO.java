package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.readersdigest.onepass.jpa.EntityManagerHelper;
import com.readersdigest.onepass.jpa.OpPreference;
import com.readersdigest.onepass.jpa.OpPreferenceId;

/**
 * A data access object (DAO) providing persistence and search support for
 * OpPreference entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.onepass.jpa.OpPreference
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OpPreferenceDAO implements IOpPreferenceDAO {
	// property constants
	public static final String FLAG = "flag";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OpPreference entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPreferenceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPreference entity) {
		EntityManagerHelper.log("saving OpPreference instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OpPreference entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPreferenceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPreference entity) {
		EntityManagerHelper.log("deleting OpPreference instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(OpPreference.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OpPreference entity and return it or a copy of
	 * it to the sender. A copy of the OpPreference entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OpPreferenceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to update
	 * @return OpPreference the persisted OpPreference entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPreference update(OpPreference entity) {
		EntityManagerHelper.log("updating OpPreference instance", Level.INFO,
				null);
		try {
			OpPreference result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpPreference findById(OpPreferenceId id) {
		EntityManagerHelper.log("finding OpPreference instance with id: " + id,
				Level.INFO, null);
		try {
			OpPreference instance = getEntityManager().find(OpPreference.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OpPreference entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPreference property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPreference> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OpPreference> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding OpPreference instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from OpPreference model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<OpPreference> findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	/**
	 * Find all OpPreference entities.
	 * 
	 * @return List<OpPreference> all OpPreference entities
	 */
	@SuppressWarnings("unchecked")
	public List<OpPreference> findAll() {
		EntityManagerHelper.log("finding all OpPreference instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from OpPreference model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}