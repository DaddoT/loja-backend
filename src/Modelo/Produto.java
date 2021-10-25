package Modelo;

import Repositorios.RepositorioProduto;
 /* */
public class Produto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private String categoria;
	private Fornecedor fornecedor;
	private int quantidade;
			
	
	
	public Produto(int codigo, String nome, String descricao, String categoria, Fornecedor fornecedor, int quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.quantidade = quantidade;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		
		
		return	("Produto: " + codigo + " - " + nome + " - Quantidade em estoque: " + quantidade + "\n"
					+ "		-Descrição: " + descricao + "\n" );
		
		
	}	
}
