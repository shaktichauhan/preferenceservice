package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.Set;

import com.readersdigest.onepass.jpa.OpPerson;

/**
 * Interface for OpPersonDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpPersonDAO {
	/**
	 * Perform an initial save of a previously unsaved OpPerson entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPersonDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpPerson entity);

	public OpPerson refresh(OpPerson entity);

	/**
	 * Delete a persistent OpPerson entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpPersonDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpPerson entity);

	/**
	 * Persist a previously saved OpPerson entity and return it or a copy of it
	 * to the sender. A copy of the OpPerson entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpPersonDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpPerson entity to update
	 * @return OpPerson the persisted OpPerson entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpPerson update(OpPerson entity);

	public OpPerson findById(Integer id);

	/**
	 * Find all OpPerson entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpPerson property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpPerson> found by query
	 */
	public List<OpPerson> findByProperty(String propertyName, Object value);

	public List<OpPerson> findByFirstNm(Object firstNm);

	public List<OpPerson> findByLastNm(Object lastNm);

	/**
	 * Find all OpPerson entities.
	 * 
	 * @return List<OpPerson> all OpPerson entities
	 */
	public List<OpPerson> findAll();
}
