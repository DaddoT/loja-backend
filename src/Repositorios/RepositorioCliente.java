package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Cliente;
 /* */
public class RepositorioCliente implements IRepositorioCliente {
	
	private static RepositorioCliente instancia;
	private static  List<Cliente> listaC;
	
	 public static RepositorioCliente getInstancia() {
	        if(instancia == null) {
	            instancia = new RepositorioCliente();
	        }
	        return instancia;
	    }
	    RepositorioCliente() {
	    	listaC = new ArrayList<Cliente>();
	    }	
	    
	    @Override
	    public void CadastrarCliente(Cliente c) throws CadastroException { // UICliente
	    		listaC.add(c);			    	
		}	    
	    @Override
	    public boolean RemoverCliente(String cpf) throws CadastroException{ // UIAdmin
	    	for(Cliente c : listaC) {
	    		if ((c.getCpf().equals(cpf))) {
	    			listaC.remove(c);
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    @Override
	    public Cliente ConsultaCliente(String cpf) throws CadastroException { // UIAdmin
	    	for (Cliente c : listaC) {
	    		if(c != null && c.getCpf().equals(cpf)) {
	    			return c;
	    		}
	    	}
	    	return null;
	    }
	    
	    @Override
	    public boolean existeCliente(String cpf) {
	    	if (listaC == null || listaC.size() == 0) {
	    		return false;
	    	} 	
	    	for(Cliente c : listaC) {
	    		if (c != null && c.getCpf().equals(cpf)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
		@Override
		public List<Cliente> listarCliente() { //UIAdmin 
			return listaC;
		}
		@Override
		public Cliente loginCliente(String login, String senha) {
			for(Cliente c : listaC) {
				if (c.getNomeUsuario().equals(login) && c.getSenha().equals(senha)) {
					return c;
				}
			}
			return null;
		}
}
