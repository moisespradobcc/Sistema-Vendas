package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Vendas;

public class VendasDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FuncionariosDAO fundao = new FuncionariosDAO();
		Funcionario f1 = fundao.buscarPorCodigo(1L);

		Vendas venda = new Vendas();
		venda.setFuncionario(f1);
		venda.setHorario(new Date());
		venda.setValor_total(new BigDecimal(350.00D));

		VendasDAO vendadao = new VendasDAO();
		vendadao.salvar(venda);

	}

	@Test
	@Ignore
	public void listar() {
		VendasDAO vdao = new VendasDAO();
		List<Vendas> vendas = vdao.listar();

		System.out.println(vendas);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarPorCodigo(3L);

		System.out.println(v1);

	}

	@Test
	@Ignore
	public void excluir() {
		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarPorCodigo(1L);

		vdao.excluir(v1);

	}

	@Test
	public void editar() {
		FuncionariosDAO fundao = new FuncionariosDAO();
		Funcionario f1 = fundao.buscarPorCodigo(1L);

		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarPorCodigo(2L);
		v1.setFuncionario(f1);
		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(10.00D));

		vdao.editar(v1);
	}
}
