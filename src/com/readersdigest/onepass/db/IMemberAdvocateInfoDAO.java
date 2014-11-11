package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberAdvocateInfoDAO.
 * 
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public interface IMemberAdvocateInfoDAO {
    /**
     * Perform an initial save of a previously unsaved MemberAdvocateInfo entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberAdvocateInfoDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member Info entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(MemberAdvocateInfo entity);
    
    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the member info
     */
    public MemberAdvocateInfo refresh(MemberAdvocateInfo entity);

    /**
     * Delete a persistent MemberAdvocateInfo entity. This operation must be performed within
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
    public void delete(MemberAdvocateInfo entity);

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
     * entity = IMemberAdvocateInfoDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberAdvocateInfo entity to update
     * @return MemberAdvocateInfo the persisted Email entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public MemberAdvocateInfo update(MemberAdvocateInfo entity);

    public MemberAdvocateInfo findById(Integer id);

    /**
     * Find all MemberAdvocateInfo entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the MemberAdvocateInfo property to query
     * @param value
     *            the property value to match
     * @return List<MemberAdvocateInfo> found by query
     */
    public List<MemberAdvocateInfo> findByProperty(String propertyName, Object value);

    
}