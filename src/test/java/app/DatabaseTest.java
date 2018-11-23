package app;

import static org.junit.Assert.*;
import org.junit.*;

import bookmarks.*;

import java.util.*;
import java.util.logging.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class DatabaseTest {
	  private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("QAQ");
        }
    }
    @After
    public void tearDown() throws Exception {
      if ( sessionFactory != null ) {
        sessionFactory.close();
      }
    }
  
    @Test
    public void blogBookmarksDontCauseCrashing(){
        // Just tests that this doesn't crash
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( new BlogBookmark() );
        session.save( new BlogBookmark() );

        session.getTransaction().commit();
        session.close();
    
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from AbstractBookmark" ).list();
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        result = session.createQuery( "from BlogBookmark" ).list();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void bookBookmarksDontCauseCrashing(){
        // Just tests that this doesn't crash
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( new BookBookmark() );
        session.save( new BookBookmark() );

        session.getTransaction().commit();
        session.close();
    
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from AbstractBookmark" ).list();
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        result = session.createQuery( "from BookBookmark" ).list();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void podcastBookmarksDontCauseCrashing(){
        // Just tests that this doesn't crash
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( new PodcastBookmark() );
        session.save( new PodcastBookmark() );

        session.getTransaction().commit();
        session.close();
    
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from AbstractBookmark" ).list();
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        result = session.createQuery( "from PodcastBookmark" ).list();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void VideoBookmarksDontCauseCrashing(){
        // Just tests that this doesn't crash
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( new VideoBookmark() );
        session.save( new VideoBookmark() );

        session.getTransaction().commit();
        session.close();
    
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from AbstractBookmark" ).list();
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        result = session.createQuery( "from VideoBookmark" ).list();
        session.getTransaction().commit();
        session.close();
    }
}
