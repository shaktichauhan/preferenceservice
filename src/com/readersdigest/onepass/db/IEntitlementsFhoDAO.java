package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EntitlementsFhoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEntitlementsFhoDAO {
	/**
	 * Perform an initial save of a previously unsaved EntitlementsFho entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsFhoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsFho entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(EntitlementsFho entity);

	/**
	 * Delete a persistent EntitlementsFho entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsFhoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsFho entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(EntitlementsFho entity);

	/**
	 * Persist a previously saved EntitlementsFho entity and return it or a copy
	 * of it to the sender. A copy of the EntitlementsFho entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IEntitlementsFhoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsFho entity to update
	 * @return EntitlementsFho the persisted EntitlementsFho entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public EntitlementsFho update(EntitlementsFho entity);

	public EntitlementsFho findById(String id);

	/**
	 * Find all EntitlementsFho entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EntitlementsFho property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsFho> found by query
	 */
	public List<EntitlementsFho> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all EntitlementsFho entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsFho> all EntitlementsFho entities
	 */
	public List<EntitlementsFho> findAll(int... rowStartIdxAndCount);
}