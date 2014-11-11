package com.readersdigest.onepass.jpa.dao;

import java.util.List;

import com.readersdigest.onepass.jpa.OpAddress;
import com.readersdigest.onepass.jpa.OpAddressId;

/**
 * Interface for OpAddressDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOpAddressDAO {
	/**
	 * Perform an initial save of a previously unsaved OpAddress entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpAddressDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpAddress entity);

	/**
	 * Delete a persistent OpAddress entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOpAddressDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpAddress entity);

	/**
	 * Persist a previously saved OpAddress entity and return it or a copy of it
	 * to the sender. A copy of the OpAddress entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOpAddressDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to update
	 * @return OpAddress the persisted OpAddress entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpAddress update(OpAddress entity);

	public OpAddress findById(Integer id);

	/**
	 * Find all OpAddress entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpAddress property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpAddress> found by query
	 */
	public List<OpAddress> findByProperty(String propertyName, Object value);

	public List<OpAddress> findByStreet1(Object street1);

	public List<OpAddress> findByStreet2(Object street2);

	public List<OpAddress> findByCity(Object city);

	public List<OpAddress> findByStateNm(Object stateNm);

	public List<OpAddress> findByZip(Object zip);

	public List<OpAddress> findByCountry(Object country);

	public List<OpAddress> findByPrimaryFlag(Object primaryFlag);

	/**
	 * Find all OpAddress entities.
	 * 
	 * @return List<OpAddress> all OpAddress entities
	 */
	public List<OpAddress> findAll();
}
