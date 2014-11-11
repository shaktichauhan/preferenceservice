package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for AddressTypeDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IAddressTypeDAO {
    /**
     * Perform an initial save of a previously unsaved AddressType entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IAddressTypeDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            AddressType entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(AddressType entity);

    /**
     * Delete a persistent AddressType entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IAddressTypeDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            AddressType entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(AddressType entity);

    /**
     * Persist a previously saved AddressType entity and return it or a copy of
     * it to the sender. A copy of the AddressType entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the
     * updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IAddressTypeDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            AddressType entity to update
     * @return AddressType the persisted AddressType entity instance, may not be
     *         the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public AddressType update(AddressType entity);

    public AddressType findById(Integer id);

    /**
     * Find all AddressType entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the AddressType property to query
     * @param value
     *            the property value to match
     * @return List<AddressType> found by query
     */
    public List<AddressType> findByProperty(String propertyName, Object value);

    public List<AddressType> findByAddressTypeName(Object addressTypeName);

    public List<AddressType> findByDescription(Object description);

    /**
     * Find all AddressType entities.
     * 
     * @return List<AddressType> all AddressType entities
     */
    public List<AddressType> findAll();
}