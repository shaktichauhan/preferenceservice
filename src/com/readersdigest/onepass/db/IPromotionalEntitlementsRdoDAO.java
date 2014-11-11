package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EntitlementsRdoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPromotionalEntitlementsRdoDAO {
	/**
	 * Perform an initial save of a previously unsaved EntitlementsRdo entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsRdoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsRdo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PromotionalEntitlementsRdo entity);

	/**
	 * Delete a persistent EntitlementsRdo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEntitlementsRdoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsRdo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PromotionalEntitlementsRdo entity);

	/**
	 * Persist a previously saved EntitlementsRdo entity and return it or a copy
	 * of it to the sender. A copy of the EntitlementsRdo entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IEntitlementsRdoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EntitlementsRdo entity to update
	 * @return EntitlementsRdo the persisted EntitlementsRdo entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public PromotionalEntitlementsRdo update(PromotionalEntitlementsRdo entity);

	public PromotionalEntitlementsRdo findById(String id);

	/**
	 * Find all EntitlementsRdo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EntitlementsRdo property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsRdo> found by query
	 */
	public List<PromotionalEntitlementsRdo> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all EntitlementsRdo entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EntitlementsRdo> all EntitlementsRdo entities
	 */
	public List<PromotionalEntitlementsRdo> findAll(int... rowStartIdxAndCount);
}