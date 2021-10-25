package Fachada;

import java.util.List;

import Controlador.ControladorCarrinho;
import Controlador.ControladorCliente;
import Controlador.ControladorFornecedor;
import Controlador.ControladorProduto;
import Controlador.ControladorRCarrinhos;
import Controlador.IControladorCarrinho;
import Controlador.IControladorCliente;
import Controlador.IControladorFornecedor;
import Controlador.IControladorProduto;
import Controlador.IControladorRCarrinhos;
import Exceçoes.CadastroException;
import Exceçoes.InserirItemCarrinhoException;
import Exceçoes.LoginException;
import Modelo.Cliente;
import Modelo.Fornecedor;
import Modelo.ItensCarrinho;
import Modelo.Produto;
import Repositorios.Carrinho;
import Repositorios.ICarrinho;
import Repositorios.IRepositorioCarrinhos;
import Repositorios.RepositorioCliente;
 /* */
public class Fachada implements IControladorCliente , IControladorProduto , IControladorFornecedor , IControladorCarrinho , IControladorRCarrinhos{
	
	private IControladorCliente controladorCliente;
	private IControladorProduto controladorProduto;
	private IControladorFornecedor controladorFornecedor;
	private IControladorCarrinho controladorCarrinho;
	private IControladorRCarrinhos controladorRCarrinhos;
	
private static Fachada instancia;
	
	public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
	
	  private Fachada(){
	        controladorCliente = ControladorCliente.getInstancia();
	        controladorProduto = ControladorProduto.getInstancia();
	        controladorFornecedor = ControladorFornecedor.getInstancia();
	        controladorCarrinho = ControladorCarrinho.getInstancia();
	        controladorRCarrinhos = ControladorRCarrinhos.getInstancia();
	    }

	@Override
	public void CadastrarCliente(Cliente c) throws CadastroException {
		controladorCliente.CadastrarCliente(c);
	}

	@Override
	public boolean RemoverCliente(String cpf) throws CadastroException {
		return controladorCliente.RemoverCliente(cpf);
	}

	@Override
	public Cliente ConsultaCliente(String cpf) throws CadastroException {
		controladorCliente.ConsultaCliente(cpf);
		return null;
	}

	@Override
	public void CadastrarProduto(Produto p) throws CadastroException {
		controladorProduto.CadastrarProduto(p);
	}

	@Override
	public boolean RemoverProduto(int codigo) throws CadastroException {
		return controladorProduto.RemoverProduto(codigo);
	}

	@Override
	public Produto ConsultaProduto(String nome) throws CadastroException {
		return controladorProduto.ConsultaProduto(nome);	
	}

	@Override
	public void CadastrarFornecedor(Fornecedor f) throws CadastroException {
		controladorFornecedor.CadastrarFornecedor(f);
	}

	@Override
	public boolean RemoverFornecedor(String cnpj) throws CadastroException {
		controladorFornecedor.RemoverFornecedor(cnpj);
		return false;
	}

	@Override
	public Fornecedor ConsultaFornecedor(String cnpj) throws CadastroException {
		return controladorFornecedor.ConsultaFornecedor(cnpj);		
	}

	@Override
	public List<Cliente> listarCliente() throws CadastroException {
		return controladorCliente.listarCliente();
	}

	@Override
	public Cliente loginCliente(String login, String senha) throws CadastroException, LoginException {
		return controladorCliente.loginCliente(login, senha);	
	}

	@Override
	public List<Produto> listarProduto() throws CadastroException {
		return controladorProduto.listarProduto();
	}

	@Override
	public List<Fornecedor> listarFornecedor() throws CadastroException {
		return controladorFornecedor.listarFornecedor();
	}

	@Override
	public void inserirItem(ItensCarrinho i, int codigo , int quantidadeSubtraida) throws InserirItemCarrinhoException, CadastroException {
		ControladorCarrinho.getInstancia().inserirItem(i, codigo, quantidadeSubtraida);
	}

	@Override
	public List<ItensCarrinho> listarItens() throws CadastroException {
		return controladorCarrinho.listarItens();		
	}
	
	@Override
	public List<Carrinho> listarCarrinhos() throws CadastroException {
		return controladorRCarrinhos.listarCarrinhos();
	}

	@Override
	public void adicionarCarrinho(Carrinho carrinho) {
		controladorRCarrinhos.adicionarCarrinho(carrinho);
	}

	@Override
	public void devolverAoEstoque(int codigo, int quantidadeAdicionada) throws InserirItemCarrinhoException, CadastroException {
		ControladorCarrinho.getInstancia().devolverAoEstoque(codigo, quantidadeAdicionada);		
	}
}
