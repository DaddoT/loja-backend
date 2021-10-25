package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Cliente;
import Modelo.Fornecedor;
 /* */
public class RepositorioFornecedor implements IRepositorioFornecedor{
	
	private static RepositorioFornecedor instancia;
	private static  List<Fornecedor> listaF;
	
	 public static RepositorioFornecedor getInstancia() {
	        if(instancia == null) {
	            instancia = new RepositorioFornecedor();
	        }
	        return instancia;
	    }
	    RepositorioFornecedor() {
	    	listaF = new ArrayList<Fornecedor>();
	    }
		@Override
		public void CadastrarFornecedor(Fornecedor f) throws CadastroException {
			listaF.add(f);
		}
		@Override
		public boolean RemoverFornecedor(String cnpj) throws CadastroException {
			for(Fornecedor f : listaF) {
	    		if (((Fornecedor) listaF).getCnpj().equals(cnpj)) {
	    			listaF.remove(f);
	    			return true;
	    		}
	    	}
			return false;
		}
		@Override
		public boolean existeFornecedor(String cnpj) {
			if (listaF == null || listaF.size() == 0) {
	    		return false;
	    	} 	
	    	for(Fornecedor f : listaF) {
	    		if (f != null && f.getCnpj().equals(cnpj)) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
		@Override
		public Fornecedor ConsultaFornecedor(String cnpj) throws CadastroException {
			for (Fornecedor f : listaF) {
	    		if(f != null && f.getCnpj().equals(cnpj)) {
	    			return f;
	    		}
	    	}
	    	return null;
		}
		@Override
		public List<Fornecedor> listarFornecedor() { //UIAdmin 
			return listaF;
		}
	    
	    
}
