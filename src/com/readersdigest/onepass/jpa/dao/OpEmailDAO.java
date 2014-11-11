package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.readersdigest.onepass.jpa.EntityManagerHelper;
import com.readersdigest.onepass.jpa.OpEmail;
import com.readersdigest.onepass.jpa.OpEmailId;

/**
 * A data access object (DAO) providing persistence and search support for
 * OpEmail entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.jpa.OpEmail
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OpEmailDAO implements IOpEmailDAO {
	// property constants
	public static final String PRIMARY_FLAG = "primaryFlag";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OpEmail entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpEmailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpEmail entity) {
		EntityManagerHelper.log("saving OpEmail instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OpEmail entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpEmailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpEmail entity) {
		EntityManagerHelper.log("deleting OpEmail instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OpEmail.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OpEmail entity and return it or a copy of it
	 * to the sender. A copy of the OpEmail entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OpEmailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to update
	 * @return OpEmail the persisted OpEmail entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpEmail update(OpEmail entity) {
		EntityManagerHelper.log("updating OpEmail instance", Level.INFO, null);
		try {
			OpEmail result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpEmail findById(OpEmailId id) {
		EntityManagerHelper.log("finding OpEmail instance with id: " + id,
				Level.INFO, null);
		try {
			OpEmail instance = getEntityManager().find(OpEmail.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OpEmail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpEmail property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpEmail> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OpEmail> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding OpEmail instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from OpEmail model where model."
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

	public List<OpEmail> findByPrimaryFlag(Object primaryFlag) {
		return findByProperty(PRIMARY_FLAG, primaryFlag);
	}

	/**
	 * Find all OpEmail entities.
	 * 
	 * @return List<OpEmail> all OpEmail entities
	 */
	@SuppressWarnings("unchecked")
	public List<OpEmail> findAll() {
		EntityManagerHelper.log("finding all OpEmail instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from OpEmail model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}