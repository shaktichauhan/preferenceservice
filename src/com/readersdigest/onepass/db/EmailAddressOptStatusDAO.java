package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmailAddressOptStatus entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.EmailAddressOptStatus
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class EmailAddressOptStatusDAO implements IEmailAddressOptStatusDAO {
    // property constants

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
     * EmailAddressOptStatusDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptStatus entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(EmailAddressOptStatus entity) {
        EntityManagerHelper.log("saving EmailAddressOptStatus instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * EmailAddressOptStatusDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            EmailAddressOptStatus entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(EmailAddressOptStatus entity) {
        EntityManagerHelper.log("deleting EmailAddressOptStatus instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(EmailAddressOptStatus.class, entity.getId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * entity = EmailAddressOptStatusDAO.update(entity);
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
    public EmailAddressOptStatus update(EmailAddressOptStatus entity) {
        EntityManagerHelper.log("updating EmailAddressOptStatus instance", Level.INFO, null);
        try {
            EmailAddressOptStatus result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public EmailAddressOptStatus findById(EmailAddressOptStatusId id) {
        EntityManagerHelper.log("finding EmailAddressOptStatus instance with id: " + id, Level.INFO, null);
        try {
            EmailAddressOptStatus instance = getEntityManager().find(EmailAddressOptStatus.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all EmailAddressOptStatus entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the EmailAddressOptStatus property to query
     * @param value
     *            the property value to match
     * @return List<EmailAddressOptStatus> found by query
     */
    @SuppressWarnings("unchecked")
    public List<EmailAddressOptStatus> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding EmailAddressOptStatus instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from EmailAddressOptStatus model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all EmailAddressOptStatus entities.
     * 
     * @return List<EmailAddressOptStatus> all EmailAddressOptStatus entities
     */
    @SuppressWarnings("unchecked")
    public List<EmailAddressOptStatus> findAll() {
        EntityManagerHelper.log("finding all EmailAddressOptStatus instances", Level.INFO, null);
        try {
            final String queryString = "select model from EmailAddressOptStatus model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}