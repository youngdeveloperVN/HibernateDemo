package com.vn.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.entity.Category;
import com.vn.entity.Product;
import com.vn.ulti.HibernateUtil;

public class CategoryMain {
	
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	
	public static void main(String[] args) {
		
		Category category = new Category();
		category.setName("Category");

		//todo set list product
		category.setProducts(new ArrayList<Product>());
		
		
		Product product = new Product();
		product.setName("PRODUC1");
		product.setPrice(10.02);
		product.setCategory(category);
		
		Product product2 = new Product();
		product2.setName("PRODUC2");
		product2.setPrice(12.02);
		product2.setCategory(category);
		
		category.getProducts().add(product);
		category.getProducts().add(product2);

		List<Category>  list = getAllCategory();
		
		list.forEach(e -> {
			System.out.println(e);
		});
		
		createCategory(category);
		
	}
	
	private static void createCategory(Category category){
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(category);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null) {
				try {
					tx.rollback();
				} catch (IllegalStateException ex) {
					ex.printStackTrace();
				}
			}
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	private static List<Category> getAllCategory(){
		Session session = null;
		try {
			session = factory.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<Category> query = session.createQuery("FROM Category");
			List<Category> result = query.getResultList();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return null;
	}

}
