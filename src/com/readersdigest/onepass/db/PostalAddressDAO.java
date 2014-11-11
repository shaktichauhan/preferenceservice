package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * PostalAddress entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.onepass.db.PostalAddress
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class PostalAddressDAO implements IPostalAddressDAO {
    // property constants
    public static final String FIRST_NAME = "firstName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String LAST_NAME = "lastName";
    public static final String TITLE = "title";
    public static final String ADDRESS1 = "address1";
    public static final String ADDRESS2 = "address2";
    public static final String ADDRESS3 = "address3";
    public static final String ADDRESS4 = "address4";
    public static final String CITY = "city";
    public static final String ZIP = "zip";
    public static final String VALID = "valid";
    public static final String POSTAL_CLEANSED_ADDRESS1 = "postalCleansedAddress1";
    public static final String POSTAL_CLEANSED_CITY = "postalCleansedCity";
    public static final String POSTAL_CLEANSED_STATE = "postalCleansedState";
    public static final String POSTAL_CLEANSED_ZIP = "postalCleansedZip";
    public static final String POSTAL_CLEANSED_COUNTY = "postalCleansedCounty";
    public static final String IS_PENDING = "isPending";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved PostalAddress entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * PostalAddressDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to persist
     * @throws RuntimeException
     *             when the operation fails
     */
    public void save(PostalAddress entity) {
        EntityManagerHelper.log("saving PostalAddress instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Delete a persistent PostalAddress entity. This operation must be
     * performed within the a database transaction context for the entity's data
     * to be permanently deleted from the persistence store, i.e., database.
     * This method uses the
     * {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * PostalAddressDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to delete
     * @throws RuntimeException
     *             when the operation fails
     */
    public void delete(PostalAddress entity) {
        EntityManagerHelper.log("deleting PostalAddress instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(PostalAddress.class, entity.getPostalAddressId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved PostalAddress entity and return it or a copy
     * of it to the sender. A copy of the PostalAddress entity parameter is
     * returned when the JPA persistence mechanism has not previously been
     * tracking the updated entity. This operation must be performed within the
     * a database transaction context for the entity's data to be permanently
     * saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
     * operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = PostalAddressDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     * 
     * @param entity
     *            PostalAddress entity to update
     * @return PostalAddress the persisted PostalAddress entity instance, may
     *         not be the same
     * @throws RuntimeException
     *             if the operation fails
     */
    public PostalAddress update(PostalAddress entity) {
        EntityManagerHelper.log("updating PostalAddress instance", Level.INFO, null);
        try {
            PostalAddress result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public PostalAddress findById(Integer id) {
        EntityManagerHelper.log("finding PostalAddress instance with id: " + id, Level.INFO, null);
        try {
            PostalAddress instance = getEntityManager().find(PostalAddress.class, id);
            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Find all PostalAddress entities with a specific property value.
     * 
     * @param propertyName
     *            the name of the PostalAddress property to query
     * @param value
     *            the property value to match
     * @return List<PostalAddress> found by query
     */
    @SuppressWarnings("unchecked")
    public List<PostalAddress> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding PostalAddress instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from PostalAddress model where model." + propertyName + "= :propertyValue" +
            		" order by model.postalAddressId desc";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<PostalAddress> findByFirstName(Object firstName) {
        return findByProperty(FIRST_NAME, firstName);
    }

    public List<PostalAddress> findByMiddleName(Object middleName) {
        return findByProperty(MIDDLE_NAME, middleName);
    }

    public List<PostalAddress> findByLastName(Object lastName) {
        return findByProperty(LAST_NAME, lastName);
    }

    public List<PostalAddress> findByTitle(Object title) {
        return findByProperty(TITLE, title);
    }

    public List<PostalAddress> findByAddress1(Object address1) {
        return findByProperty(ADDRESS1, address1);
    }

    public List<PostalAddress> findByAddress2(Object address2) {
        return findByProperty(ADDRESS2, address2);
    }

    public List<PostalAddress> findByAddress3(Object address3) {
        return findByProperty(ADDRESS3, address3);
    }

    public List<PostalAddress> findByAddress4(Object address4) {
        return findByProperty(ADDRESS4, address4);
    }

    public List<PostalAddress> findByCity(Object city) {
        return findByProperty(CITY, city);
    }

    public List<PostalAddress> findByZip(Object zip) {
        return findByProperty(ZIP, zip);
    }

    public List<PostalAddress> findByValid(Object valid) {
        return findByProperty(VALID, valid);
    }

    public List<PostalAddress> findByPostalCleansedAddress1(Object postalCleansedAddress1) {
        return findByProperty(POSTAL_CLEANSED_ADDRESS1, postalCleansedAddress1);
    }

    public List<PostalAddress> findByPostalCleansedCity(Object postalCleansedCity) {
        return findByProperty(POSTAL_CLEANSED_CITY, postalCleansedCity);
    }

    public List<PostalAddress> findByPostalCleansedState(Object postalCleansedState) {
        return findByProperty(POSTAL_CLEANSED_STATE, postalCleansedState);
    }

    public List<PostalAddress> findByPostalCleansedZip(Object postalCleansedZip) {
        return findByProperty(POSTAL_CLEANSED_ZIP, postalCleansedZip);
    }

    public List<PostalAddress> findByPostalCleansedCounty(Object postalCleansedCounty) {
        return findByProperty(POSTAL_CLEANSED_COUNTY, postalCleansedCounty);
    }

    public List<PostalAddress> findByIsPending(Object isPending) {
        return findByProperty(IS_PENDING, isPending);
    }

    /**
     * Find all PostalAddress entities.
     * 
     * @return List<PostalAddress> all PostalAddress entities
     */
    @SuppressWarnings("unchecked")
    public List<PostalAddress> findAll() {
        EntityManagerHelper.log("finding all PostalAddress instances", Level.INFO, null);
        try {
            final String queryString = "select model from PostalAddress model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

}