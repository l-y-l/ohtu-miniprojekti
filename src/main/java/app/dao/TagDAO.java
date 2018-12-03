package app.dao;

import app.domain.Tag;
import app.utilities.Utilities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TagDAO {

    private SessionFactory sessionFactory;

    /**
     * Initializes the class with a SessionFactory.
     */
    public TagDAO() {
        this(Utilities.DEPLOYMENT_DATABASE);
    }

    public TagDAO(String configurationFileName) {
        sessionFactory = new Configuration().configure(configurationFileName).buildSessionFactory();
    }

    /**
     * Closes the connection.
     */
    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public List<Tag> getTagsOnDatabase() {
        List result;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from Tag").list();
            session.getTransaction().commit();
        }
        return (List<Tag>) result;
    }

    public Tag getTagWithName(String name) {
        Tag result;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result = getTagWithName(session, name);
            session.getTransaction().commit();
        }
        return result;
    }

    public Tag getTagWithName(Session session, String name) {
        Query query = session.createQuery("from Tag where name = :name");
        query.setParameter("name", name);
        return (Tag) query.uniqueResult();
    }

    public void saveTagToDatabase(Tag tag) {
        Tag existing = getTagWithName(tag.getName());
        if (existing != null) {
            tag = existing;
        }
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(tag);
            session.getTransaction().commit();
        }
    }

    public Tag saveTagToDatabase(Session session, Tag tag) {
        Tag existing = getTagWithName(session, tag.getName());
        if (existing != null) {
            session.delete(tag); 
            tag = existing;
        }
        session.save(tag);
        return tag; 
    }

    public void saveTagsToDatabase(Collection<Tag> tags) {
        for (Tag t : tags) {
            saveTagToDatabase(t);
        }
    }

    public List<Tag> saveTagsToDatabase(Session session, Collection<Tag> tags) {
        List<Tag> result = new ArrayList(); 
        for (Tag t : tags) {
            result.add(saveTagToDatabase(session, t));
        }
        return result; 
    }

}
