package com.readersdigest.onepass.jpa.dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.readersdigest.onepass.jpa.EntityManagerHelper;
import com.readersdigest.onepass.jpa.OpAddress;
import com.readersdigest.onepass.jpa.OpAddressId;

/**
 * A data access object (DAO) providing persistence and search support for
 * OpAddress entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.onepass.jpa.OpAddress
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */

public class OpAddressDAO implements IOpAddressDAO {
	// property constants
	public static final String STREET1 = "street1";
	public static final String STREET2 = "street2";
	public static final String CITY = "city";
	public static final String STATE_NM = "stateNm";
	public static final String ZIP = "zip";
	public static final String COUNTRY = "country";
	public static final String PRIMARY_FLAG = "primaryFlag";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved OpAddress entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpAddressDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OpAddress entity) {
		EntityManagerHelper.log("saving OpAddress instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent OpAddress entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OpAddressDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OpAddress entity) {
		EntityManagerHelper
				.log("deleting OpAddress instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OpAddress.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved OpAddress entity and return it or a copy of it
	 * to the sender. A copy of the OpAddress entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OpAddressDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OpAddress entity to update
	 * @return OpAddress the persisted OpAddress entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OpAddress update(OpAddress entity) {
		EntityManagerHelper
				.log("updating OpAddress instance", Level.INFO, null);
		try {
			OpAddress result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OpAddress findById(Integer id) {
		EntityManagerHelper.log("finding OpAddress instance with id: " + id,
				Level.INFO, null);
		try {
			OpAddress instance = getEntityManager().find(OpAddress.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OpAddress entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OpAddress property to query
	 * @param value
	 *            the property value to match
	 * @return List<OpAddress> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OpAddress> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding OpAddress instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from OpAddress model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<OpAddress> findByStreet1(Object street1) {
		return findByProperty(STREET1, street1);
	}

	public List<OpAddress> findByStreet2(Object street2) {
		return findByProperty(STREET2, street2);
	}

	public List<OpAddress> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<OpAddress> findByStateNm(Object stateNm) {
		return findByProperty(STATE_NM, stateNm);
	}

	public List<OpAddress> findByZip(Object zip) {
		return findByProperty(ZIP, zip);
	}

	public List<OpAddress> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List<OpAddress> findByPrimaryFlag(Object primaryFlag) {
		return findByProperty(PRIMARY_FLAG, primaryFlag);
	}

	/**
	 * Find all OpAddress entities.
	 * 
	 * @return List<OpAddress> all OpAddress entities
	 */
	@SuppressWarnings("unchecked")
	public List<OpAddress> findAll() {
		EntityManagerHelper.log("finding all OpAddress instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from OpAddress model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
