/**
 * Created by jimmy on 2016/3/9.
 */

package net.jimmyme.controller;

import net.jimmyme.model.User;
import net.jimmyme.param.StaticParam;
import net.jimmyme.service.UserService;
import net.jimmyme.service.Impl.UserServiceImpl;
import net.jimmyme.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	private static UserService userService =  new UserServiceImpl();

    @RequestMapping(value="/")
    public ModelAndView indexPage(){

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
    
    @RequestMapping(value="/login")
    public String login(){
    	
    	return "login";
    }
    
    @RequestMapping(value="/dolog")
    public String doLog(HttpServletRequest request){
    	request.getSession().removeAttribute("user");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	System.out.println(username + "---" + password);
    	String view = "login";
    	
    	User user = null;
    	user = userService.getUser(username, StaticParam.GET_USER_BY_NAME);
    	if (user == null) {
    		user = userService.getUser(username, StaticParam.GET_USER_BY_MAIL);
		}
    	
    	if (user == null) {
			request.setAttribute("loginInfo", "用户不存在");
		} else {
			String password2 = user.getPassword();
			
			if (password.equals(password2)) {
				request.getSession().setAttribute("user", user);
				view = "index";
			} else {
				request.setAttribute("loginInfo", "用户密码错误");
			}
		}
    	
    	return view;
    }
    
    @RequestMapping(value="/getUser")
    public @ResponseBody User getUser(HttpServletRequest request){
    	
    	User user = null;
    	user = (User) request.getSession().getAttribute("user");
    	
    	return user;
    }
    
    @RequestMapping(value="logout")
    public String logout(HttpServletRequest request){
    	
    	request.getSession().removeAttribute("user");
    	
    	return "login";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/jsonTest")
    public @ResponseBody List<Object> getTest(){

        HibernateUtil util = new HibernateUtil();
        Session session = null;
        Transaction transaction = null;
        List<Object> list = null;
        try {
            session = util.openSession();
            transaction = session.beginTransaction();

            StringBuffer stringBuffer = new StringBuffer("select c.courseName,sc.grade "
                    + "from Course as c,SelectCourse as sc "
                    + "where c.courseId=sc.course.courseId");

            Query query = session.createQuery(stringBuffer.toString());
            list = (List<Object>)query.list();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            util.closeSession(session);
        }


        return list;
    }
    
    @RequestMapping(value="/uploadPhoto",method=RequestMethod.GET)
    public String uploadPhoto(HttpServletRequest request) {  
        
        @SuppressWarnings("unused")
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
        return "";
    }
    
    @RequestMapping(value="/jqgrid")
    public String jqString(){
    	
    	return "jqgrid";
    }
    
    @RequestMapping(value="/allUser")
    public @ResponseBody Map<String, Object> getAllUser(HttpServletRequest request){
    	
    	String page = request.getParameter("page");
    	String rows = request.getParameter("rows");
    	String sortOrder = request.getParameter("sord");
    	String sortIndex = request.getParameter("sidx");
    	
    	Map<String, Object> map = userService.getAllUser(page,rows,sortOrder,sortIndex);
    	
    	return map;
    }
    
    @RequestMapping(value="/edit")
    public @ResponseBody Object edit(HttpServletRequest request){
    	
    	String oper = request.getParameter("oper");
    	
    	if (oper.equals("edit") || oper.equals("add")) {
			
    		String userId = request.getParameter("userId");
    		String userName = request.getParameter("userName");
        	String password = request.getParameter("password");
        	String mail = request.getParameter("mail");
    		String profile = request.getParameter("profile");
    		String photoUrl = request.getParameter("photoUrl");
		}
    	else {
    		String id = request.getParameter("id");
		}
    	
    	
    	
		
		Enumeration<String> paramNames = request.getParameterNames();  
	    while (paramNames.hasMoreElements()) {  
	      System.out.println((String) paramNames.nextElement());
	    }
		
		//String string = oper+"//"+userId+"//"+userName+"//"+password+"//"+mail+"//"+profile+"//"+photoUrl;
		//System.out.println(string);
		//System.out.println(id);
		return "";
    }
    
    @RequestMapping(value="/profile")
    public String profile(){
    	
    	return "profile";
    }
}























