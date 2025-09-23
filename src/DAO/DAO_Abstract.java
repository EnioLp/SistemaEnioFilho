/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author eniof
 */
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class DAO_Abstract {

    public Session session;

    // O construtor abre a sessão com o Hibernate, que será usada pelos métodos.
    public DAO_Abstract() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    // Métodos que serão implementados pelas classes filhas
    public abstract void insert(Object objeto);
    public abstract void update(Object objeto);
    public abstract void delete(Object objeto);
    public abstract Object list(int codigo);
    public abstract List listAll();
}