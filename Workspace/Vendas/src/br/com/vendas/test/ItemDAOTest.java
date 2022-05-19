package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.ItemDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Vendas;

public class ItemDAOTest {
	@Test
	@Ignore
	public void salvar() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produto p1 = pdao.buscarPorCodigo(2L);

		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarPorCodigo(2L);

		Item it = new Item();

		it.setProduto(p1);
		it.setQuantidade(2);
		it.setValor_parcial(new BigDecimal(100.00D));
		it.setVenda(v1);

		ItemDAO itdao = new ItemDAO();
		itdao.salvar(it);

	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO idao = new ItemDAO();
		List<Item> itens = idao.listar();

		System.out.println(itens);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO idao = new ItemDAO();
		Item i1 = idao.buscarPorCodigo(1L);

		System.out.println(i1);

	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO idao = new ItemDAO();
		Item i1 = idao.buscarPorCodigo(1L);

		idao.excluir(i1);

	}

	@Test

	public void editar() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produto p1 = pdao.buscarPorCodigo(2L);

		VendasDAO vdao = new VendasDAO();
		Vendas v1 = vdao.buscarPorCodigo(2L);

		ItemDAO itdao = new ItemDAO();
		Item it = itdao.buscarPorCodigo(2L);

		it.setProduto(p1);
		it.setQuantidade(500);
		it.setValor_parcial(new BigDecimal(500.00D));
		it.setVenda(v1);

		itdao.editar(it);
	}
}
