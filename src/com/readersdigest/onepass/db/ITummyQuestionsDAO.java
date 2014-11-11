package com.readersdigest.onepass.db;

import java.util.List;

/**
 * Interface for TummyQuestionsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITummyQuestionsDAO {
	/**
	 * Perform an initial save of a previously unsaved TummyQuestions entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITummyQuestionsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TummyQuestions entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(TummyQuestions entity);

	/**
	 * Delete a persistent TummyQuestions entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITummyQuestionsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            TummyQuestions entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(TummyQuestions entity);

	/**
	 * Persist a previously saved TummyQuestions entity and return it or a copy
	 * of it to the sender. A copy of the TummyQuestions entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ITummyQuestionsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            TummyQuestions entity to update
	 * @return TummyQuestions the persisted TummyQuestions entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public TummyQuestions update(TummyQuestions entity);

	public TummyQuestions findById(Integer id);

	/**
	 * Find all TummyQuestions entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the TummyQuestions property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<TummyQuestions> found by query
	 */
	public List<TummyQuestions> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<TummyQuestions> findByQuestionDesc(Object questionDesc,
			int... rowStartIdxAndCount);

	/**
	 * Find all TummyQuestions entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<TummyQuestions> all TummyQuestions entities
	 */
	public List<TummyQuestions> findAll(int... rowStartIdxAndCount);
}