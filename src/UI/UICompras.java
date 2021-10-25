package UI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Exceçoes.LoginException;
import Fachada.Fachada;
import Modelo.Cliente;
import Modelo.ItensCarrinho;
import Modelo.Produto;
import Repositorios.Carrinho;
import Repositorios.ICarrinho;
import Repositorios.RepositorioProduto;
 /* */
public class UICompras {
	private static Fachada fachada = Fachada.getInstancia();
	static Scanner s = new Scanner(System.in);
	private static Carrinho carrinho = Carrinho.getInstancia();
	private static RepositorioProduto repositorioProduto = RepositorioProduto.getInstancia();
	
	public static void atribuirClienteACompra(Cliente c) {
		carrinho.setCliente(c);
	}

	public static void menuCompras() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		
		System.out.println("Insira uma opção: \n 1: Comprar produtos \n 2: Pesquisar produtos \n 3: Exibir carrinho \n 4: Exibir produtos em destaque \n 5: Voltar ao menu do cliente ");
		int op = s.nextInt();
		
		switch(op) {
		case 1:
			comprarProdutos();
				break;
		case 2:
			pesquisarProdutos();
				break;
		case 3:
			exibirCarrinho();
				break;
		case 4:
			exibirDestaque();
				break;
		case 5:
			UICliente.showMenuCliente();
				break;
		default:
			return;
		}
	}
	static void exibirDestaque() throws CadastroException, ParseException, LoginException, InserirItemCarrinhoException {
		List<Produto> random1 = new ArrayList<Produto>();
		
		Random indice = new Random();
		
		for (Produto p : fachada.listarProduto()) {
			random1.add(p);
		}
		
		
		List<Produto> aleatorio = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
		
			int random = indice.nextInt(random1.size());
			aleatorio.add(random1.get(random));
			random1.remove(random);
		}
		for (int i = 0; i < 4; i++) {
		
			System.out.println("-" + (i+1) + " " + aleatorio.get(i).getNome());
		}
			menuCompras();
	}
	static void comprarProdutos() throws InserirItemCarrinhoException, CadastroException, ParseException, LoginException {
		
		for(Produto p : fachada.listarProduto()) {
			System.out.println(p);
		}
		
		System.out.println("Insira o codigo do produto para adicioná-lo ao carrinho");
		int codigo = s.nextInt();
		System.out.println("Insira a quantidade do produto selecionado que deseja comprar");
		int quantidadeSubtraida = s.nextInt();
		
		try {
			ItensCarrinho i = new ItensCarrinho();
			Fachada.getInstancia().inserirItem(i, codigo, quantidadeSubtraida);	
			System.out.println("Item(ns) adicionados com sucesso!");
			exibirCarrinho();
		} catch (InserirItemCarrinhoException e) {
			System.out.println(e.getMessage());
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}		
	}
	static void devolverProdutos() throws InserirItemCarrinhoException , CadastroException, ParseException, LoginException {
		if(Carrinho.getInstancia().getListaItens().size() > 0) {
		System.out.println(carrinho);
		System.out.println("Insira o código do produto a ser devolvido");
		int codigo = s.nextInt();
		System.out.println("Insira a quantidade de itens deste produto a ser devolvido");
		int quantidadeAdicionada = s.nextInt();
		
		try {
			Fachada.getInstancia().devolverAoEstoque(codigo, quantidadeAdicionada);
			System.out.println("Itens retirados do carrinho");
			menuCompras();
		} catch(InserirItemCarrinhoException e) {
			System.out.println(e.getMessage());
			menuCompras();
		} catch(CadastroException e) {
			System.out.println(e.getMessage());
			menuCompras();
		}
	}
}
	static void pesquisarProdutos() {
		System.out.println("Insira o nome do produto para pesquisar");
		s.nextLine();
		String nome = s.nextLine();
		
		try {
			System.out.println(Fachada.getInstancia().ConsultaProduto(nome));
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void exibirCarrinho() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
	if(carrinho.getInstancia().getListaItens().size() > 0) {	
			System.out.println(carrinho);
		System.out.println("Insira: \n 1: Continuar compra \n 2: Finalizar compra \n 3: Devolver item ");
		int op = s.nextInt();
		
		switch (op) {
			case 1:
				menuCompras();
					break;
			case 2:
				finalizarCompra();
					break;	
			case 3:
				devolverProdutos();
					break;
			default:
				return;
		}
	}	else {
		System.out.println("Carrinho vazio \n \n");
			menuCompras();
	}
}
	static void finalizarCompra() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Digite a sua senha para finalizar a compra");
		String senha = s.next();
		
		if(carrinho.getInstancia().getCliente().getSenha().equals(senha)) {
			
			carrinho.getInstancia().setDataFechamento(new Date());
			fachada.getInstancia().adicionarCarrinho(carrinho);
			carrinho.getInstancia().getListaItens().clear();
			System.out.println("Compra realizada com sucesso \n 	Será entregue em: " + carrinho.getCliente().getEndereco());
			
		}else {
			System.out.println("Senha inválida");
			exibirCarrinho();
		}
	}
}
