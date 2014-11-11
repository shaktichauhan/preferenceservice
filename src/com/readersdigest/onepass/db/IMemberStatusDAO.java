package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberStatusDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMemberStatusDAO {
	/**
	 * Perform an initial save of a previously unsaved MemberStatus entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberStatusDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberStatus entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MemberStatus entity);

	/**
	 * Delete a persistent MemberStatus entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberStatusDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MemberStatus entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MemberStatus entity);

	/**
	 * Persist a previously saved MemberStatus entity and return it or a copy of
	 * it to the sender. A copy of the MemberStatus entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMemberStatusDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberStatus entity to update
	 * @return MemberStatus the persisted MemberStatus entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MemberStatus update(MemberStatus entity);

	public MemberStatus findById(Integer id);

	/**
	 * Find all MemberStatus entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MemberStatus property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberStatus> found by query
	 */
	public List<MemberStatus> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<MemberStatus> findByMemberStatusName(Object memberStatusName,
			int... rowStartIdxAndCount);

	public List<MemberStatus> findByDescription(Object description,
			int... rowStartIdxAndCount);

	/**
	 * Find all MemberStatus entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberStatus> all MemberStatus entities
	 */
	public List<MemberStatus> findAll(int... rowStartIdxAndCount);
}