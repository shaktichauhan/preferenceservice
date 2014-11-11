package com.readersdigest.sweepapi.db;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

// TODO: Auto-generated Javadoc
/**
 * A data access object (DAO) providing persistence and search support for Email
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @author Wilson Soethe Cursino - wilson.cursino@rd.com
 * @see com.readersdigest.onepass.db.Email
 */

public class SweepEntryDAO implements ISweepEntryDAO {
    // property constants


    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Email entity. All
     * subsequent persist actions of this entity should use the #update()
     * method. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the
     * persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#persist(Object)
     * EntityManager#persist} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * EmailDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity            Email entity to persist
     */
    public void save(SweepsEntry entity) {
        EntityManagerHelper.log("saving SweepsEntry instance", Level.INFO, null);
        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Refresh.
     *
     * @param entity the entity
     * @return the email
     */
    public SweepsEntry refresh(SweepsEntry entity) {
        EntityManagerHelper.log("refresh SweepsEntry instance", Level.INFO, null);
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
     * Delete a persistent Email entity. This operation must be performed within
     * the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This
     * method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     * 
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * EmailDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity            Email entity to delete
     */
    public void delete(SweepsEntry entity) {
        EntityManagerHelper.log("deleting SweepsEntry instance", Level.INFO, null);
        try {
            entity = getEntityManager().getReference(SweepsEntry.class, entity.getSeId());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Email entity and return it or a copy of it to
     * the sender. A copy of the Email entity parameter is returned when the JPA
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
     * @param entity            Email entity to update
     * @return Email the persisted Email entity instance, may not be the same
     */
    public SweepsEntry update(SweepsEntry entity) {
        EntityManagerHelper.log("updating SweepsEntry instance", Level.INFO, null);
        try {
        	SweepsEntry result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);
            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    /* (non-Javadoc)
     * @see com.readersdigest.sweepapi.db.ISweepEntryDAO#findById(java.lang.Integer)
     */
    public SweepsEntry findById(Integer id) {
        EntityManagerHelper.log("finding SweepsEntry instance with id: " + id, Level.INFO, null);
        try {
        	SweepsEntry instance = getEntityManager().find(SweepsEntry.class, id);
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
    public List<SweepsEntry> findByProperty(String propertyName, final Object value) {
        EntityManagerHelper.log("finding SweepsEntry instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
        try {
            final String queryString = "select model from SweepsEntry model where model." + propertyName + "= :propertyValue order by " +
            		"model.effectiveDate desc";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
     * @see com.readersdigest.sweepapi.db.ISweepEntryDAO#getListValidationId(java.lang.Integer)
     */
    public SweepValidation getListValidationId(Integer sepId) {
    	String SQL = "SELECT sep.active AS sep_active, slp.active AS slp_active, sp.active AS sp_active, "+ 
        "slp.online AS slp_online, slp.landing_path AS slp_landing_path, sp.start_date AS sp_start_date, "+
        "sp.end_date AS sp_end_date, slp.end_date AS slp_end_date, sp.sp_id " +
        "FROM sweeps..SweepsLandingPage slp, sweeps..SweepsEntryPoint sep, sweeps..SweepsPrize sp, sweeps..SweepsPrize_LandingPage splp "+
        "WHERE slp.slp_id = sep.slp_id AND slp.slp_id = splp.slp_id AND splp.sp_id = sp.sp_id AND sep.sep_id =" + sepId ;
    
    	SweepValidation sweepVal = new SweepValidation();
    	
        try {
        	 Query query = getEntityManager().createNativeQuery(SQL);
        	 //query.setParameter("sep_id", sepId);
        	 List result = query.getResultList();  
        	 Iterator it = result.iterator();
        	 
			while(it.hasNext())
			{
				Object row[] = (Object[])it.next();	
				sweepVal.setSepActive((String)row[0]);
				sweepVal.setSlpActive((String)row[1]);
				sweepVal.setSpActive((String)row[2]);
				sweepVal.setSlpOnline((String)row[3]);
				sweepVal.setSlpLandingPath((String)row[4]);
				sweepVal.setSpStartDate((Timestamp)row[5]);
				sweepVal.setSpEndDate((Timestamp)row[6]);
				sweepVal.setSlpEndDate((Timestamp)row[7]);
				sweepVal.setSpId((Integer)row[8]);
			}
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
        
        return sweepVal;
    }
  

}