package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for EmailAddressOptHistoryDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IEmailAddressOptHistoryDAO {
    /**
     * Perform an initial save of a previously unsaved EmailAddressOptHistory
     * entity. All subsequent persist actions of this entity should use the
     * #update() method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailAddressOptHistoryDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptHistory entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(EmailAddressOptHistory entity);

    /**
     * Delete a persistent EmailAddressOptHistory entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IEmailAddressOptHistoryDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptHistory entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(EmailAddressOptHistory entity);

    /**
     * Persist a previously saved EmailAddressOptHistory entity and return it or
     * a copy of it to the sender. A copy of the EmailAddressOptHistory entity
     * parameter is returned when the JPA persistence mechanism has not
     * previously been tracking the updated entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently saved to the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#merge(Object)
     * EntityManager#merge} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IEmailAddressOptHistoryDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptHistory entity to update
     * @return EmailAddressOptHistory the persisted EmailAddressOptHistory
     *         entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public EmailAddressOptHistory update(EmailAddressOptHistory entity);

    public EmailAddressOptHistory findById(Integer id);

    /**
     * Find all EmailAddressOptHistory entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the EmailAddressOptHistory property to query
     * @param value
     *            the property value to match
     * @return List<EmailAddressOptHistory> found by query
     */
    public List<EmailAddressOptHistory> findByProperty(String propertyName, Object value);

    /**
     * Find all EmailAddressOptHistory entities.
     * 
     * @return List<EmailAddressOptHistory> all EmailAddressOptHistory entities
     */
    public List<EmailAddressOptHistory> findAll();
}