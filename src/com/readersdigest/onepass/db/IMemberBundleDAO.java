package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberBundleDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMemberBundleDAO {
	/**
	 * Perform an initial save of a previously unsaved MemberBundle entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberBundleDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberBundle entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MemberBundle entity);

	/**
	 * Delete a persistent MemberBundle entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberBundleDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MemberBundle entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MemberBundle entity);

	/**
	 * Persist a previously saved MemberBundle entity and return it or a copy of
	 * it to the sender. A copy of the MemberBundle entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMemberBundleDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberBundle entity to update
	 * @return MemberBundle the persisted MemberBundle entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MemberBundle update(MemberBundle entity);

	public MemberBundle findById(MemberBundleId id);

	/**
	 * Find all MemberBundle entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MemberBundle property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberBundle> found by query
	 */
	public List<MemberBundle> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<MemberBundle> findByAutoRenew(Object autoRenew,
			int... rowStartIdxAndCount);

	/**
	 * Find all MemberBundle entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberBundle> all MemberBundle entities
	 */
	public List<MemberBundle> findAll(int... rowStartIdxAndCount);
}