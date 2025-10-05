package DAO;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import DAO.HibernateUtil;
import bean.Clientes;
import org.hibernate.criterion.Restrictions;

public class ClientesDAO {

    private Session session;
    private Transaction transaction;
    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(Clientes clientes) {
        getSession();
        session.save(clientes);
        transaction.commit();
        session.close();
    }

    public void update(Clientes clientes) {
        getSession();
        session.update(clientes);
        transaction.commit();
        session.close();
    }

    public void delete(Clientes clientes) {
        getSession();
        session.delete(clientes);
        transaction.commit();
        session.close();
    }
    
    public Clientes findById(int id) {
        getSession();
        Clientes clientes = (Clientes) session.get(Clientes.class, id);
        session.close();
        return clientes;
    }
    
    public List<Clientes> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        List<Clientes> lista = criteria.list();
        session.close();
        return lista;
    }
    public boolean cpfJaCadastrado(String cpf) {
    getSession();
    Criteria criteria = session.createCriteria(Clientes.class);
    criteria.add(Restrictions.eq("cpf", cpf));
    boolean existe = criteria.uniqueResult() != null;
    
    transaction.commit();
    session.close();
    
    return existe;
}
}