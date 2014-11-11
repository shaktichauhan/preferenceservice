package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * EntitlementsBrandAdvocate entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.sweeps.db.EntitlementsBrandAdvocate
 * @author MyEclipse Persistence Tools
 */
public class EntitlementsBrandAdvocateDAO implements IEntitlementsBrandAdvocateDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved EntitlementsBrandAdvocate entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EntitlementsBrandAdvocateDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsBrandAdvocate entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(EntitlementsBrandAdvocate entity) {
		EntityManagerHelper.log("saving EntitlementsBrandAdvocate instance", Level.INFO,
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
	 * Delete a persistent EntitlementsBrandAdvocate entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EntitlementsBrandAdvocateDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsBrandAdvocate entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(EntitlementsBrandAdvocate entity) {
		EntityManagerHelper.log("deleting EntitlementsBrandAdvocate instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(EntitlementsBrandAdvocate.class,
					entity.getProductId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved EntitlementsBrandAdvocate entity and return it or a copy
	 * of it to the sender. A copy of the EntitlementsBrandAdvocate entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = EntitlementsBrandAdvocateDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsBrandAdvocate entity to update
	 * @return EntitlementsBrandAdvocate the persisted EntitlementsBrandAdvocate entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public EntitlementsBrandAdvocate update(EntitlementsBrandAdvocate entity) {
		EntityManagerHelper.log("updating EntitlementsBrandAdvocate instance",
				Level.INFO, null);
		try {
			EntitlementsBrandAdvocate result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public EntitlementsBrandAdvocate findById(String id) {
		EntityManagerHelper.log("finding EntitlementsBrandAdvocate instance with id: "
				+ id, Level.INFO, null);
		try {
			EntitlementsBrandAdvocate instance = getEntityManager().find(
					EntitlementsBrandAdvocate.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all EntitlementsBrandAdvocate entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EntitlementsBrandAdvocate property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<EntitlementsBrandAdvocate> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<EntitlementsBrandAdvocate> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding EntitlementsBrandAdvocate instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from EntitlementsBrandAdvocate model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<EntitlementsBrandAdvocate> findByProperties(String propertyName1,
			String propertyName2, final Object value1,
			final Object value2) {
		EntityManagerHelper.log(
				"finding EntitlementsBrandAdvocate instance with property1: "
						+ propertyName1 + ", value1: " + value1 + "property2: "
						+ propertyName2 + ", value2: " + value2 + "property3: "
						, Level.INFO,
				null);
		try {
			final String queryString = "select model from EntitlementsBrandAdvocate model where model."
					+ propertyName1
					+ "= :propertyValue1"
					+ " and model."
					+ propertyName2
					+ "= :propertyValue2";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all EntitlementsBrandAdvocate entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsBrandAdvocate> all EntitlementsBrandAdvocate entities
	 */
	@SuppressWarnings("unchecked")
	public List<EntitlementsBrandAdvocate> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all EntitlementsBrandAdvocate instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from EntitlementsBrandAdvocate model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}