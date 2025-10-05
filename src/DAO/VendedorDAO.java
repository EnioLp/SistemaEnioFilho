package DAO;

import bean.Vendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class VendedorDAO {

    private Session session;
    private Transaction transaction;

    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(Vendedor vendedor) {
        getSession();
        session.save(vendedor);
        transaction.commit();
        session.close();
    }

    public void update(Vendedor vendedor) {
        getSession();
        session.update(vendedor);
        transaction.commit();
        session.close();
    }

    public void delete(Vendedor vendedor) {
        getSession();
        session.delete(vendedor);
        transaction.commit();
        session.close();
    }
    
    public Vendedor findById(int id) {
        getSession();
        Vendedor vendedor = (Vendedor) session.get(Vendedor.class, id);
        transaction.commit();
        session.close();
        return vendedor;
    }
    
    public List<Vendedor> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(Vendedor.class);
        List<Vendedor> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }

    public boolean cpfJaCadastrado(String cpf) {
        getSession();
        Criteria criteria = session.createCriteria(Vendedor.class);
        criteria.add(Restrictions.eq("cpf", cpf));
        List<Vendedor> lista = criteria.list();
        transaction.commit();
        session.close();
        return !lista.isEmpty();
    }
    
    public boolean cnpjJaCadastrado(String cnpj) {
        getSession();
        Criteria criteria = session.createCriteria(Vendedor.class);
        criteria.add(Restrictions.eq("cnpj", cnpj));
        List<Vendedor> lista = criteria.list();
        transaction.commit();
        session.close();
        return !lista.isEmpty();
    }
}