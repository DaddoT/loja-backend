package Repositorios;

import java.util.ArrayList;
import java.util.List;
/*
 * Sammy Gabriel - 181081928
 * Igor Lima - 181080186
 * Daddo Cavalcanti - 181080914
 * Sidney Feijo - 181081919
 */
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

