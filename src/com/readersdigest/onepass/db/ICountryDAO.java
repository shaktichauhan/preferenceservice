package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for CountryDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface ICountryDAO {
    /**
     * Perform an initial save of a previously unsaved Country entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ICountryDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Country entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Country entity);

    /**
     * Delete a persistent Country entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ICountryDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Country entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Country entity);

    /**
     * Persist a previously saved Country entity and return it or a copy of it
     * to the sender. A copy of the Country entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the
     * updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ICountryDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Country entity to update
     * @return Country the persisted Country entity instance, may not be the
     *         same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Country update(Country entity);

    public Country findById(String id);

    /**
     * Find all Country entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Country property to query
     * @param value
     *            the property value to match
     * @return List<Country> found by query
     */
    public List<Country> findByProperty(String propertyName, Object value);

    public List<Country> findByCountryName(Object countryName);

    public List<Country> findByDescriptiveInformation(Object descriptiveInformation);

    /**
     * Find all Country entities.
     * 
     * @return List<Country> all Country entities
     */
    public List<Country> findAll();
}