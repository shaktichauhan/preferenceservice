package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberInfoDAO.
 * 
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public interface IMemberInfoDAO {
    /**
     * Perform an initial save of a previously unsaved MemberInfo entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberInfoDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member Info entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(MemberInfo entity);
    
    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the member info
     */
    public MemberInfo refresh(MemberInfo entity);

    /**
     * Delete a persistent MemberInfo entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Email entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(MemberInfo entity);

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
     * entity = IMemberInfoDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberInfo entity to update
     * @return MemberInfo the persisted Email entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public MemberInfo update(MemberInfo entity);

    public MemberInfo findById(Integer id);

    /**
     * Find all MemberInfo entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the MemberInfo property to query
     * @param value
     *            the property value to match
     * @return List<MemberInfo> found by query
     */
    public List<MemberInfo> findByProperty(String propertyName, Object value);

    public List<MemberInfo> findByAccountNumber(String accountNumber);
    
    public List<MemberInfo> findByMemberId(Object memberId);
    
    public List<MemberInfo> findByProperties(String propertyName1, String propertyName2, final Object value1, final Object value2);

   
}