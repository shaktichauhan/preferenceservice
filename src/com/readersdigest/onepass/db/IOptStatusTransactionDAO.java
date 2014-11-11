package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for OptStatusTransactionDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOptStatusTransactionDAO {
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
	 * IOptStatusTransactionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OptStatusTransaction entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OptStatusTransaction entity);

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
	 * IOptStatusTransactionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OptStatusTransaction entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OptStatusTransaction entity);

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
	 * entity = IOptStatusTransactionDAO.update(entity);
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
	public OptStatusTransaction update(OptStatusTransaction entity);

	public OptStatusTransaction findById(Integer id);
	
	public OptStatusTransaction refresh(OptStatusTransaction entity);

	/**
	 * Find all OptStatusTransaction entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OptStatusTransaction property to query
	 * @param value
	 *            the property value to match
	 * @return List<OptStatusTransaction> found by query
	 */
	public List<OptStatusTransaction> findByProperty(String propertyName, Object value);

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
	public List<OptStatusTransaction> findByProperties(String propertyName1, String propertyName2, final Object value1,
			final Object value2);

	/**
	 * Find all OptStatusTransaction entities.
	 * 
	 * @return List<OptStatusTransaction> all OptStatusTransaction entities
	 */
	public List<OptStatusTransaction> findAll();
}