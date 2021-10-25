package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Repositorios.Carrinho;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IControladorRCarrinhos {
	public List<Carrinho> listarCarrinhos() throws CadastroException;
	public void adicionarCarrinho(Carrinho carrinho);
}
