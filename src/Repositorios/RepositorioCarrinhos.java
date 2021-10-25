package Repositorios;

import java.util.ArrayList;
import java.util.List;
 /* */
public class RepositorioCarrinhos implements IRepositorioCarrinhos{
	

		private List<Carrinho> listaCarrinho;
		private static RepositorioCarrinhos instancia;
		
		public static RepositorioCarrinhos getInstancia() {
			if(instancia == null) {
				instancia = new RepositorioCarrinhos();
			}
			return instancia;
		}
		
		private RepositorioCarrinhos() {
			listaCarrinho = new ArrayList<>();
		}
		
		
		@Override
		public List<Carrinho> listarCarrinhos() {
			return listaCarrinho;
		}
		
		@Override
		public void adicionarCarrinho(Carrinho carrinho) {
			listaCarrinho.add(carrinho);
		}
		

	}

