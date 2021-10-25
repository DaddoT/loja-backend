
package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.LoginException;
import Modelo.Cliente;
import Repositorios.IRepositorioCliente;
import Repositorios.RepositorioCliente;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public class ControladorCliente implements IControladorCliente {
	
	private IRepositorioCliente repositorioCliente = RepositorioCliente.getInstancia();
	private static ControladorCliente instancia;
	
	public static ControladorCliente getInstancia() {
		if (instancia == null) {
			instancia = new ControladorCliente();
		}
		return instancia;
	}
	private ControladorCliente() {
		repositorioCliente = RepositorioCliente.getInstancia();
	}	
	@Override
	public void CadastrarCliente(Cliente c) throws CadastroException {
		if(repositorioCliente.existeCliente(c.getCpf())) {
			throw new CadastroException("Cliente já cadastrado");
		} else {
		repositorioCliente.CadastrarCliente(c);
		}
	}

	@Override
	public boolean RemoverCliente(String cpf) throws CadastroException {	
		if(!repositorioCliente.existeCliente(cpf)) {
			throw new CadastroException("Este cliente não existe");
		} else {
			repositorioCliente.RemoverCliente(cpf);
		}
		return false;
	}
	@Override
	public Cliente ConsultaCliente(String cpf) throws CadastroException { //UIAdmin
		if(!repositorioCliente.existeCliente(cpf)) {
			throw new CadastroException("Este cliente não existe");
		} else {
			repositorioCliente.ConsultaCliente(cpf);
		}
		return null;
	}
	@Override
	public List<Cliente> listarCliente() throws CadastroException {  //UIAdmin
		if(repositorioCliente.listarCliente() == null) {
			throw new CadastroException("Não há clientes cadastrados");
		} else {
			return repositorioCliente.listarCliente();
		}
	}
	@Override
	public Cliente loginCliente(String login, String senha) throws CadastroException, LoginException { //UICliente
		if(repositorioCliente.loginCliente(login, senha) != null) {
			return repositorioCliente.loginCliente(login, senha);
		} else {
			throw new LoginException("Login e/ou senha inválidos");
		}
	}
}
