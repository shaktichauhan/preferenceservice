package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EmailAddressOptStatusDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IEmailAddressOptStatusDAO {
    /**
     * Perform an initial save of a previously unsaved EmailAddressOptStatus
     * entity. All subsequent persist actions of this entity should use the
     * #update() method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailAddressOptStatusDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptStatus entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(EmailAddressOptStatus entity);

    /**
     * Delete a persistent EmailAddressOptStatus entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailAddressOptStatusDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptStatus entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(EmailAddressOptStatus entity);

    /**
     * Persist a previously saved EmailAddressOptStatus entity and return it or
     * a copy of it to the sender. A copy of the EmailAddressOptStatus entity
     * parameter is returned when the JPA persistence mechanism has not
     * previously been tracking the updated entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently saved to the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#merge(Object)
     * EntityManager#merge} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IEmailAddressOptStatusDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptStatus entity to update
     * @return EmailAddressOptStatus the persisted EmailAddressOptStatus entity
     *         instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public EmailAddressOptStatus update(EmailAddressOptStatus entity);

    public EmailAddressOptStatus findById(EmailAddressOptStatusId id);

    /**
     * Find all EmailAddressOptStatus entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the EmailAddressOptStatus property to query
     * @param value
     *            the property value to match
     * @return List<EmailAddressOptStatus> found by query
     */
    public List<EmailAddressOptStatus> findByProperty(String propertyName, Object value);

    /**
     * Find all EmailAddressOptStatus entities.
     * 
     * @return List<EmailAddressOptStatus> all EmailAddressOptStatus entities
     */
    public List<EmailAddressOptStatus> findAll();
}