package Repositorios;

import java.util.List;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IRepositorioCarrinhos {

	public List<Carrinho> listarCarrinhos();
	public void adicionarCarrinho(Carrinho car);
		
}
