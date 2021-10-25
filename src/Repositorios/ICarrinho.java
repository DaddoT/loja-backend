package Repositorios;
import java.util.List;

import Modelo.ItensCarrinho;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface ICarrinho {
	public void InserirItem(ItensCarrinho i);
	public List<ItensCarrinho> listarItens();
	boolean existeProduto(int codigo);
	void esvaziarCarrinho();

}
