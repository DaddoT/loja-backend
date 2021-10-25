package Controlador;

import java.util.List;

import Exceçoes.CadastroException;
import Modelo.Fornecedor;
import Repositorios.IRepositorioCliente;
import Repositorios.IRepositorioFornecedor;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioFornecedor;
 /* */
public class ControladorFornecedor implements IControladorFornecedor{
	
	private IRepositorioFornecedor repositorioFornecedor = RepositorioFornecedor.getInstancia();
	private static ControladorFornecedor instancia;
	
	public static ControladorFornecedor getInstancia() {
		if (instancia == null) {
			instancia = new ControladorFornecedor();
		}
		return instancia;
	}
	private ControladorFornecedor() {
		repositorioFornecedor = RepositorioFornecedor.getInstancia();
	}	

	@Override
	public void CadastrarFornecedor(Fornecedor f) throws CadastroException {
		if(repositorioFornecedor.existeFornecedor(f.getCnpj())) {
			throw new CadastroException("Fornecedor já cadastrado");
		} else {
		repositorioFornecedor.CadastrarFornecedor(f);
		}	
	}

	@Override
	public boolean RemoverFornecedor(String cnpj) throws CadastroException {
		if(!repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new CadastroException("Este cliente não existe");
		} else {
			repositorioFornecedor.RemoverFornecedor(cnpj);
		}
		return false;
	}

	@Override
	public Fornecedor ConsultaFornecedor(String cnpj) throws CadastroException {
		if(repositorioFornecedor.existeFornecedor(cnpj)) {
			throw new CadastroException("Este fornecedor não existe");
		} else {
			repositorioFornecedor.ConsultaFornecedor(cnpj);
		}
		return null;
	}
	@Override
	public List<Fornecedor> listarFornecedor() throws CadastroException {
		if(repositorioFornecedor.listarFornecedor() == null) {
			throw new CadastroException("Não há fornecedores cadastrados");
		} else {
			return repositorioFornecedor.listarFornecedor();
		}
	}
}
