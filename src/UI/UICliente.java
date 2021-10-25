package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Exceçoes.LoginException;
import Fachada.Fachada;
import Modelo.Cliente;
import Repositorios.RepositorioCliente;
 /* */
public class UICliente {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Fachada fachada = Fachada.getInstancia();
	private static RepositorioCliente repositorioCliente = RepositorioCliente.getInstancia();
	
	static Scanner s = new Scanner(System.in);
	
	public static void showMenuCliente() throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		System.out.println("Insira uma opcão: \n 1: Fazer cadastro \n 2: Login no sistema \n 3: Reiniciar programa");
		int op = s.nextInt();
		switch (op) {
			case 1:
				CadastrarCliente();
					break;
			case 2:
				loginCliente();
					break;
			case 3:
				
					break;
		}
	}	
	static void CadastrarCliente() throws ParseException , CadastroException {
		try {
		System.out.println("Insira o seu nome");
		String nome = s.next();
		System.out.println("Insira o seu CPF");
		String cpf =s.next();
		System.out.println("Insira o seu endereço");
		String endereco = s.next();
		System.out.println("Insira seu telefone");
		String telefone = s.next();
		System.out.println("Insira a sua data de nascimento (dd/MM/yyyy)");
		Date nascimento = sdf.parse(s.next());
		System.out.println("Insira seu nome de usuário");
		String nomeUsuario = s.next();
		System.out.println("Insira sua senha ");
		String senha = s.next();
		
		Cliente c = new Cliente(RepositorioCliente.getInstancia().listarCliente().size()+1, nome, cpf, endereco, telefone, nascimento, nomeUsuario, senha);
			Fachada.getInstancia().CadastrarCliente(c);
			System.out.println("Cliente cadastrado com sucesso \n Seu código é " + c.getCodigo());
		} catch (CadastroException e){
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
	}
	static void loginCliente() throws CadastroException, LoginException, ParseException, InserirItemCarrinhoException {
		try {
			System.out.println("Insira seu nome de usuário");
			String login = s.next();
			System.out.println("Insira sua senha");
			String senha = s.next();
	
			Cliente c = Fachada.getInstancia().loginCliente(login, senha);
			
			if (c != null) {
				UICompras.atribuirClienteACompra(c);
				UICompras.menuCompras();
			}
		} catch(CadastroException e) {
			System.out.println(e.getMessage());
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
