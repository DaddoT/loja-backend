package Repositorios;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.LoginException;
import Modelo.Cliente;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public interface IRepositorioCliente {
	public void CadastrarCliente(Cliente c) throws CadastroException;
	 public boolean RemoverCliente(String cpf)throws CadastroException;
	public boolean existeCliente(String cpf);
	public Cliente ConsultaCliente (String cpf) throws CadastroException;
	public List<Cliente> listarCliente() throws CadastroException;
	public Cliente loginCliente(String login , String senha) throws LoginException , CadastroException;
}
