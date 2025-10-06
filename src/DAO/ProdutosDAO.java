package DAO;

import bean.Produtos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProdutosDAO {

    private Session session;
    private Transaction transaction;

    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(Produtos produtos) {
        getSession();
        session.save(produtos);
        transaction.commit();
        session.close();
    }

    public void update(Produtos produtos) {
        getSession();
        session.update(produtos);
        transaction.commit();
        session.close();
    }

    public void delete(Produtos produtos) {
        getSession();
        session.delete(produtos);
        transaction.commit();
        session.close();
    }
    
    public Produtos findById(int id) {
        getSession();
        Produtos produtos = (Produtos) session.get(Produtos.class, id);
        transaction.commit();
        session.close();
        return produtos;
    }
    
    public List<Produtos> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(Produtos.class);
        List<Produtos> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public List<Produtos> findByTitulo(String titulo) {
        getSession();
        Criteria criteria = session.createCriteria(Produtos.class);
        criteria.add(Restrictions.like("titulo", "%" + titulo + "%"));
        List<Produtos> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }
    public Produtos findByCodigoLivro(String codigoLivro) {
    getSession();
    Criteria criteria = session.createCriteria(Produtos.class);
    criteria.add(Restrictions.eq("codigoLivro", codigoLivro));
    Produtos produtos = (Produtos) criteria.uniqueResult();
    transaction.commit();
    session.close();
    return produtos;
}
}