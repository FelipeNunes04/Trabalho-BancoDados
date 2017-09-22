package br.edu.ifpi.bin;

public class Cliente {
	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private String uf;
	private String senha;
	
	public Cliente(String nome,String endereco,String cidade,String uf,String senha) {
		setNome(nome);
		setEndereco(endereco);
		setCidade(cidade);
		setUf(uf);
		setSenha(senha);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
