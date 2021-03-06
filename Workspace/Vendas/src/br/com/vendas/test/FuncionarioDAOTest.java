package br.com.vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.domain.Funcionario;;

public class FuncionarioDAOTest {
	@Ignore
	public void salvar() {
		Funcionario f1 = new Funcionario();
		f1.setNome("Ana Karoline");
		f1.setCpf("22222222222");
		f1.setFuncao("RH");
		f1.setSenha("123456");

		// Funcionario f2 = new Funcionario();
		// f2.setNome("D?bora Gibson");
		// f2.setCpf("48515726924");
		// f2.setFuncao("Gerente");
		// f2.setSenha("123456");

		FuncionariosDAO fdao = new FuncionariosDAO();
		fdao.salvar(f1);
		// fdao.salvar(f2);

	}

	@Ignore
	public void listar() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		List<Funcionario> funcionarios = fdao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}

	@Ignore
	public void buscarPorCodigo() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario f1 = fdao.buscarPorCodigo(3L);
		Funcionario f2 = fdao.buscarPorCodigo(1L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Ignore
	public void excluir() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario f1 = fdao.buscarPorCodigo(3L);

		fdao.excluir(f1);

	}

	@Test
	@Ignore
	public void editar() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario f1 = fdao.buscarPorCodigo(2L);
		f1.setNome("Irlana Santos");
		f1.setCpf("33333333333");
		f1.setFuncao("Advogada");
		f1.setSenha("123456");

		fdao.editar(f1);
	}
}
