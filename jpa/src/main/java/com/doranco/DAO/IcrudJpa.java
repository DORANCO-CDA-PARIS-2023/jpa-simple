package com.doranco.DAO;
import java.sql.SQLException;
import java.util.List;


public interface IcrudJpa <T> {
	 public T find(int id, T entity) throws SQLException;

	    public  List<T> findAll() throws SQLException;

	    public  void create(T entity) throws SQLException;

	    public void delete(int id) throws SQLException;
	    
	    public T change(int id, T entity) throws SQLException;
}
