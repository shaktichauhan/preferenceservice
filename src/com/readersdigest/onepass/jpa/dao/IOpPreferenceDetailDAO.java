package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.Set;

import com.readersdigest.onepass.jpa.OpPreferenceDetail;

/**
 * Interface for OpPreferenceDetailDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpPreferenceDetailDAO {
	/**
	 * Perform an initial save of a previously unsaved OpPreferenceDetail
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPreferenceDetailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPreferenceDetail entity);

	/**
	 * Delete a persistent OpPreferenceDetail entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPreferenceDetailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPreferenceDetail entity);

	/**
	 * Persist a previously saved OpPreferenceDetail entity and return it or a
	 * copy of it to the sender. A copy of the OpPreferenceDetail entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpPreferenceDetailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreferenceDetail entity to update
	 * @return OpPreferenceDetail the persisted OpPreferenceDetail entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPreferenceDetail update(OpPreferenceDetail entity);

	public OpPreferenceDetail findById(String id);

	/**
	 * Find all OpPreferenceDetail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPreferenceDetail property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPreferenceDetail> found by query
	 */
	public List<OpPreferenceDetail> findByProperty(String propertyName,
			Object value);

	public List<OpPreferenceDetail> findByDescription(Object description);

	/**
	 * Find all OpPreferenceDetail entities.
	 * 
	 * @return List<OpPreferenceDetail> all OpPreferenceDetail entities
	 */
	public List<OpPreferenceDetail> findAll();
}