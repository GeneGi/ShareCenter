
/**
 * Created by jimmy on 2016/3/9.
 */
package net.jimmyme;

import junit.framework.TestCase;
import net.jimmyme.model.User;
import net.jimmyme.param.StaticParam;
import net.jimmyme.service.UserService;
import net.jimmyme.service.Impl.UserServiceImpl;
import net.jimmyme.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class TestClient extends TestCase {

	private static HibernateUtil util = new HibernateUtil();
	
    public void testCase1(){

    	Session session = null;
        Transaction transaction = null;
        
		try {
			
	        session = util.openSession();
            transaction = session.beginTransaction();
	        
            for (int i = 0; i < 50; i++) {
				User user = new User();
				user.setUserName("Jimmy"+i);
				user.setPassword("123456");
				user.setMail("jimmy"+i+"@126.com");
				user.setProfile("woshi Jimmy");
				user.setUserType(1);
				user.setPhotoUrl("/resources/images/jimmy"+i+"/photo.jpg");
				session.save(user);
			}
	        
		} catch (Exception e) {

			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
			
		} finally {
			util.closeSession(session);
		}
		
		
		
    }

    public void testCase2(){

        HibernateUtil util = new HibernateUtil();
        Session session = null;
        Transaction transaction = null;

        try {
            session = util.openSession();
            transaction = session.beginTransaction();

			/*StringBuffer stringBuffer = new StringBuffer("select c.courseName,sc.grade "
					+ "from Course as c,SelectCourse as sc "
					+ "where c.courseId=sc.course.courseId");
			*/
            StringBuffer stringBuffer = new StringBuffer("from User");
            Query query = session.createQuery(stringBuffer.toString());
            @SuppressWarnings("unchecked")
			List<Object> list = (List<Object>)query.list();

			/*for (int i = 0; i < list.size(); i++) {
				Object object = list.get(i);
				Object[] objArr = (Object[])object;
			}*/
            for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				
				User user = (User)object;
				System.out.println(user.toString());
				
			}

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            util.closeSession(session);
        }

        System.out.println("-----------1");
    }
    
    public void testCase3(){
    	
    	UserService userService = new UserServiceImpl();
    	
    	//List<User> users = userService.getAllUser();
    	//System.out.println(users.get(0).toString());
    	
    }
}
