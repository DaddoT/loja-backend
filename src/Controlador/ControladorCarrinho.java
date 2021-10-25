
package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Modelo.ItensCarrinho;
import Modelo.Produto;
import Repositorios.Carrinho;
import Repositorios.ICarrinho;
import Repositorios.IRepositorioCliente;
import Repositorios.IRepositorioProduto;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioProduto;

public class ControladorCarrinho implements IControladorCarrinho {
	private ICarrinho carrinho = Carrinho.getInstancia();
	private IRepositorioProduto repositorioProduto = RepositorioProduto.getInstancia();
	private static ControladorCarrinho instancia;
	
	public static ControladorCarrinho getInstancia() {
		if (instancia == null) {
			instancia = new ControladorCarrinho();
		}
		return instancia;
	}
	
	@Override
	public void inserirItem(ItensCarrinho i , int codigo , int quantidadeSubtraida) throws InserirItemCarrinhoException, CadastroException {
		for (Produto p : RepositorioProduto.getInstancia().getListaP()) {
		if (p != null && p.getCodigo() == codigo &&  p.getQuantidade() < quantidadeSubtraida) {
			throw new InserirItemCarrinhoException("Quantidade inválida");
		}
		else if (p.getCodigo() == codigo){
			i.setCodigo(carrinho.listarItens().size() + 1);
			i.setQuantidadeProdutos(quantidadeSubtraida);
			i.setProduto(p);
			
			carrinho.InserirItem(i);
			repositorioProduto.removerDoEstoque(codigo, quantidadeSubtraida);				
		}
	}
}	
	
	@Override
	public void devolverAoEstoque(int codigo , int quantidadeAdicionada) throws InserirItemCarrinhoException, CadastroException {
		for (ItensCarrinho i : Carrinho.getInstancia().getListaItens()) {
		if(i.getProduto().getCodigo() == codigo && i.getQuantidadeProdutos() < quantidadeAdicionada) {
			throw new InserirItemCarrinhoException("Quantidade inválida");
		} else if (!Carrinho.getInstancia().existeItem(codigo)) {
			throw new CadastroException("Item não cadastrado");
		}
		else {
			repositorioProduto.devolverAoEstoque(codigo, quantidadeAdicionada);
				i.setQuantidadeProdutos(i.getQuantidadeProdutos() - quantidadeAdicionada);
		}
	}
}

	@Override
	public List<ItensCarrinho> listarItens() throws CadastroException {
		if(carrinho.listarItens() == null) {
			throw new CadastroException("O carrinho está vazio");
		} else {
			return carrinho.listarItens();
		}
	}

	

}
