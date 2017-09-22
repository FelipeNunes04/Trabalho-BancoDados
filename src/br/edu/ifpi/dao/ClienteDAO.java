package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.bin.Cliente;

public class ClienteDAO {
	private Connection c;
	
	public ClienteDAO(Connection connection) {
		c = connection;
	}
	
	public void salvar(Cliente cli) throws SQLException {
		String sql = "INSERT INTO cliente(nome,endereco,cidade,uf,senha) VALUES(?,?,?,?,?)";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, cli.getNome());
			statement.setString(2, cli.getEndereco());
			statement.setString(3, cli.getCidade());
			statement.setString(4, cli.getUf());
			statement.setString(5, cli.getSenha());
			statement.execute();
			try(ResultSet resultSet = statement.getGeneratedKeys()){
				if(resultSet.next()){
					int id = resultSet.getInt("id");
					cli.setId(id);
				}
			}
		}	
	}
	
	public List<Cliente> listar() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try(PreparedStatement statement = c.prepareStatement(sql)){
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String endereco = resultSet.getString("endereco");
					String cidade = resultSet.getString("cidade");
					String uf = resultSet.getString("uf");
					String senha = resultSet.getString("senha");
					Cliente cli = new Cliente(nome, endereco,cidade,uf,senha);
					cli.setId(id);
					clientes.add(cli);
				}
			}
		}		
		return clientes;
	}
	
	public void atualizar(Cliente cli) throws SQLException {
		String sql = "UPDATE cliente SET nome=?, endereco=?, cidade=?, uf=?, senha=?  WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, cli.getNome());
			statement.setString(2, cli.getEndereco());
			statement.setString(3, cli.getCidade());
			statement.setString(4, cli.getUf());
			statement.setString(5, cli.getSenha());
			statement.setInt(6, cli.getId());
			statement.execute();
		}	
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM cliente WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setInt(1, id);
			statement.execute();
		}	
	}
	
	public Cliente buscaClientePorId(int id) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setInt(1, id);
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				if(resultSet.next()){
					String nome = resultSet.getString("nome");
					String endereco = resultSet.getString("endereco");
					String cidade = resultSet.getString("cidade");
					String uf = resultSet.getString("uf");
					String senha = resultSet.getString("senha");
					Cliente cli = new Cliente(nome, endereco,cidade,uf,senha);
					cli.setId(id);
					return cli;
				}
			}
		}
		return null;
	}
	
	public List<Cliente> buscaClientePorNome(String nome) throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente WHERE nome=?";
		try(PreparedStatement statement = c.prepareStatement(sql)){
			statement.setString(1, nome);
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String endereco = resultSet.getString("endereco");
					String cidade = resultSet.getString("cidade");
					String uf = resultSet.getString("uf");
					String senha = resultSet.getString("senha");
					Cliente cli = new Cliente(nome, endereco,cidade,uf,senha);
					cli.setId(id);
					clientes.add(cli);
				}
			}
		}		
		return clientes;
	}
	
	
}
