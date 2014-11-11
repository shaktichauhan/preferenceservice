package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Source entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.db.Source
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class SourceDAO implements ISourceDAO {
    // property constants
    public static final String SOURCE_NAME = "sourceName";
    public static final String DESCRIPTION = "description";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Source entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * SourceDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Source entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Source entity) {
        EntityManagerHelper.log("saving Source instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Delete a persistent Source entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * SourceDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Source entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Source entity) {
        EntityManagerHelper.log("deleting Source instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(Source.class, entity.getSourceId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Source entity and return it or a copy of it to
     * the sender. A copy of the Source entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = SourceDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Source entity to update
     * @return Source the persisted Source entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Source update(Source entity) {
        EntityManagerHelper.log("updating Source instance", Level.INFO, null);
        try {
            Source result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public Source findById(Integer id) {
        EntityManagerHelper.log("finding Source instance with id: " + id, Level.INFO, null);
        try {
            Source instance = getEntityManager().find(Source.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all Source entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Source property to query
     * @param value
     *            the property value to match
     * @return List<Source> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Source> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding Source instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from Source model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<Source> findBySourceName(Object sourceName) {
        return findByProperty(SOURCE_NAME, sourceName);
    }

    public List<Source> findByDescription(Object description) {
        return findByProperty(DESCRIPTION, description);
    }

    /**
     * Find all Source entities.
     * 
     * @return List<Source> all Source entities
     */
    @SuppressWarnings("unchecked")
    public List<Source> findAll() {
        EntityManagerHelper.log("finding all Source instances", Level.INFO, null);
        try {
            final String queryString = "select model from Source model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}