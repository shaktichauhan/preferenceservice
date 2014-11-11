package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Subdivision entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.Subdivision
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class SubdivisionDAO implements ISubdivisionDAO {
    // property constants
    public static final String SUBDIVISION_NAME1 = "subdivisionName1";
    public static final String SUBDIVISION_NAME2 = "subdivisionName2";
    public static final String SUBDIVISION_NAME3 = "subdivisionName3";
    public static final String REGIONAL_DIVISION = "regionalDivision";
    public static final String SUBDIVISION_CATEGORY = "subdivisionCategory";
    public static final String I3C_SUBDIVISION_CODE = "i3cSubdivisionCode";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Subdivision entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * SubdivisionDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(Subdivision entity) {
        EntityManagerHelper.log("saving Subdivision instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Delete a persistent Subdivision entity. This operation must be performed
     * within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * SubdivisionDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(Subdivision entity) {
        EntityManagerHelper.log("deleting Subdivision instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(Subdivision.class, entity.getSubdivisionCode());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Subdivision entity and return it or a copy of
     * it to the sender. A copy of the Subdivision entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the
     * updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = SubdivisionDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            Subdivision entity to update
     * @return Subdivision the persisted Subdivision entity instance, may not be
     *         the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public Subdivision update(Subdivision entity) {
        EntityManagerHelper.log("updating Subdivision instance", Level.INFO, null);
        try {
            Subdivision result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public Subdivision findById(String id) {
        EntityManagerHelper.log("finding Subdivision instance with id: " + id, Level.INFO, null);
        try {
            Subdivision instance = getEntityManager().find(Subdivision.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all Subdivision entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the Subdivision property to query
     * @param value
     *            the property value to match
     * @return List<Subdivision> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Subdivision> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding Subdivision instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from Subdivision model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<Subdivision> findBySubdivisionName1(Object subdivisionName1) {
        return findByProperty(SUBDIVISION_NAME1, subdivisionName1);
    }

    public List<Subdivision> findBySubdivisionName2(Object subdivisionName2) {
        return findByProperty(SUBDIVISION_NAME2, subdivisionName2);
    }

    public List<Subdivision> findBySubdivisionName3(Object subdivisionName3) {
        return findByProperty(SUBDIVISION_NAME3, subdivisionName3);
    }

    public List<Subdivision> findByRegionalDivision(Object regionalDivision) {
        return findByProperty(REGIONAL_DIVISION, regionalDivision);
    }

    public List<Subdivision> findBySubdivisionCategory(Object subdivisionCategory) {
        return findByProperty(SUBDIVISION_CATEGORY, subdivisionCategory);
    }

    public List<Subdivision> findByI3cSubdivisionCode(Object i3cSubdivisionCode) {
        return findByProperty(I3C_SUBDIVISION_CODE, i3cSubdivisionCode);
    }

    /**
     * Find all Subdivision entities.
     * 
     * @return List<Subdivision> all Subdivision entities
     */
    @SuppressWarnings("unchecked")
    public List<Subdivision> findAll() {
        EntityManagerHelper.log("finding all Subdivision instances", Level.INFO, null);
        try {
            final String queryString = "select model from Subdivision model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}