package com.readersdigest.onepass.db;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for EmailValidDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEmailValidDAO {
	/**
	 * Perform an initial save of a previously unsaved EmailValid entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEmailValidDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(EmailValid entity);
	
	
    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the EmailValid
     */
    public EmailValid refresh(EmailValid entity);

	/**
	 * Delete a persistent EmailValid entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEmailValidDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(EmailValid entity);

	/**
	 * Persist a previously saved EmailValid entity and return it or a copy of
	 * it to the sender. A copy of the EmailValid entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IEmailValidDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to update
	 * @return EmailValid the persisted EmailValid entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public EmailValid update(EmailValid entity);

	public EmailValid findById(Integer id);

	/**
	 * Find all EmailValid entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EmailValid property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EmailValid> found by query
	 */
	public List<EmailValid> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);
	
	public List<EmailValid> findByProperties(String propertyName1, String propertyName2, final Object value1, final Object value2);


	public List<EmailValid> findByToken(Object token,
			int... rowStartIdxAndCount);

	public List<EmailValid> findByValid(Object valid,
			int... rowStartIdxAndCount);

	/**
	 * Find all EmailValid entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EmailValid> all EmailValid entities
	 */
	public List<EmailValid> findAll(int... rowStartIdxAndCount);
}