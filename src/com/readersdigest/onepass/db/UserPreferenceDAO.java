package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserPreference entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.UserPreference
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class UserPreferenceDAO implements IUserPreferenceDAO {
    // property constants
    public static final String USER_PREFERENCE_NAME = "userPreferenceName";
    public static final String USER_PREFERENCE_DESC = "userPreferenceDesc";
    public static final String DISPLAY_NAME = "displayName";
    public static final String TAG_LINE = "tagLine";
    public static final String CHEETAH_MAIL_LIST_ID = "cheetahMailListId";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
     * UserPreferenceDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            UserPreference entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(UserPreference entity) {
        EntityManagerHelper.log("saving UserPreference instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * UserPreferenceDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            UserPreference entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(UserPreference entity) {
        EntityManagerHelper.log("deleting UserPreference instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(UserPreference.class, entity.getUserPreferenceId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
     * entity = UserPreferenceDAO.update(entity);
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
    public UserPreference update(UserPreference entity) {
        EntityManagerHelper.log("updating UserPreference instance", Level.INFO, null);
        try {
            UserPreference result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public UserPreference findById(Integer id) {
        EntityManagerHelper.log("finding UserPreference instance with id: " + id, Level.INFO, null);
        try {
            UserPreference instance = getEntityManager().find(UserPreference.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all UserPreference entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the UserPreference property to query
     * @param value
     *            the property value to match
     * @return List<UserPreference> found by query
     */
    @SuppressWarnings("unchecked")
    public List<UserPreference> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding UserPreference instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from UserPreference model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<UserPreference> findByUserPreferenceName(Object userPreferenceName) {
        return findByProperty(USER_PREFERENCE_NAME, userPreferenceName);
    }

    public List<UserPreference> findByUserPreferenceDesc(Object userPreferenceDesc) {
        return findByProperty(USER_PREFERENCE_DESC, userPreferenceDesc);
    }

    public List<UserPreference> findByDisplayName(Object displayName) {
        return findByProperty(DISPLAY_NAME, displayName);
    }

    public List<UserPreference> findByTagLine(Object tagLine) {
        return findByProperty(TAG_LINE, tagLine);
    }

    public List<UserPreference> findByCheetahMailListId(Object cheetahMailListId) {
        return findByProperty(CHEETAH_MAIL_LIST_ID, cheetahMailListId);
    }

    /**
     * Find all UserPreference entities.
     * 
     * @return List<UserPreference> all UserPreference entities
     */
    @SuppressWarnings("unchecked")
    public List<UserPreference> findAll() {
        EntityManagerHelper.log("finding all UserPreference instances", Level.INFO, null);
        try {
            final String queryString = "select model from UserPreference model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}