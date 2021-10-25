package Repositorios;
import java.util.List;

import Modelo.ItensCarrinho;
 /* */
public interface ICarrinho {
	public void InserirItem(ItensCarrinho i);
	public List<ItensCarrinho> listarItens();
	boolean existeProduto(int codigo);
	void esvaziarCarrinho();

}
