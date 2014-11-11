package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for UserPreferenceGroupMembershipDAO.
 * 
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public interface IUserPreferenceGroupMembershipDAO {
    /**
     * Perform an initial save of a previously unsaved
     * UserPreferenceGroupMembership entity. All subsequent persist actions of
     * this entity should use the #update() method. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently saved to the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceGroupMembershipDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroupMembership entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(UserPreferenceGroupMembership entity);

    /**
     * Delete a persistent UserPreferenceGroupMembership entity. This operation
     * must be performed within the a database transaction context for the
     * entity's data to be permanently deleted from the persistence store, i.e.,
     * database. This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IUserPreferenceGroupMembershipDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroupMembership entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(UserPreferenceGroupMembership entity);

    /**
     * Persist a previously saved UserPreferenceGroupMembership entity and
     * return it or a copy of it to the sender. A copy of the
     * UserPreferenceGroupMembership entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IUserPreferenceGroupMembershipDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroupMembership entity to update
     * @return UserPreferenceGroupMembership the persisted
     *         UserPreferenceGroupMembership entity instance, may not be the
     *         same
     * @throws RuntimeException
     *             if the operation fails
     */
    public UserPreferenceGroupMembership update(UserPreferenceGroupMembership entity);

    public UserPreferenceGroupMembership findById(UserPreferenceGroupMembershipId id);

    /**
     * Find all UserPreferenceGroupMembership entities with a specific property
     * value.
     * 
     * @param propertyName
     *            the name of the UserPreferenceGroupMembership property to
     *            query
     * @param value
     *            the property value to match
     * @return List<UserPreferenceGroupMembership> found by query
     */
    public List<UserPreferenceGroupMembership> findByProperty(String propertyName, Object value);

    public List<UserPreferenceGroupMembership> findByDisplayOrder(Object displayOrder);

    public List<UserPreferenceGroupMembership> findByChecked(Object checked);

    public List<UserPreferenceGroupMembership> findByHidden(Object hidden);

    /**
     * Find all UserPreferenceGroupMembership entities.
     * 
     * @return List<UserPreferenceGroupMembership> all
     *         UserPreferenceGroupMembership entities
     */
    public List<UserPreferenceGroupMembership> findAll();
}