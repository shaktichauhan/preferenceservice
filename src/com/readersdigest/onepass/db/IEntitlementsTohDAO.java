package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EntitlementsTohDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEntitlementsTohDAO {
	/**
	 * Perform an initial save of a previously unsaved EntitlementsToh entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsTohDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsToh entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(EntitlementsToh entity);

	/**
	 * Delete a persistent EntitlementsToh entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsTohDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsToh entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(EntitlementsToh entity);

	/**
	 * Persist a previously saved EntitlementsToh entity and return it or a copy
	 * of it to the sender. A copy of the EntitlementsToh entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IEntitlementsTohDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsToh entity to update
	 * @return EntitlementsToh the persisted EntitlementsToh entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public EntitlementsToh update(EntitlementsToh entity);

	public EntitlementsToh findById(String id);

	/**
	 * Find all EntitlementsToh entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EntitlementsToh property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsToh> found by query
	 */
	public List<EntitlementsToh> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all EntitlementsToh entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsToh> all EntitlementsToh entities
	 */
	public List<EntitlementsToh> findAll(int... rowStartIdxAndCount);
}