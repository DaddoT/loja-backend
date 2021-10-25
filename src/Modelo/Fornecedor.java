package Modelo;

import java.util.Date;
 /* */
public class Fornecedor {
	
	private int codigo;
	private String cnpj;
	private String nome;
	private String nomeFantasia;
	private String endereco;
	private String telefone;
	private Date DataAbertura;
	
	
	@Override
	public String toString() {
		return "Nome do fornecedor: " + nome + "\n CNPJ: " + cnpj + "";
	}
	public Fornecedor(int codigo, String cnpj, String nome, String nomeFantasia, String endereco, String telefone,
			Date dataAbertura) {
		this.codigo = codigo;
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.telefone = telefone;
		DataAbertura = dataAbertura;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
	public Date getDataAbertura() {
		return DataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		DataAbertura = dataAbertura;
	}
	
	
	
}
