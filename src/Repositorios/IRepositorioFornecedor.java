package Repositorios;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Fornecedor;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IRepositorioFornecedor {
	
	public void CadastrarFornecedor(Fornecedor f) throws CadastroException;
	 public boolean RemoverFornecedor(String cnpj)throws CadastroException;
	public boolean existeFornecedor(String cnpj);
	public Fornecedor ConsultaFornecedor (String cnpj) throws CadastroException;
	public List<Fornecedor> listarFornecedor();
	
}
