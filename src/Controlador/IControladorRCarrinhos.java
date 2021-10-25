package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Repositorios.Carrinho;
 /* */
public interface IControladorRCarrinhos {
	public List<Carrinho> listarCarrinhos() throws CadastroException;
	public void adicionarCarrinho(Carrinho carrinho);
}
