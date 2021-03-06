package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(6L);

		Produto p1 = new Produto();
		p1.setDescricao("Smartphone Moto G 60");
		p1.setPreco(new BigDecimal(2500.00D));
		p1.setQuantidade(5);
		p1.setFornecedor(f1);

		ProdutosDAO pdao = new ProdutosDAO();
		pdao.salvar(p1);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutosDAO pdao = new ProdutosDAO();
		List<Produto> produtos = pdao.listar();

		System.out.println(produtos);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produto p1 = pdao.buscarPorCodigo(3L);

		System.out.println(p1);

	}

	@Test
	@Ignore
	public void excluir() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produto p1 = pdao.buscarPorCodigo(1L);

		pdao.excluir(p1);

	}

	@Test
	public void editar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(8L);

		ProdutosDAO pdao = new ProdutosDAO();
		Produto p1 = pdao.buscarPorCodigo(3L);
		p1.setDescricao("Pacote Leite Integral 300g");
		p1.setFornecedor(f1);
		p1.setPreco(new BigDecimal(10.00D));
		p1.setQuantidade(10);

		pdao.editar(p1);
	}
}
