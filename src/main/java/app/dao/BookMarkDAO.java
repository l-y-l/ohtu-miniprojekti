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
 * Class that handles all database operations.
 * @author jussiste
 */
public class BookMarkDAO {

    private SessionFactory sessionFactory;

    /**
     * Initializes the class with a SessionFactory.
     */
    public BookMarkDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Closes the connection.
     */
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    /**
     * Returns all the bookmarks in the database.
     * @return list of AbstractBookmarks
     */
    public List<AbstractBookmark> getBookMarksOnDatabase() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from AbstractBookmark").list();
        session.getTransaction().commit();
        session.close();
        return (List<AbstractBookmark>) result;
    }

    /**
     * Saves a bookmark to the database.
     * @param bookmark bookmark to be saved
     */
    public void saveBookmarkToDatabase(AbstractBookmark bookmark) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookmark);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return all bookmarks of a specific time e.g VideoBookmars
     * @param search type to be searched
     * @return list of bookmarks
     */
    public List<AbstractBookmark> getBookMarkClass(String search) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from " + search).list();
        session.getTransaction().commit();
        session.close();
        return (List<AbstractBookmark>) result;
    }

    /**
     * Used to search a specific field in the database using a search term. The term doesn't need to be an exact match, since it uses the like-operator. 
     * @param field field to be searched
     * @param search term used to search
     * @return list of bookmarks. If either of the parameters are invalid i.e empty, this method returns an empty list.
     */
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
