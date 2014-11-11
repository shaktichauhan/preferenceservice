package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for SubdivisionDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface ISubdivisionDAO {
    /**
     * Perform an initial save of a previously unsaved Subdivision entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ISubdivisionDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Subdivision entity);

    /**
     * Delete a persistent Subdivision entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ISubdivisionDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Subdivision entity);

    /**
     * Persist a previously saved Subdivision entity and return it or a copy of
     * it to the sender. A copy of the Subdivision entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the
     * updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ISubdivisionDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to update
     * @return Subdivision the persisted Subdivision entity instance, may not be
     *         the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Subdivision update(Subdivision entity);

    public Subdivision findById(String id);

    /**
     * Find all Subdivision entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Subdivision property to query
     * @param value
     *            the property value to match
     * @return List<Subdivision> found by query
     */
    public List<Subdivision> findByProperty(String propertyName, Object value);

    public List<Subdivision> findBySubdivisionName1(Object subdivisionName1);

    public List<Subdivision> findBySubdivisionName2(Object subdivisionName2);

    public List<Subdivision> findBySubdivisionName3(Object subdivisionName3);

    public List<Subdivision> findByRegionalDivision(Object regionalDivision);

    public List<Subdivision> findBySubdivisionCategory(Object subdivisionCategory);

    public List<Subdivision> findByI3cSubdivisionCode(Object i3cSubdivisionCode);

    /**
     * Find all Subdivision entities.
     * 
     * @return List<Subdivision> all Subdivision entities
     */
    public List<Subdivision> findAll();
}