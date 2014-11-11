package com.readersdigest.preference.dao;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import com.readersdigest.preference.domain.Preference;
import com.readersdigest.util.hibernate.HibernateUtil;

public class PreferenceDao {

	public void savePreference(Preference preference) {

		Session session;

		try {
			session = HibernateUtil.getSession();
			session.save(preference);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
