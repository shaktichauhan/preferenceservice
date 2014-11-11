package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * MemberOnePassTummy entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.readersdigest.sweeps.db.MemberOnePassTummy
 * @author MyEclipse Persistence Tools
 */
public class MemberOnePassTummyDAO implements IMemberOnePassTummyDAO {
	// property constants
	public static final String WEIGHT = "weight";
	public static final String PAID_USER = "paidUser";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MemberOnePassTummy
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MemberOnePassTummyDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(MemberOnePassTummy entity) {
		EntityManagerHelper.log("saving MemberOnePassTummy instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent MemberOnePassTummy entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MemberOnePassTummyDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(MemberOnePassTummy entity) {
		EntityManagerHelper.log("deleting MemberOnePassTummy instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(MemberOnePassTummy.class,
					entity.getMemberOnePassTummyId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved MemberOnePassTummy entity and return it or a
	 * copy of it to the sender. A copy of the MemberOnePassTummy entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MemberOnePassTummyDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            MemberOnePassTummy entity to update
	 * @return MemberOnePassTummy the persisted MemberOnePassTummy entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public MemberOnePassTummy update(MemberOnePassTummy entity) {
		EntityManagerHelper.log("updating MemberOnePassTummy instance",
				Level.INFO, null);
		try {
			MemberOnePassTummy result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public MemberOnePassTummy findById(Integer id) {
		EntityManagerHelper.log("finding MemberOnePassTummy instance with id: "
				+ id, Level.INFO, null);
		try {
			MemberOnePassTummy instance = getEntityManager().find(
					MemberOnePassTummy.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all MemberOnePassTummy entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the MemberOnePassTummy property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<MemberOnePassTummy> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassTummy> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding MemberOnePassTummy instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MemberOnePassTummy model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<MemberOnePassTummy> findByWeight(Object weight,
			int... rowStartIdxAndCount) {
		return findByProperty(WEIGHT, weight, rowStartIdxAndCount);
	}

	public List<MemberOnePassTummy> findByPaidUser(Object paidUser,
			int... rowStartIdxAndCount) {
		return findByProperty(PAID_USER, paidUser, rowStartIdxAndCount);
	}

	/**
	 * Find all MemberOnePassTummy entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<MemberOnePassTummy> all MemberOnePassTummy entities
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassTummy> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all MemberOnePassTummy instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from MemberOnePassTummy model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}