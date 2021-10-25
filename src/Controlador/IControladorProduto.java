package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Produto;

public interface IControladorProduto {
	
	void CadastrarProduto(Produto p) throws CadastroException;
	boolean RemoverProduto(int codigo) throws CadastroException;
	public Produto ConsultaProduto (String nome) throws CadastroException;
	public List<Produto> listarProduto() throws CadastroException;
}
