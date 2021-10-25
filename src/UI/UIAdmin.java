package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Exceçoes.LoginException;
import Fachada.Fachada;
import Modelo.Fornecedor;
import Modelo.Produto;
import Repositorios.Carrinho;
import Repositorios.RepositorioCarrinhos;
 /* */
public class UIAdmin {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Fachada fachada = Fachada.getInstancia();
	static Scanner s = new Scanner(System.in);
	
	public static void showMenuAdmin() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira qual setor você deseja acessar: \n 1: Produtos \n 2: Clientes "
				+ "\n 3: Carrinhos \n 4: Fornecedores");
		int op = s.nextInt();
		switch (op) {
			case 1:
				setorProdutos();
					break;
			case 2:
				setorClientes();
					break;
			case 3:
				setorCarrinhos();
					break;
			case 4:
				setorFornecedores();
					break;
		}
	}
	static void setorProdutos() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira uma opcão: \n 1: Cadastrar produto \n 2: Remover produto \n 3: Consultar produto \n 4: Listar produtos"
				+ "\n 5: Reiniciar programa ");
		int op = s.nextInt();
		switch (op) {
			case 1:
				CadastrarProduto();
					break;
			case 2:
				RemoverProduto();	
					break;
			case 3:
				ConsultarProduto();
				break;
			case 4:
				ListarProduto();
				break;	
			case 5:
				showMenuAdmin();
				break;	
		}
	}
	static void CadastrarProduto() throws CadastroException, ParseException {
		System.out.println("Insira o código do produto");
		int codigo = s.nextInt();
		System.out.println("Insira o nome do produto");
		String nome = s.next();
		System.out.println("Insira a descrição do produto");
		String descricao = s.next();
		System.out.println("Insira a categoria do produto");
		s.nextLine();
		String categoria = s.nextLine();
		System.out.println("Insira o CNPJ do fornecedor do produto");
		String cnpj = s.next();
		System.out.println("Insira a quantidade em estoque do produto");
		int quantidade = s.nextInt();
		
		try {
		Fornecedor f = fachada.listarFornecedor().stream().filter(x -> x.getCnpj().equals(cnpj)).findFirst().orElse(null);
			if (f == null) {
				try {
					System.out.println("Insira o código do fornecedor");
					int codigoF = s.nextInt();
					System.out.println("Insira o CNPJ do fornecedor");
					String cnpjF = s.next();
					System.out.println("Insira o nome do fornecedor");
					String nomeF = s.next();
					System.out.println("Insira o nome fantasia do fornecedor");
					String nomeFantasia = s.next();
					System.out.println("Insira o endereço do fornecedor");
					String enderecoF = s.next();
					System.out.println("Insira o telefone do fornecedor");
					String telefoneF = s.next();
					System.out.println("Insira a data de abertura da empresa do fornecedor");
					Date dataAbertura = sdf.parse(s.next());
					
					f = new Fornecedor(codigoF , cnpjF , nomeF, nomeFantasia, enderecoF, telefoneF, dataAbertura);
					fachada.CadastrarFornecedor(f);
				} catch (CadastroException e) {
					System.out.println(e.getMessage());
				} catch (ParseException e) {
					System.out.println("Formato de data inválido");
				}
			}
			else {
				Produto p = new Produto(codigo, nome, descricao, categoria, f, quantidade);
				fachada.CadastrarProduto(p);
			}
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void RemoverProduto() {
		System.out.println("Insira o código do produto a ser removido");
		int codigo = s.nextInt();
		
		try {
			fachada.getInstancia().RemoverProduto(codigo);
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void ConsultarProduto() {
		System.out.println("Insira o nome do produto a ser pesquisado");
		String nome = s.next();
		
		try {
			System.out.println(fachada.getInstancia().ConsultaProduto(nome));
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void ListarProduto() {
		try {
			System.out.println(fachada.getInstancia().listarProduto());
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void setorClientes() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira uma opcão: \n 1: Remover cliente \n 2: Consultar cliente \n 3: Listar clientes"
				+ "\n 4: Reiniciar programa ");
		int op = s.nextInt();
		switch (op) {
			case 1:
				RemoverCliente();
					break;
			case 2:
				ConsultarCliente();	
					break;
			case 3:
				ListarClientes();
				break;
			case 4:
				UIAdmin.showMenuAdmin();
				break;	
		}
	}
	static void RemoverCliente() throws CadastroException {
		System.out.println("Insira o cpf do cliente a ser removido");
		String cpf = s.next();
		
		try {
			fachada.RemoverCliente(cpf);
			System.out.println("Cliente removido");
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void ConsultarCliente() throws CadastroException {
		System.out.println("Insira o cpf do cliente para consulta");
		String cpf = s.next();
		
		try {
			fachada.getInstancia().ConsultaCliente(cpf);
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void ListarClientes() throws CadastroException, ParseException, LoginException, InserirItemCarrinhoException {
		try {
			System.out.println(fachada.listarCliente());
			showMenuAdmin();
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void setorCarrinhos() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira uma opção: \n 1: Listar carrinhos \n 2: Reiniciar programa");
		int op = s.nextInt();
		switch (op) {
			case 1:
				ListarCarrinhos();
					break;
			case 2:
				showMenuAdmin();
					break;
		}		
	}
	static void ListarCarrinhos() throws CadastroException {
		try {
			for(Carrinho car : fachada.listarCarrinhos()) {
				System.out.println(car + " - " + car.getDataFechamento());		
			}
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	} 
	static void setorFornecedores() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira uma opcão: \n 1: Cadastrar fornecedor \n 2: Remover fornecedor \n 3: Consultar fornecedor "
				+ "\n 4: Reiniciar programa");
		int op = s.nextInt();
		
		switch (op) {
			case 1:
				CadastrarFornecedor();
					break;
			case 2:
				RemoverFornecedor();
					break;
			case 3:
				ConsultarFornecedor();
				break;
			case 4:
				showMenuAdmin();
				break;	
		}
	}
	static void CadastrarFornecedor() throws ParseException , CadastroException{
		try {
		System.out.println("Insira o código do fornecedor");
		int codigo = s.nextInt();
		System.out.println("Insira o CNPJ do fornecedor");
		String cnpj = s.next();
		System.out.println("Insira o nome do fornecedor");
		String nome = s.next();
		System.out.println("Insira o nome fantasia do fornecedor");
		String nomeFantasia = s.next();
		System.out.println("Insira o endereço do fornecedor");
		String endereco = s.next();
		System.out.println("Insira o telefone do fornecedor");
		String telefone = s.next();
		System.out.println("Insira a data de abertura da empresa do fornecedor");
		Date dataAbertura = sdf.parse(s.next());
		
		Fornecedor f = new Fornecedor(codigo, cnpj , nome, nomeFantasia, endereco, telefone, dataAbertura);
		Fachada.getInstancia().CadastrarFornecedor(f);
		
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}		
	}
	static void RemoverFornecedor() throws CadastroException{
		System.out.println("Insira o CNPJ do fornecedor a ser removido");
		String cnpj = s.next();
		
		try {
			Fachada.getInstancia().RemoverFornecedor(cnpj);
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
	static void ConsultarFornecedor() throws CadastroException {
		System.out.println("Insira o cnpj do fornecedor para consulta");
		String cnpj = s.next();
		
		try {
			fachada.ConsultaFornecedor(cnpj);
		} catch (CadastroException e) {
			System.out.println(e.getMessage());
		}
	}
}
