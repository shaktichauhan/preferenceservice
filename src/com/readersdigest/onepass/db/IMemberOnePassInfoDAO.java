package com.readersdigest.onepass.db;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Interface for MemberOnePassInfoDAO.
 * 
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public interface IMemberOnePassInfoDAO {
	
	/**
	 * Perform an initial save of a previously unsaved MemberOnePassInfo entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMemberOnePassInfoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            Member OnePass Info entity to persist
	 */
	public void save(MemberOnePassInfo entity);

	/**
	 * Refresh.
	 * 
	 * @param entity
	 *            the entity
	 * @return the member onepass info
	 */
	public MemberOnePassInfo refresh(MemberOnePassInfo entity);

	/**
	 * Delete a persistent MemberOnePassInfo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IEmailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 *
	 * @param entity            Email entity to delete
	 */
	public void delete(MemberOnePassInfo entity);

	/**
	 * Persist a previously saved Email entity and return it or a copy of it to
	 * the sender. A copy of the Email entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMemberOnePassInfoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            MemberOnePassInfo entity to update
	 * @return MemberOnePassInfo the persisted Email entity instance, may not be
	 *         the same
	 */
	public MemberOnePassInfo update(MemberOnePassInfo entity);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the member one pass info
	 */
	public MemberOnePassInfo findById(Integer id);

	/**
	 * Find all MemberOnePassInfo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MemberOnePassInfo property to query
	 * @param value
	 *            the property value to match
	 * @return List<MemberOnePassInfo> found by query
	 */
	public List<MemberOnePassInfo> findByProperty(String propertyName,
			Object value);

	/**
	 * Find by account number.
	 *
	 * @param accountNumber the account number
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByAccountNumber(String accountNumber);

	/**
	 * Find by member info id.
	 *
	 * @param memberInfoId the member info id
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByMemberInfoId(Object memberInfoId);

	/**
	 * Find by properties.
	 *
	 * @param propertyName1 the property name1
	 * @param propertyName2 the property name2
	 * @param value1 the value1
	 * @param value2 the value2
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, final Object value1, final Object value2);

	/**
	 * Find by properties.
	 *
	 * @param propertyName1 the property name1
	 * @param propertyName2 the property name2
	 * @param propertyName3 the property name3
	 * @param value1 the value1
	 * @param value2 the value2
	 * @param value3 the value3
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, final Object value1,
			final Object value2, final Object value3);

	/**
	 * Find by properties.
	 *
	 * @param propertyName1 the property name1
	 * @param propertyName2 the property name2
	 * @param propertyName3 the property name3
	 * @param propertyName4 the property name4
	 * @param value1 the value1
	 * @param value2 the value2
	 * @param value3 the value3
	 * @param value4 the value4
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, String propertyName4,
			final Object value1, final Object value2, final Object value3,
			final Object value4);

	/**
	 * Find by properties.
	 *
	 * @param propertyName1 the property name1
	 * @param propertyName2 the property name2
	 * @param propertyName3 the property name3
	 * @param value the value
	 * @param value2 the value2
	 * @param value3 the value3
	 * @return the list
	 */
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, final Object value[],
			final Object value2, final Object value3);
}