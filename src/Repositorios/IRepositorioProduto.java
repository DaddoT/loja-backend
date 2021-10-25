package Repositorios;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Produto;
 /* */
public interface IRepositorioProduto {
	
	public void CadastrarProduto(Produto p) throws CadastroException;
	 public boolean RemoverProduto(int codigo)throws CadastroException;
	public boolean existeProdutoNome(String nome);
	public Produto ConsultaProduto(String nome) throws CadastroException;
	public List<Produto> listarProduto();
	boolean existeProdutoCodigo(int codigo);
	boolean removerDoEstoque(int codigo, int quantidadeSubtraida);
	boolean devolverAoEstoque(int codigo, int quantidadeAdicionada);
	
}
