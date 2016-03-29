package net.jimmyme.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.jimmyme.model.User;
import net.jimmyme.param.StaticParam;
import net.jimmyme.service.UserService;
import net.jimmyme.util.HibernateUtil;

public class UserServiceImpl implements UserService{

	private static HibernateUtil util = new HibernateUtil();
	
	@Override
	public void addUser(User user) {
		
		
        Session session = null;
        Transaction transaction = null;
        try {
        	
        	session = util.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            
		} catch (Exception e) {
			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
		} finally {
			util.closeSession(session);
		}
	}

	@Override
	public void deleteUser(Integer userId) {
		
		
	}

	@Override
	public void updateUser(User user) {
		
		
	}

	@Override
	public User getUser(String username,Integer option) {
		
		Session session = null;
        Transaction transaction = null;
        User user = null;
		try {
			
	        session = util.openSession();
            transaction = session.beginTransaction();
	        
            StringBuffer stringBuffer = null;
            
	       if (option == StaticParam.GET_USER_BY_NAME) {
				
				stringBuffer = new StringBuffer("from User where userName= '"+username+"' ");
				
			} else if (option == StaticParam.GET_USER_BY_MAIL) {
				
				stringBuffer = new StringBuffer("from User where mail= '"+username+"' ");
				
			}
	        
	        
	        if (stringBuffer != null) {
	        	Query query = session.createQuery(stringBuffer.toString());
	        	@SuppressWarnings("rawtypes")
				List list = query.list();
	        	
	        	if (list.size() > 0) {
	        		user = (User)list.get(0);
		        	//System.out.println(user.toString());
				}
	        	
			}
	        
	        
		} catch (Exception e) {

			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
			
		} finally {
			util.closeSession(session);
		}
		
		
		return user;
	}
	
	@Override
	public Map<String, Object> getAllUser(String page, String rows, String sortOrder, String sortIndex) {
		
		
		Integer offset = (Integer.valueOf(page)-1)*Integer.valueOf(rows);
		Long allUserNum = null;
		Session session = null;
        Transaction transaction = null;
        List<User> users = null;
		try {
			
	        session = util.openSession();
            transaction = session.beginTransaction();
	        
            StringBuffer stringBuffer = new StringBuffer("from User");
            
            if (sortIndex != null && sortOrder != null && !sortIndex.equals("") && !sortOrder.equals("")) {
            	stringBuffer.append(" order by " + sortIndex + " " + sortOrder);
			}
            
	        if (stringBuffer != null) {
	        	
	        	Query query = session.createQuery(stringBuffer.toString())
	        			.setFirstResult(offset)
	        			.setMaxResults(Integer.valueOf(rows));
	        	
	        	users = query.list();
	        	//System.out.println(list.get(0).toString());
	        	allUserNum = (Long) session.createQuery("select count(*) from User u").uniqueResult();
	        	
			}
	        
	        
		} catch (Exception e) {

			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
			
		} finally {
			util.closeSession(session);
		}
		
		
		int total = (int) Math.ceil(allUserNum/Double.valueOf(rows));
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("page", page);
		map.put("total", total);
		map.put("records", allUserNum);
		map.put("rows", users);
		
		return map;
	}

	@Override
	public User getUserById(Integer userId) {
		Session session = null;
        Transaction transaction = null;
		User user = new User();
        
		try {
			
			session = util.openSession();
            transaction = session.beginTransaction();
	        
            StringBuffer stringBuffer = new StringBuffer("from User where userId="+userId);
            
            Query query = session.createQuery(stringBuffer.toString());
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	user = (User)list.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
		} finally {
			util.closeSession(session);
		}
		
		
		return user;
	}

}














