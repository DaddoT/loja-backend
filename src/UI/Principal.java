package UI;

import java.text.ParseException;
import java.util.Scanner;

import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Exceçoes.LoginException;
import Utilitario.PreCadastro;

public class Principal {
	static Scanner s = new Scanner(System.in);	
	public static void main(String[] args) throws ParseException, CadastroException, LoginException, InserirItemCarrinhoException {
		PreCadastro.Inicializar();
		int op2 = 0;
		while (op2 == 0) {
		System.out.println("Bem vindo \n \n Insira uma opção: \n 1. Cliente \n 2. Administrador \n 3. Encerrar programa");
		int op = s.nextInt();
		
		switch (op) {
			case 1:
				UICliente.showMenuCliente();
					break;
			case 2:
				System.out.println("Insira o login de administrador");
				String loginA = s.next();
				System.out.println("Insira a senha de administrador");
				String senhaA = s.next();
				
					if(loginA.equals("loginadmin") &&  senhaA.equals("senhaadmin")) {
						UIAdmin.showMenuAdmin();
					} else {
						System.out.println("login ou senha inválidos");
							op2 = 0;
					}
					break;
			case 3:
				op2 = 1;
				while (op2 == 1) {
				System.out.println("Insira 0 para reiniciar o programa");
				int op3 = s.nextInt();
				if (op3 == 0) {
					op2 = 0;
				} else {
					op2 = 1;
					}
					break;
				}
			default:
				op2 = 0;
				break;
			}
		}
	}
}
