package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.HibernateUtil;

public class FuncionariosDAO {
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.save(funcionario);
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
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> funcionarios = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return funcionarios;
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		} finally {
			sessao.close();
		}
		return funcionario;
	}

	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.delete(funcionario);
			transacao.commit();// Confirmando a transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();// Desfaz a transa??o reverte as altera??es
			}

		} finally {
			sessao.close();
		}

	}

	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // Abre uma transa??o
			sessao.update(funcionario);
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
