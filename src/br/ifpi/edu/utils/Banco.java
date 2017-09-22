package br.ifpi.edu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class Banco {
	private DataSource dataSource;
	public Banco() throws SQLException {
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:hsqldb:hsql://localhost/beauty");
		pool.setUser("SA");
		pool.setPassword("");
		dataSource = pool;
	}
	public Connection getConection() throws SQLException {
		Connection c =  dataSource.getConnection();
		return c;
	}
}
