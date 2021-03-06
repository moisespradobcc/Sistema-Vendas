package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Vendas;
import br.com.vendas.util.HibernateUtil;

public class VendasDAO {
	public void salvar(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.save(venda);
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
	public List<Vendas> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Vendas> venda = null;

		try {

			Query consulta = sessao.getNamedQuery("Venda.listar");
			venda = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return venda;
	}

	public Vendas buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Vendas venda = null;

		try {

			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			venda = (Vendas) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return venda;
	}

	public void excluir(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.delete(venda);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

	public void editar(Vendas venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.update(venda);
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
