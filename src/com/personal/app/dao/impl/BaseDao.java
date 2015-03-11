package com.personal.app.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao {

	
	protected HibernateTemplate hibernateTemplate;

	/**
	 * @return (s) an object from local thread which will be an instance of
	 *         HibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return getHibernateTemplate().getSessionFactory();
	}

	public Session getSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	// ///////////////////////////////////////////////////////

	/**
	 * This is responsble to save or update any Serializable instance of any
	 * type of Entity
	 * 
	 * @param entity
	 */
	public Serializable saveOrUpdate(Serializable serializableEntity) {
		hibernateTemplate.saveOrUpdate(serializableEntity);
		return serializableEntity;
	}

}
