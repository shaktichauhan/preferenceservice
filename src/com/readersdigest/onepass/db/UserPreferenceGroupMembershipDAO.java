package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserPreferenceGroupMembership entities. Transaction control of the save(),
 * update() and delete() operations must be handled externally by senders of
 * these methods or must be manually added to each of these methods for data to
 * be persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.UserPreferenceGroupMembership
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class UserPreferenceGroupMembershipDAO implements IUserPreferenceGroupMembershipDAO {
    // property constants
    public static final String DISPLAY_ORDER = "displayOrder";
    public static final String CHECKED = "checked";
    public static final String HIDDEN = "hidden";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
     * UserPreferenceGroupMembershipDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroupMembership entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(UserPreferenceGroupMembership entity) {
        EntityManagerHelper.log("saving UserPreferenceGroupMembership instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * UserPreferenceGroupMembershipDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            UserPreferenceGroupMembership entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(UserPreferenceGroupMembership entity) {
        EntityManagerHelper.log("deleting UserPreferenceGroupMembership instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(UserPreferenceGroupMembership.class, entity.getId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * entity = UserPreferenceGroupMembershipDAO.update(entity);
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
    public UserPreferenceGroupMembership update(UserPreferenceGroupMembership entity) {
        EntityManagerHelper.log("updating UserPreferenceGroupMembership instance", Level.INFO, null);
        try {
            UserPreferenceGroupMembership result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public UserPreferenceGroupMembership findById(UserPreferenceGroupMembershipId id) {
        EntityManagerHelper.log("finding UserPreferenceGroupMembership instance with id: " + id, Level.INFO, null);
        try {
            UserPreferenceGroupMembership instance = getEntityManager().find(UserPreferenceGroupMembership.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    @SuppressWarnings("unchecked")
    public List<UserPreferenceGroupMembership> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding UserPreferenceGroupMembership instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from UserPreferenceGroupMembership model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<UserPreferenceGroupMembership> findByDisplayOrder(Object displayOrder) {
        return findByProperty(DISPLAY_ORDER, displayOrder);
    }

    public List<UserPreferenceGroupMembership> findByChecked(Object checked) {
        return findByProperty(CHECKED, checked);
    }

    public List<UserPreferenceGroupMembership> findByHidden(Object hidden) {
        return findByProperty(HIDDEN, hidden);
    }

    /**
     * Find all UserPreferenceGroupMembership entities.
     * 
     * @return List<UserPreferenceGroupMembership> all
     *         UserPreferenceGroupMembership entities
     */
    @SuppressWarnings("unchecked")
    public List<UserPreferenceGroupMembership> findAll() {
        EntityManagerHelper.log("finding all UserPreferenceGroupMembership instances", Level.INFO, null);
        try {
            final String queryString = "select model from UserPreferenceGroupMembership model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}