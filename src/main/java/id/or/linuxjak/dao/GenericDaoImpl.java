package id.or.linuxjak.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("genericDao")
public class GenericDaoImpl<T> implements GenericDao<T> {

	private HibernateTemplate hibernate;

	private SessionFactory sessionFactory;

	@Autowired
	public GenericDaoImpl(SessionFactory sessionFactory) {
		super();
		this.hibernate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public final Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public List<T> getAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return hibernate.loadAll(clazz);
	}

	public long countAll(Map<Object, String> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public T find(Class<T> t, Long id) {
		// TODO Auto-generated method stub
		return hibernate.get(t, id);
	}

	

	public void create(T t) {
		// TODO Auto-generated method stub
		hibernate.saveOrUpdate(t);
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		hibernate.delete(t);
	}
	

	

	public void update(T t) {
		// TODO Auto-generated method stub
		//hibernate.getSessionFactory().getCurrentSession().update(t);
		hibernate.saveOrUpdate(t);
	}

}
