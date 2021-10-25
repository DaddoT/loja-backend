package Repositorios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Cliente;
import Modelo.ItensCarrinho;
import Modelo.Produto;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
public class Carrinho implements ICarrinho{
	
	private Cliente cliente;
	private Date dataFechamento;
	private static List<ItensCarrinho> listaItens;
	
	
	private static Carrinho instancia;
	public static Carrinho getInstancia() {
		if(instancia == null) {
            instancia = new Carrinho();
        }
        return instancia;		
	}
	
	
	public Carrinho() {
		listaItens = new ArrayList<ItensCarrinho>();
		
	}
	public Carrinho(Cliente cliente , Date dataFechamento) {
		this.cliente = cliente;
		this.dataFechamento = dataFechamento;
	}
	
	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public List<ItensCarrinho> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItensCarrinho> listaCarrinho) {
		this.listaItens = listaItens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
	StringBuilder s = new StringBuilder();
		s.append("Cliente: " + cliente.getNome() + "\n");
		for(ItensCarrinho i : listaItens) {
			s.append(i + "\n");
		}
		return s.toString();
	}

	@Override
	public void InserirItem(ItensCarrinho i) {
		listaItens.add(i);
	}
	
	@Override
	public List<ItensCarrinho> listarItens() {
		return listaItens;
	}
	@Override
	public void esvaziarCarrinho() {
		instancia = new Carrinho();
	}
	@Override
    public boolean existeProduto(int codigo) {
    	if (RepositorioProduto.getListaP() == null || RepositorioProduto.getListaP().size() == 0) {
    		return false;
    	} 	
    	for(Produto p : RepositorioProduto.getListaP()) {
    		if (p != null && p.getCodigo() == codigo ) {
    			return true;
    		}
    	}
    	return false;
    }
	

	
	
	public boolean existeItem(int codigo) {
		if(listaItens == null || listaItens.isEmpty()) {
			return false;
		}
		for(ItensCarrinho i : listaItens) {
			if(i != null && i.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}
}
