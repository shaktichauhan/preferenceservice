package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for BundleDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IBundleDAO {
	/**
	 * Perform an initial save of a previously unsaved Bundle entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IBundleDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Bundle entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Bundle entity);

	/**
	 * Delete a persistent Bundle entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IBundleDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Bundle entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Bundle entity);

	/**
	 * Persist a previously saved Bundle entity and return it or a copy of it to
	 * the sender. A copy of the Bundle entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IBundleDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Bundle entity to update
	 * @return Bundle the persisted Bundle entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Bundle update(Bundle entity);

	public Bundle findById(Integer id);

	/**
	 * Find all Bundle entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Bundle property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Bundle> found by query
	 */
	public List<Bundle> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Bundle> findByBundleName(Object bundleName,
			int... rowStartIdxAndCount);

	public List<Bundle> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<Bundle> findByPrice(Object price, int... rowStartIdxAndCount);

	/**
	 * Find all Bundle entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Bundle> all Bundle entities
	 */
	public List<Bundle> findAll(int... rowStartIdxAndCount);
}