package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Modelo.ItensCarrinho;
import Modelo.Produto;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IControladorCarrinho {
	public void inserirItem(ItensCarrinho i, int codigo , int quantidadeSubtraida) throws InserirItemCarrinhoException, CadastroException;
	public List<ItensCarrinho> listarItens() throws CadastroException;
	void devolverAoEstoque(int codigo, int quantidadeAdicionada)
			throws InserirItemCarrinhoException, CadastroException;
}
