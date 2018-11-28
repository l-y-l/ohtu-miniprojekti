/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import bookmarks.Bookmark;
import app.domain.Course;
import app.domain.Tag;
import app.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Class that handles all database operations.
 *
 * @author jussiste
 */
public class BookMarkDAO {

    private SessionFactory sessionFactory;
    private TagDAO tagDAO;

    /**
     * Initializes the class with a SessionFactory.
     */
    public BookMarkDAO() {
        this(Utilities.DEPLOYMENT_DATABASE);
    }

    public BookMarkDAO(String configurationFileName) {
        sessionFactory = new Configuration().configure(configurationFileName).buildSessionFactory();
        tagDAO = new TagDAO(configurationFileName);
    }

    /**
     * Closes the connection.
     */
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        tagDAO.close(); 
    }

    /**
     * Returns all the bookmarks in the database.
     *
     * @return list of Bookmarks
     */
    public List<Bookmark> getBookMarksOnDatabase() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Bookmark").list();
        session.getTransaction().commit();
        session.close();
        return (List<Bookmark>) result;
    }

    /**
     * Saves a bookmark to the database.
     *
     * @param bookmark bookmark to be saved
     */
    public void saveBookmarkToDatabase(Bookmark bookmark) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookmark);
        // save tags and stuff

        
        bookmark.setTags(tagDAO.saveTagsToDatabase(session, bookmark.getTags()));

        for (Course c : bookmark.getRelatedCourses()) {

            session.saveOrUpdate(c);

        }

        for (Course c : bookmark.getPrerequisiteCourses()) {

            session.saveOrUpdate(c);

        }

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Return all bookmarks of a specific time e.g VideoBookmars
     *
     * @param search type to be searched
     * @return list of bookmarks
     */
    public List<Bookmark> getBookMarkClass(String search) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from " + search).list();
        session.getTransaction().commit();
        session.close();
        return (List<Bookmark>) result;
    }

    /**
     * Used to search a specific field in the database using a search term. The
     * term doesn't need to be an exact match, since it uses the like-operator.
     *
     * @param field field to be searched
     * @param search term used to search
     * @return list of bookmarks. If either of the parameters are invalid i.e
     * empty, this method returns an empty list.
     */
    public List<Bookmark> searchField(String field, String search) {
        if (field.equals("") || search.equals("")) {
            return new ArrayList<Bookmark>();
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Bookmark.class);
        cr.add(Restrictions.like(field, "%" + search + "%"));
        List result = cr.list();
        session.getTransaction().commit();
        session.close();
        return (List<Bookmark>) result;
    }

    /**
     * Method that returns the info of a single database entry in String form.
     *
     * @param id id of the database entity
     * @return bookmark.toString
     */
    public String getSingleBookmarkInfo(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Bookmark bookmark = session.load(Bookmark.class, id);
        String ret = "";
        ret += bookmark.toString();
        session.close();
        return ret;
    }

    /**
     * Method that allows to edit either the author or the title field of a
     * given entry.
     *
     * @param id id of entry
     * @param field field to be edited
     * @param newEntry new data
     */
    public void editEntry(Long id, String field, String newEntry) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Bookmark bookmark = session.load(Bookmark.class, id);
        switch (field) {
            case ("author"):
                bookmark.setAuthor(newEntry);
                break;
            case ("title"):
                bookmark.setTitle(newEntry);
                break;
        }
        session.evict(bookmark);
        session.update(bookmark);
        session.getTransaction().commit();
        session.close();
        System.out.println("The entry has been updated!");
    }

    /**
     * Deletes bookmark from database by bookmark-id.
     *
     * @param bookmark_id
     */
    public void deleteBookmarkFromDatabase(Long bookmark_id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(session.load(Bookmark.class, bookmark_id));

        session.getTransaction().commit();
        session.close();
    }
}
