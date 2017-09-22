package br.edu.ifpi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.bin.Horario;

public class HorarioDAO {
	private Connection c;
	
	public HorarioDAO(Connection connection) {
		c = connection;
	}
	
	public void salvar(Horario h) throws SQLException {
		String sql = "INSERT INTO horario(hora_inicio,hora_fim,cliente_id) values(?,?,?)";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, h.getHora_inicio());
			statement.setString(2, h.getHora_fim());
			statement.setInt(3, h.getCliente_id());
			statement.execute();
			try(ResultSet resultSet = statement.getGeneratedKeys()){
				if(resultSet.next()){
					int id = resultSet.getInt("id");
					h.setId(id);
				}
			}
		}	
	}
	
	public List<Horario> listar() throws SQLException {
		List<Horario> horarios = new ArrayList<>();
		String sql = "SELECT * FROM horario";
		try(PreparedStatement statement = c.prepareStatement(sql)){
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					int cliente_id = resultSet.getInt("cliente_id");
					String hora_inicio = resultSet.getString("hora_inicio");
					String hora_fim = resultSet.getString("hora_fim");
					Horario h = new Horario(hora_inicio,hora_fim);
					h.setId(id);
					h.setCliente_id(cliente_id);
					horarios.add(h);
				}
			}
		}		
		return horarios;
	}
	
	public void atualizar(Horario h) throws SQLException {
		String sql = "UPDATE horario SET hora_inicio=?, hora_fim=?, cliente_id=? WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, h.getHora_inicio());
			statement.setString(2, h.getHora_fim());
			statement.setInt(3, h.getCliente_id());
			statement.execute();
		}	
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM horario WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setInt(1, id);
			statement.execute();
		}	
	}
	
	public Horario buscaHorarioPorId(int id) throws SQLException {
		String sql = "SELECT * FROM horario WHERE id=?";
		try(PreparedStatement statement = c.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)){
			statement.setInt(1, id);
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				String hora_inicio = resultSet.getString("hora_inicio");
				String hora_fim = resultSet.getString("hora_fim");
				int cliente_id = resultSet.getInt("cliente_id");
				Horario h = new Horario(hora_inicio,hora_fim);
				h.setCliente_id(cliente_id);
				h.setId(id);
				return h;
			}
		}
	}
	
	public List<Horario> buscaHorarioPorDataHora(String hora_inicio) throws SQLException {
		List<Horario> horarios = new ArrayList<>();
		String sql = "SELECT * FROM horario WHERE hora_inicio=?";
		try(PreparedStatement statement = c.prepareStatement(sql)){
			statement.setString(1, hora_inicio);
			statement.execute();
			try(ResultSet resultSet = statement.getResultSet()){
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String hora_fim = resultSet.getString("hora_fim");
					int cliente_id = resultSet.getInt("cliente_id");
					Horario h = new Horario(hora_inicio,hora_fim);
					h.setId(id);
					h.setCliente_id(cliente_id);
					horarios.add(h);
				}
			}
		}		
		return horarios;
	}
	
	
}

