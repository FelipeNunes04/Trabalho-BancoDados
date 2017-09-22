package br.edu.ifpi.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.bin.Horario;
import br.edu.ifpi.dao.HorarioDAO;
import br.ifpi.edu.utils.Banco;

public class TesteInsercaoHorario {
	public static void main(String[] args) throws SQLException {
		Horario h1 = new Horario("2017-09-22 18:00:00","2017-09-22 20:00:00");
		Horario h2 = new Horario("2017-09-23 18:00:00","2017-09-23 20:00:00");
		Horario h3 = new Horario("2017-09-20 12:00:00","2017-09-20 14:00:00");
		Horario h4 = new Horario("2017-09-21 18:00:00","2017-09-21 20:00:00");
		Horario h5 = new Horario("2017-09-25 14:00:00","2017-09-25 18:00:00");
		Horario h6 = new Horario("2017-09-22 10:00:00","2017-09-22 12:00:00");
		Horario h7 = new Horario("2017-09-22 08:00:00","2017-09-22 12:00:00");
		Horario h8 = new Horario("2017-09-28 15:00:00","2017-09-22 17:00:00");
		Horario h9 = new Horario("2017-09-26 18:00:00","2017-09-26 20:00:00");
		Horario h10 = new Horario("2017-09-29 10:00:00","2017-09-29 12:00:00");
		Banco banco = new Banco();
		try(Connection c = banco.getConection()){
			HorarioDAO horarioDAO = new HorarioDAO(c);
			horarioDAO.salvar(h1);
			horarioDAO.salvar(h2);
			horarioDAO.salvar(h3);
			horarioDAO.salvar(h4);
			horarioDAO.salvar(h5);
			horarioDAO.salvar(h6);
			horarioDAO.salvar(h7);
			horarioDAO.salvar(h8);
			horarioDAO.salvar(h9);
			horarioDAO.salvar(h10);
		}
		System.out.println("Horarios inseridos com sucesso");
	}
}
