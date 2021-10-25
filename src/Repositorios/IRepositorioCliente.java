package Repositorios;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.LoginException;
import Modelo.Cliente;
 /* */
public interface IRepositorioCliente {
	public void CadastrarCliente(Cliente c) throws CadastroException;
	 public boolean RemoverCliente(String cpf)throws CadastroException;
	public boolean existeCliente(String cpf);
	public Cliente ConsultaCliente (String cpf) throws CadastroException;
	public List<Cliente> listarCliente() throws CadastroException;
	public Cliente loginCliente(String login , String senha) throws LoginException , CadastroException;
}
