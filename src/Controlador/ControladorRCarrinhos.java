package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Repositorios.Carrinho;
import Repositorios.ICarrinho;
import Repositorios.IRepositorioCarrinhos;
import Repositorios.RepositorioCarrinhos;

public class ControladorRCarrinhos implements IControladorRCarrinhos{
	private IRepositorioCarrinhos repositorioCarrinhos = RepositorioCarrinhos.getInstancia();
	private static ControladorRCarrinhos instancia;
	
	public static ControladorRCarrinhos getInstancia() {
		if (instancia == null) {
			instancia = new ControladorRCarrinhos();
		}
		return instancia;
	}

	@Override
	public List<Carrinho> listarCarrinhos() throws CadastroException {
		if(repositorioCarrinhos.listarCarrinhos().isEmpty()) {
			throw new CadastroException("Não há carrinhos cadastrados");
		} else {
			return repositorioCarrinhos.listarCarrinhos();
		}
		
	}

	@Override
	public void adicionarCarrinho(Carrinho carrinho) {
		repositorioCarrinhos.adicionarCarrinho(carrinho);
		
	}
	
	
}
