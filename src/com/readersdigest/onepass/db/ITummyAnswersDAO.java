package com.readersdigest.onepass.db;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for TummyAnswersDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITummyAnswersDAO {
	/**
	 * Perform an initial save of a previously unsaved TummyAnswers entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITummyAnswersDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TummyAnswers entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(TummyAnswers entity);

	/**
	 * Delete a persistent TummyAnswers entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITummyAnswersDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            TummyAnswers entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(TummyAnswers entity);

	/**
	 * Persist a previously saved TummyAnswers entity and return it or a copy of
	 * it to the sender. A copy of the TummyAnswers entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ITummyAnswersDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TummyAnswers entity to update
	 * @return TummyAnswers the persisted TummyAnswers entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public TummyAnswers update(TummyAnswers entity);

	public TummyAnswers findById(Integer id);

	/**
	 * Find all TummyAnswers entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the TummyAnswers property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<TummyAnswers> found by query
	 */
	public List<TummyAnswers> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<TummyAnswers> findByQuestionId(Object questionId,
			int... rowStartIdxAndCount);

	public List<TummyAnswers> findByAnswer(Object answer,
			int... rowStartIdxAndCount);

	/**
	 * Find all TummyAnswers entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<TummyAnswers> all TummyAnswers entities
	 */
	public List<TummyAnswers> findAll(int... rowStartIdxAndCount);
}