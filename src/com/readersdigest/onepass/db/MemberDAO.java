package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Member entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.db.Member
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class MemberDAO implements IMemberDAO {
    // property constants
    public static final String MEMBER_NAME = "memberName";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_HINT_QUESTION = "passwordHintQuestion";
    public static final String PASSWORD_HINT_ANSWER = "passwordHintAnswer";
    public static final String LAST_LOGIN_IP_ADDRESS = "lastLoginIpAddress";
    public static final String COOKIE_GUID = "cookieGuid";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Member entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Member entity) {
        EntityManagerHelper.log("saving Member instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.db.IMemberDAO#refresh(com.readersdigest.onepass.db.Member)
     */
    public Member refresh(Member entity) {
        EntityManagerHelper.log("refresh Member instance", Level.INFO, null);
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
     * Delete a persistent Member entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Member entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Member entity) {
        EntityManagerHelper.log("deleting Member instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(Member.class, entity.getMemberId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Member entity and return it or a copy of it to
     * the sender. A copy of the Member entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated
     * entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = MemberDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Member entity to update
     * @return Member the persisted Member entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Member update(Member entity) {
        EntityManagerHelper.log("updating Member instance", Level.INFO, null);
        try {
            Member result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public Member findById(Integer id) {
        EntityManagerHelper.log("finding Member instance with id: " + id, Level.INFO, null);
        try {
            Member instance = getEntityManager().find(Member.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all Member entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Member property to query
     * @param value
     *            the property value to match
     * @return List<Member> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Member> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding Member instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from Member model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<Member> findByMemberName(Object memberName) {
        return findByProperty(MEMBER_NAME, memberName);
    }

    public List<Member> findByPassword(Object password) {
        return findByProperty(PASSWORD, password);
    }

    public List<Member> findByPasswordHintQuestion(Object passwordHintQuestion) {
        return findByProperty(PASSWORD_HINT_QUESTION, passwordHintQuestion);
    }

    public List<Member> findByPasswordHintAnswer(Object passwordHintAnswer) {
        return findByProperty(PASSWORD_HINT_ANSWER, passwordHintAnswer);
    }

    public List<Member> findByLastLoginIpAddress(Object lastLoginIpAddress) {
        return findByProperty(LAST_LOGIN_IP_ADDRESS, lastLoginIpAddress);
    }

    public List<Member> findByCookieGuid(Object cookieGuid) {
        return findByProperty(COOKIE_GUID, cookieGuid);
    }

    /**
     * Find all Member entities.
     * 
     * @return List<Member> all Member entities
     */
    @SuppressWarnings("unchecked")
    public List<Member> findAll() {
        EntityManagerHelper.log("finding all Member instances", Level.INFO, null);
        try {
            final String queryString = "select model from Member model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}