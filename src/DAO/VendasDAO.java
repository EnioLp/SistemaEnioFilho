/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Vendas;
import bean.Clientes; 
import bean.Vendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class VendasDAO {

    private Session session;
    private Transaction transaction;

    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(Vendas vendas) {
        getSession();
        session.save(vendas);
        transaction.commit();
        session.close();
    }

    public void update(Vendas vendas) {
        getSession();
        session.update(vendas);
        transaction.commit();
        session.close();
    }

    public void delete(Vendas vendas) {
        getSession();
        session.delete(vendas);
        transaction.commit();
        session.close();
    }
    
    public Vendas findById(int id) {
        getSession();
        Vendas vendas = (Vendas) session.get(Vendas.class, id);
        transaction.commit();
        session.close();
        return vendas;
    }
    
    public List<Vendas> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(Vendas.class);
        List<Vendas> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }
    /**
     * @param cliente
     * @return 
     */
    public List<Vendas> listByCliente(Clientes cliente) {
        getSession();
        Criteria criteria = session.createCriteria(Vendas.class);
        criteria.add(Restrictions.eq("clientes", cliente));
        List<Vendas> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }
    
    public List<Vendas> listByVendedor(Vendedor vendedor) {
        getSession();
        Criteria criteria = session.createCriteria(Vendas.class);
        criteria.add(Restrictions.eq("vendedor", vendedor));
        List<Vendas> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }
}