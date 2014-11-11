package com.readersdigest.onepass.db;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Interface for EntitlementsBrandAdvocateDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEntitlementsBrandAdvocateDAO {
	
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
	 * IEntitlementsBrandAdvocateDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            EntitlementsBrandAdvocate entity to persist
	 */
	public void save(EntitlementsBrandAdvocate entity);

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
	 * IEntitlementsBrandAdvocateDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 *
	 * @param entity            EntitlementsBrandAdvocate entity to delete
	 */
	public void delete(EntitlementsBrandAdvocate entity);

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
	 * entity = IEntitlementsBrandAdvocateDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            EntitlementsBrandAdvocate entity to update
	 * @return EntitlementsBrandAdvocate the persisted EntitlementsBrandAdvocate entity instance,
	 *         may not be the same
	 */
	public EntitlementsBrandAdvocate update(EntitlementsBrandAdvocate entity);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the entitlements brand advocate
	 */
	public EntitlementsBrandAdvocate findById(String id);

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
	 *            count of results to return.
	 * @return List<EntitlementsBrandAdvocate> found by query
	 */
	public List<EntitlementsBrandAdvocate> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);
	
	/**
	 * Find by properties.
	 *
	 * @param propertyName1 the property name1
	 * @param propertyName2 the property name2
	 * @param propertyName3 the property name3
	 * @param value1 the value1
	 * @param value2 the value2
	 * @param value3 the value3
	 * @return the list
	 */
	public List<EntitlementsBrandAdvocate> findByProperties(String propertyName1,
			String propertyName2, final Object value1, final Object value2);

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
	public List<EntitlementsBrandAdvocate> findAll(int... rowStartIdxAndCount);
}