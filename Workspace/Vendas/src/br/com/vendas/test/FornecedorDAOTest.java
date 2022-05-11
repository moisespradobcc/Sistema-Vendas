package br.com.vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedorDAOTest {

	@Ignore
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("Dell Computadoeres");

		Fornecedor f2 = new Fornecedor();
		f2.setDescricao("Furukawa");

		Fornecedor f3 = new Fornecedor();
		f3.setDescricao("Motorola");

		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
		fdao.salvar(f2);
		fdao.salvar(f3);
	}

	@Ignore
	public void listar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fdao.listar();

		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}

	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(3L);
		Fornecedor f2 = fdao.buscarPorCodigo(5L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Ignore
	public void excluir() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(2L);

		if (f1 != null) {
			fdao.excluir(f1);
		}
	}

	@Ignore
	public void excluirPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.excluir(3L);
	}

	@Test
	public void editar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo(5L);
		fornecedor.setDescricao("Reebok");

		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.editar(fornecedor);
	}

}