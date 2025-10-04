package DAO;

import bean.Usuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import DAO.HibernateUtil;

public class UsuariosDAO {

    private Session session;
    private Transaction transaction;
    private void getSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void insert(Usuarios usuario) {
        getSession();
        session.save(usuario);
        transaction.commit();
        session.close();
    }

    public void update(Usuarios usuario) {
        getSession();
        session.update(usuario);
        transaction.commit();
        session.close();
    }

    public void delete(Usuarios usuario) {
        getSession();
        session.delete(usuario);
        transaction.commit();
        session.close();
    }
    
    public Usuarios findById(int id) {
        getSession();
        Usuarios usuario = (Usuarios) session.get(Usuarios.class, id);
        session.close();
        return usuario;
    }
    
    public List<Usuarios> listAll() {
        getSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        List<Usuarios> lista = criteria.list();
        session.close();
        return lista;
    }
}