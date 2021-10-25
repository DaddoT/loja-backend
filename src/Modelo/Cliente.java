package Modelo;

import java.util.Date;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public class Cliente {
	
	private int codigo;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefone;
	private Date nascimento;
	private String nomeUsuario;
	private String senha;
	
	public Cliente(int codigo, String nome, String cpf, String endereco, String telefone, Date nascimento,
			String nomeUsuario, String senha) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Nome do cliente: " + nome + "\n Código do cliente: " + codigo + "\n" ;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
