package id.or.linuxjak.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

public interface GenericDao<T> {

	 Session getSession() ;
	List<T> getAll(Class<T> clazz);

	long countAll(Map<Object, String> param);

	void create(T t);

	void delete(T t);

	T find(Class<T> clazz, Long id);

	void update(T t);

}
