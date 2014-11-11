package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EmailDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IEmailDAO {
    /**
     * Perform an initial save of a previously unsaved Email entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Email entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Email entity);

    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the email
     */
    public Email refresh(Email entity);
    
    /**
     * Delete a persistent Email entity. This operation must be performed within
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
    public void delete(Email entity);

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
     * entity = IEmailDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Email entity to update
     * @return Email the persisted Email entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Email update(Email entity);

    public Email findById(Integer id);

    /**
     * Find all Email entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Email property to query
     * @param value
     *            the property value to match
     * @return List<Email> found by query
     */
    public List<Email> findByProperty(String propertyName, Object value);

    public List<Email> findByMemberId(Object memberId);

    public List<Email> findByEmailAddress(Object emailAddress);

    public List<Email> findByEmailTypeId(Object emailTypeId);

    public List<Email> findByNonMemberProfile(Object nonMemberProfile);

    public List<Email> findBySoftBounce(Object softBounce);

    public List<Email> findByHardBounce(Object hardBounce);

    public List<Email> findByLegacyEpid(Object legacyEpid);

    public List<Email> findByEpid(Object epid);

    /**
     * Find all Email entities.
     * 
     * @return List<Email> all Email entities
     */
    public List<Email> findAll();
}