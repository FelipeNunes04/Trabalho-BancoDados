package br.edu.ifpi.bin;

public class Horario {
	private int id;
	private String hora_inicio;
	private String hora_fim;
	private int cliente_id;
	
	public Horario(String hora_inicio, String hora_fim) {
		setHora_inicio(hora_inicio);
		setHora_fim(hora_fim);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
}
