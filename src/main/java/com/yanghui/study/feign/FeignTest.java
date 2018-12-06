package com.yanghui.study.feign;

import feign.Body;
import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.Request;
import feign.Request.Options;
import feign.RequestLine;
import feign.gson.GsonEncoder;
import feign.hystrix.HystrixFeign;
import lombok.Data;

public class FeignTest {
	
	static final Request.Options DEFAULT_OPTIONS = new Request.Options();
	
	interface BookService{
		@RequestLine("GET /book/borrow?name={name}&timeout={timeout}")
		String borrow(@Param("name")String name,@Param("timeout")Integer timeout);
//		
		@RequestLine("POST /book/post")
		@Headers("Content-Type: application/json")
		@Body("%7B\"id\": \"{id}\", \"name\": \"{name}\"%7D")
		String post(@Param("id")String id,@Param("name")String name);
//		
//		@RequestLine("POST /book/post1")
//		@Headers("Content-Type: application/json")
//		String post1(Book book);
		
//		@RequestLine("POST /book/form")
//		@Headers("Content-Type: application/json")
//		String form(@Param("id")String id,@Param("name") String name);
	}
	@Data
	static class Book{
		private String id;
		private String name;
	}

	public static void main(String[] args) {
//		normal();
		Request.Options o = new Options();
		System.out.println(o);
		System.out.println(DEFAULT_OPTIONS);
	}
	
//	private static void hystrix() {
//		try {
//			BookService bs = HystrixFeign.builder().options(new Options(2000, 2000))
//				.target(BookService.class, "http://localhost:2002");
//			String result = bs.borrow("Hystrix",3);
//			System.out.println(result);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		try {
//			Thread.sleep(60000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	private static void normal() {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
		BookService bs = Feign.builder()
				.encoder(new GsonEncoder())
				.options(new Options(2000, 6000))
				.responseInterceptors(new MyResponseInterceptorImpl())
				.target(BookService.class, "http://localhost:2002");
		
		String result1 = bs.borrow("kkkk",1);
		System.out.println(result1);
//		
//		String result2 = bs.post("12345", "spring feign");
//		System.out.println(result2);
		
//		Book book = new Book();
//		book.setId("21");
//		book.setName("yanghui");
//		String result3 = bs.post1(book);
//		System.out.println(result3);
		
//		String result4 = bs.form("12", "zengchang");
//		System.out.println(result4);
	}
}
