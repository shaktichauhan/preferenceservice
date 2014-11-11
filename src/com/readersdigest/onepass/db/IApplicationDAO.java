package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for ApplicationDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IApplicationDAO {
	/**
	 * Perform an initial save of a previously unsaved Application entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IApplicationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Application entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Application entity);

	/**
	 * Delete a persistent Application entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IApplicationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Application entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Application entity);

	/**
	 * Persist a previously saved Application entity and return it or a copy of
	 * it to the sender. A copy of the Application entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IApplicationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Application entity to update
	 * @return Application the persisted Application entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Application update(Application entity);

	public Application findById(Integer id);

	/**
	 * Find all Application entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Application property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Application> found by query
	 */
	public List<Application> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Application> findByApplicationName(Object applicationName,
			int... rowStartIdxAndCount);

	public List<Application> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<Application> findByCountryCode(Object countryCode,
			int... rowStartIdxAndCount);

	/**
	 * Find all Application entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Application> all Application entities
	 */
	public List<Application> findAll(int... rowStartIdxAndCount);
}