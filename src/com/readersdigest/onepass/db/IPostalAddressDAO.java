package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for PostalAddressDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IPostalAddressDAO {
    /**
     * Perform an initial save of a previously unsaved PostalAddress entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IPostalAddressDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(PostalAddress entity);

    /**
     * Delete a persistent PostalAddress entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IPostalAddressDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(PostalAddress entity);

    /**
     * Persist a previously saved PostalAddress entity and return it or a copy
     * of it to the sender. A copy of the PostalAddress entity parameter is
     * returned when the JPA persistence mechanism has not previously been
     * tracking the updated entity. This operation must be performed within the
     * a database transaction context for the entity's data to be permanently
     * saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IPostalAddressDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to update
     * @return PostalAddress the persisted PostalAddress entity instance, may
     *         not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public PostalAddress update(PostalAddress entity);

    public PostalAddress findById(Integer id);

    /**
     * Find all PostalAddress entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the PostalAddress property to query
     * @param value
     *            the property value to match
     * @return List<PostalAddress> found by query
     */
    public List<PostalAddress> findByProperty(String propertyName, Object value);

    public List<PostalAddress> findByFirstName(Object firstName);

    public List<PostalAddress> findByMiddleName(Object middleName);

    public List<PostalAddress> findByLastName(Object lastName);

    public List<PostalAddress> findByTitle(Object title);

    public List<PostalAddress> findByAddress1(Object address1);

    public List<PostalAddress> findByAddress2(Object address2);

    public List<PostalAddress> findByAddress3(Object address3);

    public List<PostalAddress> findByAddress4(Object address4);

    public List<PostalAddress> findByCity(Object city);

    public List<PostalAddress> findByZip(Object zip);

    public List<PostalAddress> findByValid(Object valid);

    public List<PostalAddress> findByPostalCleansedAddress1(Object postalCleansedAddress1);

    public List<PostalAddress> findByPostalCleansedCity(Object postalCleansedCity);

    public List<PostalAddress> findByPostalCleansedState(Object postalCleansedState);

    public List<PostalAddress> findByPostalCleansedZip(Object postalCleansedZip);

    public List<PostalAddress> findByPostalCleansedCounty(Object postalCleansedCounty);

    public List<PostalAddress> findByIsPending(Object isPending);

    /**
     * Find all PostalAddress entities.
     * 
     * @return List<PostalAddress> all PostalAddress entities
     */
    public List<PostalAddress> findAll();
}