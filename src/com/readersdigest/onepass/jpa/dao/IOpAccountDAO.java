package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.Set;

import com.readersdigest.onepass.jpa.OpAccount;
import com.readersdigest.onepass.jpa.OpAccountId;

/**
 * Interface for OpAccountDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpAccountDAO {
	/**
	 * Perform an initial save of a previously unsaved OpAccount entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpAccountDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAccount entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpAccount entity);

	/**
	 * Delete a persistent OpAccount entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpAccountDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpAccount entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpAccount entity);

	/**
	 * Persist a previously saved OpAccount entity and return it or a copy of it
	 * to the sender. A copy of the OpAccount entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpAccountDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAccount entity to update
	 * @return OpAccount the persisted OpAccount entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpAccount update(OpAccount entity);

	public OpAccount findById(OpAccountId id);

	/**
	 * Find all OpAccount entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpAccount property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpAccount> found by query
	 */
	public List<OpAccount> findByProperty(String propertyName, Object value);

	public List<OpAccount> findByPassword(Object password);

	/**
	 * Find all OpAccount entities.
	 * 
	 * @return List<OpAccount> all OpAccount entities
	 */
	public List<OpAccount> findAll();
}