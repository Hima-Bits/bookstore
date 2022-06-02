package com.example.bookstore.DAO;

import com.example.bookstore.Model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class DAO {
public static ArrayList<Book> list;
public DAO(){
	list=new ArrayList<Book>();
}
public void save(Book book) {
	list.add(book);
}
public List<Book> getAll(){
	return list;
}
public Book getBook(long id) {
	
	for(Book b:list) {
		if(id==b.getId()) {
			return b;
		}
	}
	return null;
}
public Book deleteBook(long id) {
	for(Book b:list) {
		if(id==b.getId()) {
			list.remove(b);
			return b;
		}
	}
	return null;
}
public List<Book> getBookByName(String name){
	List<Book> l=new ArrayList<Book>();
	for(Book b:list) {
		if(b!=null && b.getBookName().toLowerCase().equals(name.toLowerCase())) {
			l.add(b);
		}
	}
	return l;
	
}
public Book UpadteBook(Book book) {
	System.out.println(list);
	System.out.println(book);
	int flag=0;
	Book tempBook = null;
	for(Book b:list) {
		System.out.println("book+"+b);
		if(b.getId()==book.getId()) {
			flag=1;
			tempBook=b;
			System.out.println("saksham");
			break;
		}
	}
	if(flag==1) {
		list.remove(tempBook);
		list.add(book);
		return book;
	}
	else {
		return null;
	}
}
}
