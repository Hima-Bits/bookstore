package com.example.bookstore.Repository;

import com.example.bookstore.DAO.DAO;
import com.example.bookstore.Model.Book;
import com.example.bookstore.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repository {
	@Autowired
private DAO dao;

	public Result create(Book book) {
		long id=getTimeStamp();
		book=new Book(book,id);
		dao.save(book);
		List<Book> list=new ArrayList<Book>();
		list.add(book);
		return getResult(list);
	}
	public Result getAllBooks(){
		return  getResult(dao.getAll());
	}
	public Result getBook(long id) {
		Book b=dao.getBook(id);

		List<Book> list=new ArrayList<Book>();
		if(b!=null)
		list.add(b);
		return getResult(list);
	}
	public Result getBookbyName(String name) {
		if(name!=null)
		return getResult(dao.getBookByName(name));
		else {
			return getResult("failure","please provide name of book");
		}
	}
	public Result deleteBook(long id) {
		Book b=dao.deleteBook(id);
		List<Book> list=new ArrayList<Book>();
		if(b!=null)
		list.add(b);
		return getResult(list);
	}
	
	public Result updateBook(Book book) {
		System.out.println("Book in repo"+book);
		Book b=dao.UpadteBook(book);
		List<Book> list=new ArrayList<Book>();
		if(b!=null) {
			list.add(b);
		}
		return getResult(list);
	}
	
	private long getTimeStamp(){
		return System.currentTimeMillis();
	}
	private Result getResult(List<Book> list) {
		Result l=new Result();
		if(list.size()>0) {
		l.setResult("success");
		l.setStatus("OK");
		}
		else {
			l.setResult("failure");
			l.setStatus("No book found");
			return l;
		}
		l.getMap().put("data", list);
		return l;
	}
	public Result getResult(String result,String status) {
		Result l=new Result();
		l.setResult(result);
		l.setStatus(status);
		return l;
	}
}
