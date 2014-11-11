package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for SourceDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface ISourceDAO {
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
     * ISourceDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Source entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Source entity);

    /**
     * Delete a persistent Source entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ISourceDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Source entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Source entity);

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
     * entity = ISourceDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Source entity to update
     * @return Source the persisted Source entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Source update(Source entity);

    public Source findById(Integer id);

    /**
     * Find all Source entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Source property to query
     * @param value
     *            the property value to match
     * @return List<Source> found by query
     */
    public List<Source> findByProperty(String propertyName, Object value);

    public List<Source> findBySourceName(Object sourceName);

    public List<Source> findByDescription(Object description);

    /**
     * Find all Source entities.
     * 
     * @return List<Source> all Source entities
     */
    public List<Source> findAll();
}