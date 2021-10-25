package Repositorios;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Fornecedor;
 /* */
public interface IRepositorioFornecedor {
	
	public void CadastrarFornecedor(Fornecedor f) throws CadastroException;
	 public boolean RemoverFornecedor(String cnpj)throws CadastroException;
	public boolean existeFornecedor(String cnpj);
	public Fornecedor ConsultaFornecedor (String cnpj) throws CadastroException;
	public List<Fornecedor> listarFornecedor();
	
}
