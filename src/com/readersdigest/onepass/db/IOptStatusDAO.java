package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for OptStatusDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IOptStatusDAO {
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
     * IOptStatusDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            OptStatus entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(OptStatus entity);

    /**
     * Delete a persistent OptStatus entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IOptStatusDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            OptStatus entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(OptStatus entity);

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
     * entity = IOptStatusDAO.update(entity);
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
    public OptStatus update(OptStatus entity);

    public OptStatus findById(Integer id);

    /**
     * Find all OptStatus entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the OptStatus property to query
     * @param value
     *            the property value to match
     * @return List<OptStatus> found by query
     */
    public List<OptStatus> findByProperty(String propertyName, Object value);

    public List<OptStatus> findByOptStatusName(Object optStatusName);

    public List<OptStatus> findByDescription(Object description);

    /**
     * Find all OptStatus entities.
     * 
     * @return List<OptStatus> all OptStatus entities
     */
    public List<OptStatus> findAll();
}