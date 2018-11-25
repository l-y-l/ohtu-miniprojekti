/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import bookmarks.AbstractBookmark;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jussiste
 */
public class BookMarkDAO {

    private SessionFactory sessionFactory;

    public BookMarkDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public List<AbstractBookmark> getBookMarksOnDatabase() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from AbstractBookmark").list();
        session.getTransaction().commit();
        session.close();
        return (List<AbstractBookmark>) result;
    }

    public void saveBookmarkToDatabase(AbstractBookmark bookmark) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookmark);
        session.getTransaction().commit();
        session.close();
    }

    public List<AbstractBookmark> getBookMarkClass(String search) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from " + search).list();
        session.getTransaction().commit();
        session.close();
        return (List<AbstractBookmark>) result;
    }

    public List<AbstractBookmark> searchByTitle(String field, String search) {
        if (field.equals("") || search.equals("")) {
            return new ArrayList<AbstractBookmark>();
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(AbstractBookmark.class);
        cr.add(Restrictions.like(field, "%"+search+"%"));
        List result = cr.list();
        session.getTransaction().commit();
        session.close();
        return (List<AbstractBookmark>) result;
    }
}
