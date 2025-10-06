package DAO;

import bean.Vendas;
import bean.VendaProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import DAO.HibernateUtil;

public class VendaProdutosDAO {

    private Session session;
    private Transaction transaction;

    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(VendaProdutos vendaProdutos) {
        getSession();
        session.save(vendaProdutos);
        transaction.commit();
        session.close();
    }

    public void update(VendaProdutos vendaProdutos) {
        getSession();
        session.update(vendaProdutos);
        transaction.commit();
        session.close();
    }

    public void delete(VendaProdutos vendaProdutos) {
        getSession();
        session.delete(vendaProdutos);
        transaction.commit();
        session.close();
    }
    
    public VendaProdutos findById(int id) {
        getSession();
        VendaProdutos vp = (VendaProdutos) session.get(VendaProdutos.class, id);
        transaction.commit();
        session.close();
        return vp;
    }
    
    public List<VendaProdutos> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(VendaProdutos.class);
        List<VendaProdutos> lista = criteria.list();
        transaction.commit();
        session.close();
        return lista;
    }

    public List<VendaProdutos> listByVenda(Vendas venda) {
    getSession();
    Criteria criteria = session.createCriteria(VendaProdutos.class);
    // Use o nome exato da variável no seu bean: "vendas" (plural)
    criteria.add(Restrictions.eq("vendas", venda)); 
    List<VendaProdutos> lista = criteria.list();
    transaction.commit();
    session.close();
    return lista;
    }
}