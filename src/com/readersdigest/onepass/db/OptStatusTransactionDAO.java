package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * OptStatusTransaction entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.OptStatusTransaction
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OptStatusTransactionDAO implements IOptStatusTransactionDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OptStatusTransaction
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OptStatusTransactionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OptStatusTransaction entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OptStatusTransaction entity) {
		EntityManagerHelper.log("saving OptStatusTransaction instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OptStatusTransaction entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OptStatusTransactionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OptStatusTransaction entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OptStatusTransaction entity) {
		EntityManagerHelper.log("deleting OptStatusTransaction instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OptStatusTransaction.class, entity.getOptStatusTransactionId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OptStatusTransaction entity and return it or a
	 * copy of it to the sender. A copy of the OptStatusTransaction entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OptStatusTransactionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OptStatusTransaction entity to update
	 * @return OptStatusTransaction the persisted OptStatusTransaction entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OptStatusTransaction update(OptStatusTransaction entity) {
		EntityManagerHelper.log("updating OptStatusTransaction instance", Level.INFO, null);
		try {
			OptStatusTransaction result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OptStatusTransaction findById(Integer id) {
		EntityManagerHelper.log("finding OptStatusTransaction instance with id: " + id, Level.INFO, null);
		try {
			OptStatusTransaction instance = getEntityManager().find(OptStatusTransaction.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	
	public OptStatusTransaction refresh(OptStatusTransaction entity) {
		EntityManagerHelper.log("refresh OptStatusTransaction instance", Level.INFO, null);
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
	 * Find all OptStatusTransaction entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OptStatusTransaction property to query
	 * @param value
	 *            the property value to match
	 * @return List<OptStatusTransaction> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OptStatusTransaction> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding OptStatusTransaction instance with property: " + propertyName + ", value: "
				+ value, Level.INFO, null);
		try {
			final String queryString = "select model from OptStatusTransaction model where model." + propertyName
					+ "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OptStatusTransaction entities with a specific properties value
	 * in descending optStatusTransactionId order.
	 * 
	 * @param propertyName1
	 *            the name of the OptStatusTransaction property to query
	 * @param propertyName2
	 *            the name of the OptStatusTransaction property to query
	 * @param value1
	 *            the property value1 to match
	 * @param value2
	 *            the property value1 to match
	 * @return List<OptStatusTransaction> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OptStatusTransaction> findByProperties(String propertyName1, String propertyName2, final Object value1,
			final Object value2) {
		EntityManagerHelper.log("finding OptStatusTransaction instance with property1: " + propertyName1 + ", value1: "
				+ value1 + "property2: " + propertyName2 + ", value2: " + value2, Level.INFO, null);
		try {
			final String queryString = "select model from OptStatusTransaction model where model." + propertyName1
					+ "= :propertyValue1" + " and model." + propertyName2
					+ "= :propertyValue2 order by model.optStatusTransactionId desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OptStatusTransaction entities.
	 * 
	 * @return List<OptStatusTransaction> all OptStatusTransaction entities
	 */
	@SuppressWarnings("unchecked")
	public List<OptStatusTransaction> findAll() {
		EntityManagerHelper.log("finding all OptStatusTransaction instances", Level.INFO, null);
		try {
			final String queryString = "select model from OptStatusTransaction model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}