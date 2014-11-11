package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberPWDResetDAO.
 * 
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public interface IMemberPWDResetDAO {
    /**
     * Perform an initial save of a previously unsaved MemberPWDReset entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberPWDResetDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(MemberPWDReset entity);

    /**
     * Delete a persistent MemberPWDReset entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberPWDResetDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(MemberPWDReset entity);

    /**
     * Persist a previously saved MemberPWDReset entity and return it or a copy of it to
     * the sender. A copy of the MemberPWDReset entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IMemberPWDResetDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to update
     * @return MemberPWDReset the persisted Email entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public MemberPWDReset update(MemberPWDReset entity);

    public MemberPWDReset findById(Integer id);

    /**
     * Find all MemberPWDReset entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the MemberPWDReset property to query
     * @param value
     *            the property value to match
     * @return List<MemberPWDReset> found by query
     */
    public List<MemberPWDReset> findByProperty(String propertyName, Object value);

    public List<MemberPWDReset> findByToken(String token);
    
    public List<MemberPWDReset> findByMemberId(Object memberId);

   
}