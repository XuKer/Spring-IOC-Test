package com.xuke.ioc;

 
import java.util.Map;
 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookService {
	 IBookDAO iBookDAO;
	 Map<String,IBookDAO> map;
	 public  BookService(){
	      ApplicationContext ctx=new ClassPathXmlApplicationContext("/com/xuke/service/iocbean.xml");
		 iBookDAO=(IBookDAO) ctx.getBean("bookdao");
		 map= ctx.getBeansOfType(IBookDAO.class);
		 
	 }
	 public void storeBook(String bookname){
		 System.out.println("Begin!!!");
		 //根据beanID获取对象
		 System.out.println(map.get("bookdao").addBook("sping.io"));
		 //从map集合获取bean
		 for(String key:map.keySet()){
			System.out.println(key+":"+ map.get(key).addBook("springmvc"));
		 }
		 String result=iBookDAO.addBook(bookname);
		 System.out.println(result);
		 BookDAO bookDao=(BookDAO) map.get("bookdao");
		 BookDAO2 bookDao2=(BookDAO2) map.get("bookdao2");
		 System.out.println(bookDao.addBook("gitHub"));
		 System.out.println(bookDao2.addBook("git"));
	 }

}
