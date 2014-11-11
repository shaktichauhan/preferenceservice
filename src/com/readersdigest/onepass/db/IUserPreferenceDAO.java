package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for UserPreferenceDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IUserPreferenceDAO {
    /**
     * Perform an initial save of a previously unsaved UserPreference entity.
     * All subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreference entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(UserPreference entity);

    /**
     * Delete a persistent UserPreference entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            UserPreference entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(UserPreference entity);

    /**
     * Persist a previously saved UserPreference entity and return it or a copy
     * of it to the sender. A copy of the UserPreference entity parameter is
     * returned when the JPA persistence mechanism has not previously been
     * tracking the updated entity. This operation must be performed within the
     * a database transaction context for the entity's data to be permanently
     * saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IUserPreferenceDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreference entity to update
     * @return UserPreference the persisted UserPreference entity instance, may
     *         not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public UserPreference update(UserPreference entity);

    public UserPreference findById(Integer id);

    /**
     * Find all UserPreference entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the UserPreference property to query
     * @param value
     *            the property value to match
     * @return List<UserPreference> found by query
     */
    public List<UserPreference> findByProperty(String propertyName, Object value);

    public List<UserPreference> findByUserPreferenceName(Object userPreferenceName);

    public List<UserPreference> findByUserPreferenceDesc(Object userPreferenceDesc);

    public List<UserPreference> findByDisplayName(Object displayName);

    public List<UserPreference> findByTagLine(Object tagLine);

    public List<UserPreference> findByCheetahMailListId(Object cheetahMailListId);

    /**
     * Find all UserPreference entities.
     * 
     * @return List<UserPreference> all UserPreference entities
     */
    public List<UserPreference> findAll();
}