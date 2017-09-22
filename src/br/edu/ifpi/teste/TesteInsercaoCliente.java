package br.edu.ifpi.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.bin.Cliente;
import br.edu.ifpi.dao.ClienteDAO;
import br.ifpi.edu.utils.Banco;


public class TesteInsercaoCliente {
	public static void main(String[] args) throws SQLException {
		Cliente cli1 = new Cliente("Felipe","Rua Mariano Costa, 7459", "Picos", "PI","123");
		Cliente cli2 = new Cliente("Maria Allyne","Rua Costa e Silva, 0001", "Alegrete", "PI","321");
		Cliente cli3 = new Cliente("Regilene","Rua da Silva, 2020", "Belém do Piauí", "PI","432");
		Cliente cli4 = new Cliente("José","Avenida XXX, 6969", "Vila Nova", "PI","2333");
		Cliente cli5 = new Cliente("Mayra","Rua da Gordura, 8888", "Vila Nova", "PI","2222");
		Cliente cli6 = new Cliente("Soraya","Rua Sei Lá, 0123", "Vila Nova", "PI","abc123");
		Cliente cli7 = new Cliente("Amanda","Avenida ABC, 9877", "Picos", "PI","xx22");
		Cliente cli8 = new Cliente("Laura","Avenida São José, 7459", "Alegrete", "PI","jj27");
		Cliente cli9 = new Cliente("Eduardo","Rua Mariano Costa, 7459", "Picos", "PI","qz23");
		Cliente cli10 = new Cliente("Jarmes","Rua Mariano Costa, 7459", "Marcolandia", "PI","12345678");
		Banco banco = new Banco();
		try(Connection c = banco.getConection()){
			ClienteDAO clienteDAO = new ClienteDAO(c);
			clienteDAO.salvar(cli1);
			clienteDAO.salvar(cli2);
			clienteDAO.salvar(cli3);
			clienteDAO.salvar(cli4);
			clienteDAO.salvar(cli5);
			clienteDAO.salvar(cli6);
			clienteDAO.salvar(cli7);
			clienteDAO.salvar(cli8);
			clienteDAO.salvar(cli9);
			clienteDAO.salvar(cli10);
		}
		System.out.println("Clientes inseridos com sucesso");
	}
}
