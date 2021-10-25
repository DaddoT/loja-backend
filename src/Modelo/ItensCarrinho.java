package Modelo;
 /* */
import Repositorios.Carrinho;
import Repositorios.RepositorioProduto;

public class ItensCarrinho {
	private int codigo;
	private int quantidadeProdutos;
	private Produto produto;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	public void setQuantidadeProdutos(int quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public String toString() {
		
	
			return codigo + " - " + produto  + " - " + "Quantidade no carrinho: " + quantidadeProdutos + "\n";
		
		
	}
}
