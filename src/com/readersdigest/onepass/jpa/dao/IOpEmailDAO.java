package com.readersdigest.onepass.jpa.dao;

import java.util.List;

import com.readersdigest.onepass.jpa.OpEmail;
import com.readersdigest.onepass.jpa.OpEmailId;

/**
 * Interface for OpEmailDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpEmailDAO {
	/**
	 * Perform an initial save of a previously unsaved OpEmail entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpEmailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpEmail entity);

	/**
	 * Delete a persistent OpEmail entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpEmailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpEmail entity);

	/**
	 * Persist a previously saved OpEmail entity and return it or a copy of it
	 * to the sender. A copy of the OpEmail entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpEmailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpEmail entity to update
	 * @return OpEmail the persisted OpEmail entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpEmail update(OpEmail entity);

	public OpEmail findById(OpEmailId id);

	/**
	 * Find all OpEmail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpEmail property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpEmail> found by query
	 */
	public List<OpEmail> findByProperty(String propertyName, Object value);

	public List<OpEmail> findByPrimaryFlag(Object primaryFlag);

	/**
	 * Find all OpEmail entities.
	 * 
	 * @return List<OpEmail> all OpEmail entities
	 */
	public List<OpEmail> findAll();
}