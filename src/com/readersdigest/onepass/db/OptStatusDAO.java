package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * OptStatus entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.db.OptStatus
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OptStatusDAO implements IOptStatusDAO {
    // property constants
    public static final String OPT_STATUS_NAME = "optStatusName";
    public static final String DESCRIPTION = "description";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved OptStatus entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * OptStatusDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            OptStatus entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(OptStatus entity) {
        EntityManagerHelper.log("saving OptStatus instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Delete a persistent OptStatus entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * OptStatusDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            OptStatus entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(OptStatus entity) {
        EntityManagerHelper.log("deleting OptStatus instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(OptStatus.class, entity.getOptStatusId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved OptStatus entity and return it or a copy of it
     * to the sender. A copy of the OptStatus entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the
     * updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = OptStatusDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            OptStatus entity to update
     * @return OptStatus the persisted OptStatus entity instance, may not be the
     *         same
     * @throws RuntimeException
     *             if the operation fails
     */
    public OptStatus update(OptStatus entity) {
        EntityManagerHelper.log("updating OptStatus instance", Level.INFO, null);
        try {
            OptStatus result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public OptStatus findById(Integer id) {
        EntityManagerHelper.log("finding OptStatus instance with id: " + id, Level.INFO, null);
        try {
            OptStatus instance = getEntityManager().find(OptStatus.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all OptStatus entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the OptStatus property to query
     * @param value
     *            the property value to match
     * @return List<OptStatus> found by query
     */
    @SuppressWarnings("unchecked")
    public List<OptStatus> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding OptStatus instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from OptStatus model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<OptStatus> findByOptStatusName(Object optStatusName) {
        return findByProperty(OPT_STATUS_NAME, optStatusName);
    }

    public List<OptStatus> findByDescription(Object description) {
        return findByProperty(DESCRIPTION, description);
    }

    /**
     * Find all OptStatus entities.
     * 
     * @return List<OptStatus> all OptStatus entities
     */
    @SuppressWarnings("unchecked")
    public List<OptStatus> findAll() {
        EntityManagerHelper.log("finding all OptStatus instances", Level.INFO, null);
        try {
            final String queryString = "select model from OptStatus model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}