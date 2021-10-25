package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Produto;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IControladorProduto {
	
	void CadastrarProduto(Produto p) throws CadastroException;
	boolean RemoverProduto(int codigo) throws CadastroException;
	public Produto ConsultaProduto (String nome) throws CadastroException;
	public List<Produto> listarProduto() throws CadastroException;
}
