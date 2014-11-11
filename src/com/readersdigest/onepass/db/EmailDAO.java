package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Email
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.Email
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class EmailDAO implements IEmailDAO {
    // property constants
    public static final String MEMBER_ID = "member.memberId";
    public static final String EMAIL_ADDRESS = "emailAddress";
    public static final String EMAIL_TYPE_ID = "emailTypeId";
    public static final String NON_MEMBER_PROFILE = "nonMemberProfile";
    public static final String SOFT_BOUNCE = "softBounce";
    public static final String HARD_BOUNCE = "hardBounce";
    public static final String LEGACY_EPID = "legacyEpid";
    public static final String EPID = "epid";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Email entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * EmailDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Email entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Email entity) {
        EntityManagerHelper.log("saving Email instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the email
     */
    public Email refresh(Email entity) {
        EntityManagerHelper.log("refresh Email instance", Level.INFO, null);
        try {
            getEntityManager().refresh(entity);
            EntityManagerHelper.log("refresh successful", Level.INFO, null);
            return entity;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("refresh failed", Level.SEVERE, re);
            throw re;
        }
    }
    /**
     * Delete a persistent Email entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * EmailDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Email entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Email entity) {
        EntityManagerHelper.log("deleting Email instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(Email.class, entity.getEmailId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Email entity and return it or a copy of it to
     * the sender. A copy of the Email entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = EmailDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Email entity to update
     * @return Email the persisted Email entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Email update(Email entity) {
        EntityManagerHelper.log("updating Email instance", Level.INFO, null);
        try {
            Email result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public Email findById(Integer id) {
        EntityManagerHelper.log("finding Email instance with id: " + id, Level.INFO, null);
        try {
            Email instance = getEntityManager().find(Email.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all Email entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Email property to query
     * @param value
     *            the property value to match
     * @return List<Email> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Email> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding Email instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from Email model where model." + propertyName + "= :propertyValue order by " +
            		"model.effectiveDate desc";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<Email> findByMemberId(Object memberId) {
        return findByProperty(MEMBER_ID, memberId);
    }

    public List<Email> findByEmailAddress(Object emailAddress) {
        return findByProperty(EMAIL_ADDRESS, emailAddress);
    }

    public List<Email> findByEmailTypeId(Object emailTypeId) {
        return findByProperty(EMAIL_TYPE_ID, emailTypeId);
    }

    public List<Email> findByNonMemberProfile(Object nonMemberProfile) {
        return findByProperty(NON_MEMBER_PROFILE, nonMemberProfile);
    }

    public List<Email> findBySoftBounce(Object softBounce) {
        return findByProperty(SOFT_BOUNCE, softBounce);
    }

    public List<Email> findByHardBounce(Object hardBounce) {
        return findByProperty(HARD_BOUNCE, hardBounce);
    }

    public List<Email> findByLegacyEpid(Object legacyEpid) {
        return findByProperty(LEGACY_EPID, legacyEpid);
    }

    public List<Email> findByEpid(Object epid) {
        return findByProperty(EPID, epid);
    }

    /**
     * Find all Email entities.
     * 
     * @return List<Email> all Email entities
     */
    @SuppressWarnings("unchecked")
    public List<Email> findAll() {
        EntityManagerHelper.log("finding all Email instances", Level.INFO, null);
        try {
            final String queryString = "select model from Email model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}