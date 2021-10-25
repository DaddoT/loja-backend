package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Fornecedor;
 /* */
public interface IControladorFornecedor {
	
	void CadastrarFornecedor(Fornecedor f) throws CadastroException;
	boolean RemoverFornecedor(String cnpj) throws CadastroException;
	public Fornecedor ConsultaFornecedor(String cnpj) throws CadastroException;
	public List<Fornecedor> listarFornecedor() throws CadastroException;
}
