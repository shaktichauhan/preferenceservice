package com.readersdigest.onepass.db;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmailValid entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.readersdigest.sweeps.db.EmailValid
 * @author MyEclipse Persistence Tools
 */
public class EmailValidDAO implements IEmailValidDAO {
	// property constants
	public static final String TOKEN = "token";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved EmailValid entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EmailValidDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(EmailValid entity) {
		EntityManagerHelper.log("saving EmailValid instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
     * @see com.readersdigest.onepass.db.IEmailValidDAO#refresh(com.readersdigest.onepass.db.MemberInfo)
     */
    public EmailValid refresh(EmailValid entity) {
        EntityManagerHelper.log("refresh EmailValid instance", Level.INFO, null);
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
	 * Delete a persistent EmailValid entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EmailValidDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(EmailValid entity) {
		EntityManagerHelper.log("deleting EmailValid instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(EmailValid.class,
					entity.getEmailValidId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved EmailValid entity and return it or a copy of
	 * it to the sender. A copy of the EmailValid entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = EmailValidDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            EmailValid entity to update
	 * @return EmailValid the persisted EmailValid entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public EmailValid update(EmailValid entity) {
		EntityManagerHelper.log("updating EmailValid instance", Level.INFO,
				null);
		try {
			EmailValid result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public EmailValid findById(Integer id) {
		EntityManagerHelper.log("finding EmailValid instance with id: " + id,
				Level.INFO, null);
		try {
			EmailValid instance = getEntityManager().find(EmailValid.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all EmailValid entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the EmailValid property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<EmailValid> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<EmailValid> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding EmailValid instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from EmailValid model where model."
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
	
	@SuppressWarnings("unchecked")
	public List<EmailValid> findByProperties(String propertyName1, String propertyName2, final Object value1, final Object value2) {
	    EntityManagerHelper.log("finding EmailValid instance with property1: " + propertyName1 + ", value1: "
                + value1 + "property2: " + propertyName2 + ", value2: " + value2, Level.INFO, null);
        try {
            final String queryString = "select model from EmailValid model where model." + propertyName1
                    + "= :propertyValue1" + " and model." + propertyName2 + "= :propertyValue2";
            
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue1", value1);
            query.setParameter("propertyValue2", value2);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
	}


	public List<EmailValid> findByToken(Object token,
			int... rowStartIdxAndCount) {
		return findByProperty(TOKEN, token, rowStartIdxAndCount);
	}

	public List<EmailValid> findByValid(Object valid,
			int... rowStartIdxAndCount) {
		return findByProperty(VALID, valid, rowStartIdxAndCount);
	}

	/**
	 * Find all EmailValid entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<EmailValid> all EmailValid entities
	 */
	@SuppressWarnings("unchecked")
	public List<EmailValid> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all EmailValid instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from EmailValid model";
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