package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for UserPreferenceGroupDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IUserPreferenceGroupDAO {
    /**
     * Perform an initial save of a previously unsaved UserPreferenceGroup
     * entity. All subsequent persist actions of this entity should use the
     * #update() method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceGroupDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroup entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(UserPreferenceGroup entity);

    /**
     * Delete a persistent UserPreferenceGroup entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceGroupDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroup entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(UserPreferenceGroup entity);

    /**
     * Persist a previously saved UserPreferenceGroup entity and return it or a
     * copy of it to the sender. A copy of the UserPreferenceGroup entity
     * parameter is returned when the JPA persistence mechanism has not
     * previously been tracking the updated entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently saved to the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#merge(Object)
     * EntityManager#merge} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IUserPreferenceGroupDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroup entity to update
     * @return UserPreferenceGroup the persisted UserPreferenceGroup entity
     *         instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public UserPreferenceGroup update(UserPreferenceGroup entity);

    public UserPreferenceGroup findById(Integer id);

    /**
     * Find all UserPreferenceGroup entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the UserPreferenceGroup property to query
     * @param value
     *            the property value to match
     * @return List<UserPreferenceGroup> found by query
     */
    public List<UserPreferenceGroup> findByProperty(String propertyName, Object value);

    public List<UserPreferenceGroup> findByUserPreferenceGroupName(Object userPreferenceGroupName);

    /**
     * Find all UserPreferenceGroup entities.
     * 
     * @return List<UserPreferenceGroup> all UserPreferenceGroup entities
     */
    public List<UserPreferenceGroup> findAll();
}