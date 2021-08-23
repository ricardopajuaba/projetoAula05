package interfaces;

import java.util.List;

//<T> representa um tipo de dado genérico
public interface ICrudRepository<T> {

	void create(T obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	List<T> read() throws Exception;

}
