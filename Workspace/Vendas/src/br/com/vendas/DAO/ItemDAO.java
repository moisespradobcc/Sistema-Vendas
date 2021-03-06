package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Item;
import br.com.vendas.util.HibernateUtil;

public class ItemDAO {
	public void salvar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.save(item);
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
	public List<Item> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Item> itens = null;

		try {

			Query consulta = sessao.getNamedQuery("Item.listar");
			itens = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return itens;
	}

	public Item buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Item item = null;

		try {

			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			item = (Item) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return item;
	}

	public void excluir(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.delete(item);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

	public void editar(Item item) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.update(item);
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
