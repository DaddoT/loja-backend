package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.LoginException;
import Modelo.Cliente;

public interface IControladorCliente {

	void CadastrarCliente(Cliente c) throws CadastroException;
	boolean RemoverCliente(String cpf) throws CadastroException;
	public Cliente ConsultaCliente (String cpf) throws CadastroException;
	public List<Cliente> listarCliente() throws CadastroException;
	public Cliente loginCliente(String login , String senha) throws CadastroException, LoginException;
	
}
