package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.readersdigest.onepass.jpa.EntityManagerHelper;
import com.readersdigest.onepass.jpa.OpPreferenceDetail;

/**
 * A data access object (DAO) providing persistence and search support for
 * OpPreferenceDetail entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.onepass.jpa.OpPreferenceDetail
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OpPreferenceDetailDAO implements IOpPreferenceDetailDAO {
	// property constants
	public static final String DESCRIPTION = "description";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OpPreferenceDetail
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPreferenceDetailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPreferenceDetail entity) {
		EntityManagerHelper.log("saving OpPreferenceDetail instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OpPreferenceDetail entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpPreferenceDetailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPreferenceDetail entity) {
		EntityManagerHelper.log("deleting OpPreferenceDetail instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OpPreferenceDetail.class,
					entity.getPreferenceId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OpPreferenceDetail entity and return it or a
	 * copy of it to the sender. A copy of the OpPreferenceDetail entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OpPreferenceDetailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to update
	 * @return OpPreferenceDetail the persisted OpPreferenceDetail entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPreferenceDetail update(OpPreferenceDetail entity) {
		EntityManagerHelper.log("updating OpPreferenceDetail instance",
				Level.INFO, null);
		try {
			OpPreferenceDetail result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpPreferenceDetail findById(String id) {
		EntityManagerHelper.log("finding OpPreferenceDetail instance with id: "
				+ id, Level.INFO, null);
		try {
			OpPreferenceDetail instance = getEntityManager().find(
					OpPreferenceDetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OpPreferenceDetail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPreferenceDetail property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPreferenceDetail> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OpPreferenceDetail> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding OpPreferenceDetail instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from OpPreferenceDetail model where model."
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

	public List<OpPreferenceDetail> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/**
	 * Find all OpPreferenceDetail entities.
	 * 
	 * @return List<OpPreferenceDetail> all OpPreferenceDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<OpPreferenceDetail> findAll() {
		EntityManagerHelper.log("finding all OpPreferenceDetail instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from OpPreferenceDetail model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}