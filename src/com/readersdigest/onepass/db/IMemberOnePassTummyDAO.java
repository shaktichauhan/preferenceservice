package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberOnePassTummyDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMemberOnePassTummyDAO {
	/**
	 * Perform an initial save of a previously unsaved MemberOnePassTummy
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberOnePassTummyDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MemberOnePassTummy entity);

	/**
	 * Delete a persistent MemberOnePassTummy entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberOnePassTummyDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MemberOnePassTummy entity);

	/**
	 * Persist a previously saved MemberOnePassTummy entity and return it or a
	 * copy of it to the sender. A copy of the MemberOnePassTummy entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMemberOnePassTummyDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to update
	 * @return MemberOnePassTummy the persisted MemberOnePassTummy entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MemberOnePassTummy update(MemberOnePassTummy entity);

	public MemberOnePassTummy findById(Integer id);

	/**
	 * Find all MemberOnePassTummy entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MemberOnePassTummy property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberOnePassTummy> found by query
	 */
	public List<MemberOnePassTummy> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<MemberOnePassTummy> findByWeight(Object weight,
			int... rowStartIdxAndCount);

	public List<MemberOnePassTummy> findByPaidUser(Object paidUser,
			int... rowStartIdxAndCount);

	/**
	 * Find all MemberOnePassTummy entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberOnePassTummy> all MemberOnePassTummy entities
	 */
	public List<MemberOnePassTummy> findAll(int... rowStartIdxAndCount);
}