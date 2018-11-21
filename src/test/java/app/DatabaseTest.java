package app;

import static org.junit.Assert.*;
import org.junit.*;

import bookmarks.AbstractBookmark;
import bookmarks.BlogBookmark;

import java.util.*;
import java.util.logging.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class DatabaseTest {
	private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        // For default hibernate logs a lot
        // Turn it off...
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

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
    public void testTest(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save( new BlogBookmark("author", "title", "url", new ArrayList<String>(), new ArrayList<String>(), "description", "comment") );
        session.save( new BlogBookmark("author2", "title2", "url2", new ArrayList<String>(), new ArrayList<String>(), "description", "comment") );

        session.getTransaction().commit();
        session.close();
    
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from BlogBookmark" ).list();
        for ( BlogBookmark bm: (List<BlogBookmark>) result ) {
          System.out.println(bm.toString());
        }
        session.getTransaction().commit();
        session.close();
    }
}
