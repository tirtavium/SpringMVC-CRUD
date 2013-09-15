package id.or.linuxjak.service.common;

import java.util.List;
import java.util.Map;

public interface ServiceHelper<T> {
 List<T> getAll(Class <T> clazz);
	

	
	long countAll(Map<Object, String> param);
	
	void create(T t);
	
	void delete(T t);
	
	T find(Class<T> clazz, Long id);
	void update(T t);
}
