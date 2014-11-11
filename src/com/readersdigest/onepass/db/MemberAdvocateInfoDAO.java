package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for MemberAdvocateInfo
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.Email
 * @author shsingh - shakti_singh@consultant.rd.com
 */

public class MemberAdvocateInfoDAO implements IMemberAdvocateInfoDAO {
    // property constants
    public static final String MEMBER_ID = "member.memberId";
    public static final String ACCOUNT_NUMBER = "accountNumber";


    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved MemberAdvocateInfo entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberAdvocateInfoDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            MemberAdvocateInfo entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(MemberAdvocateInfo entity) {
        EntityManagerHelper.log("saving Email instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.db.IMemberAdvocateInfoDAO#refresh(com.readersdigest.onepass.db.MemberAdvocateInfo)
     */
    public MemberAdvocateInfo refresh(MemberAdvocateInfo entity) {
        EntityManagerHelper.log("refresh MemberAdvocateInfo instance", Level.INFO, null);
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
     * Delete a persistent MemberAdvocateInfo entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * MemberAdvocateInfoDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            MemberAdvocateInfo entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(MemberAdvocateInfo entity) {
        EntityManagerHelper.log("deleting Email instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(MemberAdvocateInfo.class, entity.getAdvocateId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved MemberAdvocateInfo entity and return it or a copy of it to
     * the sender. A copy of the MemberAdvocateInfo entity parameter is returned when the JPA
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
     *            MemberAdvocateInfo entity to update
     * @return MemberAdvocateInfo the persisted MemberAdvocateInfo entity instance, may not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public MemberAdvocateInfo update(MemberAdvocateInfo entity) {
        EntityManagerHelper.log("updating Email instance", Level.INFO, null);
        try {
            MemberAdvocateInfo result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public MemberAdvocateInfo findById(Integer id) {
        EntityManagerHelper.log("finding Email instance with id: " + id, Level.INFO, null);
        try {
            MemberAdvocateInfo instance = getEntityManager().find(MemberAdvocateInfo.class, id);
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
    public List<MemberAdvocateInfo> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding MemberAdvocateInfo instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from MemberAdvocateInfo model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }
    
       
}