package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Produto;
import Repositorios.IRepositorioCliente;
import Repositorios.IRepositorioProduto;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioProduto;

public class ControladorProduto implements IControladorProduto {
	
	private IRepositorioProduto repositorioProduto;
	private static ControladorProduto instancia;
	
	public static ControladorProduto getInstancia() {
		if (instancia == null) {
			instancia = new ControladorProduto();
		}
		return instancia;
	}
	private ControladorProduto() {
		repositorioProduto = RepositorioProduto.getInstancia();
	}	
	@Override
	public void CadastrarProduto(Produto p) throws CadastroException {
		if(repositorioProduto.existeProdutoCodigo(p.getCodigo())) {
			throw new CadastroException("Produto já cadastrado");
		} else {
		repositorioProduto.CadastrarProduto(p);
		}
	}

	@Override
	public boolean RemoverProduto(int codigo) throws CadastroException {
		if(!repositorioProduto.existeProdutoCodigo(codigo)) {
			throw new CadastroException("Este produto não existe");
		} else {
			repositorioProduto.RemoverProduto(codigo);
		}
		return false;
	}
		
	@Override
	public Produto ConsultaProduto(String nome) throws CadastroException {
		if(!repositorioProduto.existeProdutoNome(nome)) {
			throw new CadastroException("Este produto não existe");
		} else {
			return repositorioProduto.ConsultaProduto(nome);
		}
	}
	@Override
	public List<Produto> listarProduto() throws CadastroException {
		if(repositorioProduto.listarProduto() == null) {
			throw new CadastroException("Não há produtos cadastrados");
		} else {
			return repositorioProduto.listarProduto();
		}
	}
	
	
}
