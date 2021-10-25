package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Cliente;
import Modelo.Produto;
 /* */
public class RepositorioProduto implements IRepositorioProduto {
	
	private static RepositorioProduto instancia;
	private static  List<Produto> listaP;
	
	 public static List<Produto> getListaP() {
		return listaP;
	}
	public static void setListaP(List<Produto> listaP) {
		RepositorioProduto.listaP = listaP;
	}
	
	
	public static RepositorioProduto getInstancia() {
	        if(instancia == null) {
	            instancia = new RepositorioProduto();
	        }
	        return instancia;
	    }
	    RepositorioProduto() {
	    	listaP = new ArrayList<Produto>();
	    }	
	    
	@Override
	public void CadastrarProduto(Produto p) throws CadastroException {
			listaP.add(p);
	}

	@Override
	public boolean RemoverProduto(int codigo) throws CadastroException {
		for(Produto p : listaP) {
    		if (p.getCodigo() == codigo) {
    			listaP.remove(p);
    			return true;
    		}
    	}
		return false;
	}

	@Override
	public boolean existeProdutoCodigo(int codigo) {
		if (listaP == null || listaP.size() == 0) {
    		return false;
    	} 	
		for(Produto p : listaP) {
			if (p != null && p.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Produto ConsultaProduto(String nome) throws CadastroException {
		for (Produto p : listaP) {
    		if(p != null && p.getNome().equals(nome)) {
    			return p;
    		}
    	}
		return null;
	}
	
	@Override
	public List<Produto> listarProduto() { 
		return listaP;
	}
	
	@Override
	public boolean existeProdutoNome(String nome) {
		if (listaP == null || listaP.size() == 0) {
    		return false;
    	} 	
		for(Produto p : listaP) {
			if (p != null && p.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean removerDoEstoque(int codigo , int quantidadeSubtraida) {
		for(Produto p : listaP) {
			if(p != null && p.getCodigo() == (codigo)) {
				p.setQuantidade(p.getQuantidade() - quantidadeSubtraida);
				return true;
			}
		}
		return false;		
	}
	
	@Override
	public boolean devolverAoEstoque(int codigo , int quantidadeAdicionada)	{
		for(Produto p : listaP) {
			if(p != null && p.getCodigo() == (codigo)) {
				p.setQuantidade(p.getQuantidade() + quantidadeAdicionada);
			}
		}
		return false;
	}
}	