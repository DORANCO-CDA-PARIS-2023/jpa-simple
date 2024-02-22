package jpa.dao;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;

public interface ICrud<T> {
	public List<T> findAll(EntityManager em) throws Exception;
	public T getById(EntityManager em, int id) throws Exception;
	public void add(EntityManager em, T entity) throws SQLException, Exception;
	public void remove(EntityManager em, int id) throws Exception;
}
