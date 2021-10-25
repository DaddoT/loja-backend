package Utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Fachada.Fachada;
import Modelo.Cliente;
import Modelo.Fornecedor;
import Modelo.ItensCarrinho;
import Modelo.Produto;
import Repositorios.Carrinho;
import Repositorios.RepositorioCliente;
 /* */
public class PreCadastro {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Fachada fachada = Fachada.getInstancia();
	
	public static void Inicializar() throws ParseException, CadastroException, InserirItemCarrinhoException {	
		inserirCadastros();	
	}
	
	static void inserirCadastros() throws ParseException, CadastroException, InserirItemCarrinhoException {
		// <clientes>
		int codigo1 = RepositorioCliente.getInstancia().listarCliente().size() + 1;
		String nome1 = "Kawhi Leonard";
		String cpf1 = "2019412";
		String endereco1 = "Toronto, Ontario, Candadá";
		String telefone1 = "26273";
		String nascimento11 = "29/06/1991";
		Date nascimento1 = sdf.parse(nascimento11);
		String nomeUsuario1 = "klaw";
		String senha1 = "123";
		
		Cliente c1 = new Cliente(codigo1, nome1, cpf1, endereco1, telefone1, nascimento1, nomeUsuario1, senha1);
		fachada.getInstancia().CadastrarCliente(c1);
		
		int codigo2 = RepositorioCliente.getInstancia().listarCliente().size() + 1;
		String nome2 = "Paul George";
		String cpf2 = "20193613";
		String endereco2 = "Oklahoma City , Oklahoma, EUA";
		String telefone2 = "2884";
		String nascimento22 = "02/05/1990";
		Date nascimento2 = sdf.parse(nascimento22);
		String nomeUsuario2 = "pg";
		String senha2 = "123";
		
		Cliente c2 = new Cliente(codigo2, nome2, cpf2, endereco2, telefone2, nascimento2, nomeUsuario2, senha2);
		fachada.getInstancia().CadastrarCliente(c2);
		
		int codigo3 = RepositorioCliente.getInstancia().listarCliente().size() + 1;
		String nome3 = "Giannis Antetokounmpo";
		String cpf3 = "271234";
		String endereco3 = "Milwaukee, Wisconsin, EUA";
		String telefone3 = "21252019";
		String nascimento33 = "06/12/1994";
		Date nascimento3 = sdf.parse(nascimento33);
		String nomeUsuario3 = "greekfreak";
		String senha3 = "123";
		
		Cliente c3 = new Cliente(codigo3, nome3, cpf3, endereco3, telefone3, nascimento3, nomeUsuario3, senha3);
		fachada.getInstancia().CadastrarCliente(c3);
		
		int codigo4 = RepositorioCliente.getInstancia().listarCliente().size() + 1;
		String nome4 = "Luka Doncic";
		String cpf4 = "2019921";
		String endereco4 = "Dallas, Texas, EUA";
		String telefone4 = "21762019";
		String nascimento44 = "28/02/1999";
		Date nascimento4 = sdf.parse(nascimento44);
		String nomeUsuario4 = "newdirk";
		String senha4 = "123";
		
		Cliente c4 = new Cliente(codigo4, nome4, cpf4, endereco4, telefone4, nascimento4, nomeUsuario4, senha4);
		fachada.getInstancia().CadastrarCliente(c4);
		
		int codigo5 = RepositorioCliente.getInstancia().listarCliente().size() + 1;
		String nome5 = "Devin Booker";
		String cpf5 = "20172470";
		String endereco5 = "Phoenix, Arizona, EUA";
		String telefone5 = "26461";
		String nascimento55 = "30/10/1996";
		Date nascimento5 = sdf.parse(nascimento55);
		String nomeUsuario5 = "dbook";
		String senha5 = "123";
		
		Cliente c5 = new Cliente(codigo5, nome5, cpf5, endereco5, telefone5, nascimento5, nomeUsuario5, senha5);
		fachada.getInstancia().CadastrarCliente(c5);
		
		// </clientes>
		
		// <fornecedor>
		int codigoF = 01;
		String cnpj = "001";
		String nomeF = "Nike Enterprise";
		String nomeFantasia = "Nike";
		String endereco = "New York City, New York, EUA";
		String telefone = "010203";
		String dataabertura = "25/01/1964";
		Date dataAbertura = sdf.parse(dataabertura);
		
		Fornecedor f = new Fornecedor(codigoF, cnpj, nomeF, nomeFantasia, endereco, telefone, dataAbertura);
		fachada.getInstancia().CadastrarFornecedor(f);
		
		// </fornecedor>
		
		//produtos
		
		int codigo01 = 01; 
		String nome01 = "PG25";
		String descricao1 = "Sapato Paul George 2.5";
		String categoria1 = "Sapatos";
		Fornecedor fornecedor1 = f;
		int quantidade1 = 50;
		
		Produto p = new Produto(codigo01, nome01, descricao1, categoria1, f, quantidade1);
		fachada.getInstancia().CadastrarProduto(p);
		
		int codigo02 = 02; 
		String nome02 = "Calça Taco";
		String descricao2 = "Calça da Taco 42";
		String categoria2 = "Roupa";
		Fornecedor fornecedor2 = f;
		int quantidade2 = 100;
		
		Produto a = new Produto(codigo02, nome02, descricao2, categoria2, f, quantidade2);
		fachada.getInstancia().CadastrarProduto(a);
		
		int codigo03 = 03; 
		String nome03 = "Nike";
		String descricao3 = "Tênis da Nike 42 ";
		String categoria3 = "Sapatos";
		Fornecedor fornecedor3 = f;
		int quantidade3 = 30;
		
		Produto b = new Produto(codigo03, nome03, descricao3, categoria3, f, quantidade3);
		fachada.getInstancia().CadastrarProduto(b);
		
		int codigo04 = 04; 
		String nome04 = "BLS";
		String descricao4 = "Blusa Calvin Klain";
		String categoria4 = "Roupa";
		Fornecedor fornecedor4 = f;
		int quantidade4 = 60;
		
		Produto c = new Produto(codigo04, nome04, descricao4, categoria4, f, quantidade4);
		fachada.getInstancia().CadastrarProduto(c);
		
		int codigo05 = 05; 
		String nome05 = "BluRers ";
		String descricao5 = "Blusa Reserva";
		String categoria5 = "Roupa";
		Fornecedor fornecedor5 = f;
		int quantidade5 = 20;
		
		Produto d = new Produto(codigo05, nome05, descricao5, categoria5, f, quantidade5);
		fachada.getInstancia().CadastrarProduto(d);
		
		int codigo6 = 06; 
		String nome6 = "Camisa SC S ";
		String descricao6 = "DudaLina";
		String categoria6 = "Roupa";
		Fornecedor fornecedor6 = f;
		int quantidade6 = 35;
		
		Produto e = new Produto(codigo6, nome6, descricao6, categoria6, f, quantidade6);
		fachada.getInstancia().CadastrarProduto(e);
	     
	     int codigo7 = 07; 
		String nome7 = "Sapato SC";
		String descricao7 = "Sapato Social Democrata";
		String categoria7 = "Sapato";
		Fornecedor fornecedor7 = f;
		int quantidade7 = 55;
		
		Produto g = new Produto(codigo7, nome7, descricao7, categoria7, f, quantidade7);
		fachada.getInstancia().CadastrarProduto(g);
 		
 		int codigo8 = 8; 
		String nome8 = "SP Tenis";
		String descricao8 = "Sapatenis Polo";
		String categoria8 = "Sapato";
		Fornecedor fornecedor8 = f;
		int quantidade8 = 68;
		
		Produto h = new Produto(codigo8, nome8, descricao8, categoria8, f, quantidade8);
		fachada.getInstancia().CadastrarProduto(h);

		int codigo9 = 9; 
		String nome9 = "M. Polo ";
		String descricao9 = "Meias Polo Cano Médio";
		String categoria9 = "Acessórios";
		Fornecedor fornecedor9 = f;
		int quantidade9 = 15;
		
		Produto i = new Produto(codigo9, nome9, descricao9, categoria9, f, quantidade9);
		fachada.getInstancia().CadastrarProduto(i);

		int codigo10 = 10; 
		String nome10 = "M. Luppo ";
		String descricao10 = "Meias Luppo Cano baixo";
		String categoria10 = "Acessórios";
		Fornecedor fornecedor10 = f;
		int quantidade10 = 15;
		
		Produto j = new Produto(codigo10, nome10, descricao10, categoria10, f, quantidade10);
		fachada.getInstancia().CadastrarProduto(j);	
		
		// </produtos>
		
		// <ItensCarrinho>
		
		ItensCarrinho i1 = new ItensCarrinho();
		i1.setCodigo(1);
		i1.setProduto(b);
		i1.setQuantidadeProdutos(4);
		
		ItensCarrinho i2 = new ItensCarrinho();
		i1.setCodigo(2);
		i1.setProduto(c);
		i1.setQuantidadeProdutos(4);
		
		ItensCarrinho i3 = new ItensCarrinho();
		i1.setCodigo(3);
		i1.setProduto(e);
		i1.setQuantidadeProdutos(4);
		
		ItensCarrinho i4 = new ItensCarrinho();
		i1.setCodigo(4);
		i1.setProduto(d);
		i1.setQuantidadeProdutos(4);
		
		ItensCarrinho i5 = new ItensCarrinho();
		i1.setCodigo(5);
		i1.setProduto(h);
		i1.setQuantidadeProdutos(4);
		
		ItensCarrinho i6 = new ItensCarrinho();
		i1.setCodigo(6);
		i1.setProduto(g);
		i1.setQuantidadeProdutos(4);
			
		// </ItensCarrinho>
		
		// <Carrinho>
	
		Carrinho car = new Carrinho();
		List<ItensCarrinho> listaItens = new ArrayList<ItensCarrinho>();
		listaItens.add(i1);
		listaItens.add(i3);
		listaItens.add(i5);
		listaItens.add(i2);
		car.setCliente(c1);
		String fechamento1 = "12/05/2019";
		car.setDataFechamento(sdf.parse(fechamento1));
		car.setListaItens(listaItens);
		
		fachada.adicionarCarrinho(car);
		
		Carrinho car2 = new Carrinho();
		List<ItensCarrinho> listaItens2 = new ArrayList<ItensCarrinho>();
		listaItens2.add(i2);
		listaItens2.add(i6);
		listaItens2.add(i4);
		listaItens2.add(i3);
		car2.setCliente(c3);
		String fechamento2 = "15/01/2019";
		car2.setDataFechamento(sdf.parse(fechamento2));
		car2.setListaItens(listaItens2);
		
		fachada.adicionarCarrinho(car2);
		
		Carrinho car3 = new Carrinho();
		List<ItensCarrinho> listaItens3 = new ArrayList<ItensCarrinho>();
		listaItens3.add(i2);
		listaItens3.add(i4);
		listaItens3.add(i5);
		listaItens3.add(i6);
		car3.setCliente(c5);
		String fechamento3 = "23/02/2018";
		car3.setDataFechamento(sdf.parse(fechamento3));
		car3.setListaItens(listaItens);
		
		fachada.adicionarCarrinho(car3);
		
		Carrinho car4 = new Carrinho();
		List<ItensCarrinho> listaItens4 = new ArrayList<ItensCarrinho>();
		listaItens4.add(i2);
		listaItens4.add(i1);
		listaItens4.add(i4);
		listaItens4.add(i3);
		car4.setCliente(c4);
		String fechamento4 = "18/04/2019";
		car4.setDataFechamento(sdf.parse(fechamento4));
		car4.setListaItens(listaItens);
		
		fachada.adicionarCarrinho(car4);
			
		// </Carrinho>	
	}
}
