package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.save(fornecedor);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Fornecedor> fornecedores = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return fornecedores;
	}

	public Fornecedor buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return fornecedor;
	}

	public void excluir(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.delete(fornecedor);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

	public void editar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.update(fornecedor);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

}
