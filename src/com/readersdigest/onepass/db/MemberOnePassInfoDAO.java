package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

// TODO: Auto-generated Javadoc
/**
 * A data access object (DAO) providing persistence and search support for
 * MemberOnePassInfo entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 *
 * @author shsingh - shakti_singh@consultant.rd.com
 * @see com.readersdigest.onepass.db.Email
 */

public class MemberOnePassInfoDAO implements IMemberOnePassInfoDAO {
	// property constants
	/** The Constant MEMBER_INFO_ID. */
	public static final String MEMBER_INFO_ID = "memberInfo.memberInfoId";
	
	/** The Constant ACCOUNT_NUMBER. */
	public static final String ACCOUNT_NUMBER = "accountNumber";

	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved MemberOnePassInfo entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MemberOnePassInfoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            MemberOnePassInfo entity to persist
	 */
	public void save(MemberOnePassInfo entity) {
		EntityManagerHelper.log("saving MemberOnePassInfo instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.readersdigest.onepass.db.IMemberOnePassInfoDAO#refresh(com.readersdigest
	 * .onepass.db.MemberOnePassInfo)
	 */
	public MemberOnePassInfo refresh(MemberOnePassInfo entity) {
		EntityManagerHelper.log("refresh MemberOnePassInfo instance",
				Level.INFO, null);
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
	 * Delete a persistent MemberOnePassInfo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MemberOnePassInfoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 *
	 * @param entity            MemberOnePassInfo entity to delete
	 */
	public void delete(MemberOnePassInfo entity) {
		EntityManagerHelper.log("deleting MemberOnePassInfo instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(MemberOnePassInfo.class,
					entity.getMemberOnePassInfoId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved MemberOnePassInfo entity and return it or a
	 * copy of it to the sender. A copy of the MemberOnePassInfo entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = EmailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 *
	 * @param entity            MemberOnePassInfo entity to update
	 * @return MemberOnePassInfo the persisted MemberOnePassInfo entity
	 *         instance, may not be the same
	 */
	public MemberOnePassInfo update(MemberOnePassInfo entity) {
		EntityManagerHelper.log("updating MemberOnePassInfo instance",
				Level.INFO, null);
		try {
			MemberOnePassInfo result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findById(java.lang.Integer)
	 */
	public MemberOnePassInfo findById(Integer id) {
		EntityManagerHelper.log("finding Email instance with id: " + id,
				Level.INFO, null);
		try {
			MemberOnePassInfo instance = getEntityManager().find(
					MemberOnePassInfo.class, id);
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
	 * @return List<MemberOnePassInfo> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassInfo> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding MemberOnePassInfo instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from MemberOnePassInfo model where model."
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

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByProperties(java.lang.String, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, final Object value1, final Object value2) {
		EntityManagerHelper.log(
				"finding MemberOnePassInfo instance with property1: "
						+ propertyName1 + ", value1: " + value1 + "property2: "
						+ propertyName2 + ", value2: " + value2, Level.INFO,
				null);
		try {
			final String queryString = "select model from MemberOnePassInfo model where model."
					+ propertyName1
					+ "= :propertyValue1"
					+ " and model."
					+ propertyName2
					+ "= :propertyValue2"
					+ " order by model.memberOnePassInfoId desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByProperties(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, final Object value1,
			final Object value2, final Object value3) {
		EntityManagerHelper.log(
				"finding MemberOnePassInfo instance with property1: "
						+ propertyName1 + ", value1: " + value1 + "property2: "
						+ propertyName2 + ", value2: " + value2 + "property3: "
						+ propertyName3 + ", value3: " + value3, Level.INFO,
				null);
		try {
			final String queryString = "select model from MemberOnePassInfo model where model."
					+ propertyName1
					+ "= :propertyValue1"
					+ " and model."
					+ propertyName2
					+ "= :propertyValue2"
					+ " and model."
					+ propertyName3
					+ "= :propertyValue3"
					+ " order by model.memberOnePassInfoId desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			query.setParameter("propertyValue2", value2);
			query.setParameter("propertyValue3", value3);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByProperties(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, String propertyName4,
			final Object value1, final Object value2, final Object value3,
			final Object value4) {
		EntityManagerHelper.log(
				"finding MemberOnePassInfo instance with property1: "
						+ propertyName1 + ", value1: " + value1 + "property2: "
						+ propertyName2 + ", value2: " + value2 + "property3: "
						+ propertyName3 + ", value3: " + value3 + "property4: "
						+ propertyName4 + ", value4: " + value4, Level.INFO,
				null);
		try {
			final String queryString = "select model from MemberOnePassInfo model where model."
					+ propertyName1
					+ "= :propertyValue1"
					+ " and model."
					+ propertyName2
					+ "= :propertyValue2"
					+ " and model."
					+ propertyName3
					+ "= :propertyValue3"
					+ " and model."
					+ propertyName4
					+ "= :propertyValue4"
					+ " order by model.memberOnePassInfoId desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			query.setParameter("propertyValue2", value2);
			query.setParameter("propertyValue3", value3);
			query.setParameter("propertyValue4", value4);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByProperties(java.lang.String, java.lang.String, java.lang.String, java.lang.Object[], java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List<MemberOnePassInfo> findByProperties(String propertyName1,
			String propertyName2, String propertyName3, final Object value[],
			final Object value2, final Object value3) {
		EntityManagerHelper.log(
				"finding MemberOnePassInfo instance with property1: "
						+ propertyName1 + ", value1: " + value[1], Level.INFO,
				null);
		try {
			final String queryString = "select model from MemberOnePassInfo model where model."
					+ propertyName1
					+ " IN (:propertyValue1,:propertyValue2,:propertyValue3)"
					+ " and model."
					+ propertyName2
					+ "= :propertyValue4"
					+ " and model."
					+ propertyName3
					+ "= :propertyValue5"
					+ " order by model.memberOnePassInfoId desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value[0]);
			query.setParameter("propertyValue2", value[1]);
			query.setParameter("propertyValue3", value[2]);
			query.setParameter("propertyValue4", value2);
			query.setParameter("propertyValue5", value3);

			return query.getResultList();

		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByMemberInfoId(java.lang.Object)
	 */
	public List<MemberOnePassInfo> findByMemberInfoId(Object memberInfoId) {
		return findByProperty(MEMBER_INFO_ID, memberInfoId);
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.onepass.db.IMemberOnePassInfoDAO#findByAccountNumber(java.lang.String)
	 */
	public List<MemberOnePassInfo> findByAccountNumber(String accountNumber) {
		return findByProperty(ACCOUNT_NUMBER, accountNumber);
	}

}