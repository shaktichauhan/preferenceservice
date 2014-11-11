package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for MemberDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IMemberDAO {
    /**
     * Perform an initial save of a previously unsaved Member entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Member entity);
    
    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the member
     */
    public Member refresh(Member entity);

    /**
     * Delete a persistent Member entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IMemberDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Member entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Member entity);

    /**
     * Persist a previously saved Member entity and return it or a copy of it to
     * the sender. A copy of the Member entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IMemberDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member entity to update
     * @return Member the persisted Member entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Member update(Member entity);

    public Member findById(Integer id);

    /**
     * Find all Member entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Member property to query
     * @param value
     *            the property value to match
     * @return List<Member> found by query
     */
    public List<Member> findByProperty(String propertyName, Object value);

    public List<Member> findByMemberName(Object memberName);

    public List<Member> findByPassword(Object password);

    public List<Member> findByPasswordHintQuestion(Object passwordHintQuestion);

    public List<Member> findByPasswordHintAnswer(Object passwordHintAnswer);

    public List<Member> findByLastLoginIpAddress(Object lastLoginIpAddress);

    public List<Member> findByCookieGuid(Object cookieGuid);

    /**
     * Find all Member entities.
     * 
     * @return List<Member> all Member entities
     */
    public List<Member> findAll();
}