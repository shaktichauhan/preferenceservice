package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmailAddressOptHistory entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.EmailAddressOptHistory
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class EmailAddressOptHistoryDAO implements IEmailAddressOptHistoryDAO {
    // property constants

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
     * EmailAddressOptHistoryDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptHistory entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(EmailAddressOptHistory entity) {
        EntityManagerHelper.log("saving EmailAddressOptHistory instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * EmailAddressOptHistoryDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptHistory entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(EmailAddressOptHistory entity) {
        EntityManagerHelper.log("deleting EmailAddressOptHistory instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(EmailAddressOptHistory.class, entity.getEmailAddressOptHistoryId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * entity = EmailAddressOptHistoryDAO.update(entity);
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
    public EmailAddressOptHistory update(EmailAddressOptHistory entity) {
        EntityManagerHelper.log("updating EmailAddressOptHistory instance", Level.INFO, null);
        try {
            EmailAddressOptHistory result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public EmailAddressOptHistory findById(Integer id) {
        EntityManagerHelper.log("finding EmailAddressOptHistory instance with id: " + id, Level.INFO, null);
        try {
            EmailAddressOptHistory instance = getEntityManager().find(EmailAddressOptHistory.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all EmailAddressOptHistory entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the EmailAddressOptHistory property to query
     * @param value
     *            the property value to match
     * @return List<EmailAddressOptHistory> found by query
     */
    @SuppressWarnings("unchecked")
    public List<EmailAddressOptHistory> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding EmailAddressOptHistory instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from EmailAddressOptHistory model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all EmailAddressOptHistory entities.
     * 
     * @return List<EmailAddressOptHistory> all EmailAddressOptHistory entities
     */
    @SuppressWarnings("unchecked")
    public List<EmailAddressOptHistory> findAll() {
        EntityManagerHelper.log("finding all EmailAddressOptHistory instances", Level.INFO, null);
        try {
            final String queryString = "select model from EmailAddressOptHistory model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}