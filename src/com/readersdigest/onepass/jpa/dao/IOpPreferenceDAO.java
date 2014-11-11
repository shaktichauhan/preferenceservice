package com.readersdigest.onepass.jpa.dao;

import java.util.List;

import com.readersdigest.onepass.jpa.OpPreference;
import com.readersdigest.onepass.jpa.OpPreferenceId;

/**
 * Interface for OpPreferenceDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpPreferenceDAO {
	/**
	 * Perform an initial save of a previously unsaved OpPreference entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPreferenceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPreference entity);

	/**
	 * Delete a persistent OpPreference entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPreferenceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPreference entity);

	/**
	 * Persist a previously saved OpPreference entity and return it or a copy of
	 * it to the sender. A copy of the OpPreference entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpPreferenceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPreference entity to update
	 * @return OpPreference the persisted OpPreference entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPreference update(OpPreference entity);

	public OpPreference findById(OpPreferenceId id);

	/**
	 * Find all OpPreference entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPreference property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPreference> found by query
	 */
	public List<OpPreference> findByProperty(String propertyName, Object value);

	public List<OpPreference> findByFlag(Object flag);

	/**
	 * Find all OpPreference entities.
	 * 
	 * @return List<OpPreference> all OpPreference entities
	 */
	public List<OpPreference> findAll();
}