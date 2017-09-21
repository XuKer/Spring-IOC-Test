package com.xuke.ioc;

import org.junit.Test;

public class XukeTest {
	@Test
	public void testbook(){
		BookService bookService=new BookService();
		bookService.storeBook("spring.ioc");
	}


}
