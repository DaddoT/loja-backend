package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Modelo.ItensCarrinho;
import Modelo.Produto;
 /* */
public interface IControladorCarrinho {
	public void inserirItem(ItensCarrinho i, int codigo , int quantidadeSubtraida) throws InserirItemCarrinhoException, CadastroException;
	public List<ItensCarrinho> listarItens() throws CadastroException;
	void devolverAoEstoque(int codigo, int quantidadeAdicionada)
			throws InserirItemCarrinhoException, CadastroException;
}
