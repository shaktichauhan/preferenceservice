package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for MemberPWDReset
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.Email
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public class MemberPWDResetDAO implements IMemberPWDResetDAO {
    // property constants
    public static final String MEMBER_ID = "member.memberId";
    public static final String TOKEN = "token";


    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved MemberPWDReset entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberPWDResetDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(MemberPWDReset entity) {
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
     * Delete a persistent MemberPWDReset entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberPWDResetDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(MemberPWDReset entity) {
        EntityManagerHelper.log("deleting Email instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(MemberPWDReset.class, entity.getMemberPWDId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved MemberPWDReset entity and return it or a copy of it to
     * the sender. A copy of the MemberPWDReset entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = MemberPWDResetDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberPWDReset entity to update
     * @return MemberInfo the persisted MemberInfo entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public MemberPWDReset update(MemberPWDReset entity) {
        EntityManagerHelper.log("updating MemberPWDReset instance", Level.INFO, null);
        try {
            MemberPWDReset result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public MemberPWDReset findById(Integer id) {
        EntityManagerHelper.log("finding MemberPWDReset instance with id: " + id, Level.INFO, null);
        try {
            MemberPWDReset instance = getEntityManager().find(MemberPWDReset.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all MemberPWDReset entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the MemberPWDReset property to query
     * @param value
     *            the property value to match
     * @return List<MemberPWDReset> found by query
     */
    @SuppressWarnings("unchecked")
    public List<MemberPWDReset> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding MemberPWDReset instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from MemberPWDReset model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<MemberPWDReset> findByMemberId(Object memberId) {
        return findByProperty(MEMBER_ID, memberId);
    }

    public List<MemberPWDReset> findByToken(String token) {
        return findByProperty(TOKEN, token);
    }

    
}