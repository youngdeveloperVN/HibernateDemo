package com.vn.main;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import com.vn.entity.Category;
import com.vn.entity.Product;
import com.vn.entity.ProductAndCategory;
import com.vn.ulti.HibernateUtil;

public class ProductMain {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	private static Logger logger = LoggerFactory.logger(ProductMain.class);

	public static void main(String[] args) {

		List<ProductAndCategory> products = report("C2", 1, 3);
		if(products != null) {
			products.forEach(e -> {
				logger.info(e);
			});
		}

	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static List<Product> getAllProduct(String name, int pageNumber, int pageSize) {
		Session session = null;
		List<Product> result = null;
		try {
			session = factory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
			Root<Product> root = criteria.from(Product.class);

			if (name!= null && !name.isBlank()) {
				criteria.where(builder.like(root.get("name"), "%" + name + "%"));
			}
			
			Query q = session.createQuery(criteria);
			q.setFirstResult((pageNumber - 1) * pageSize);
			q.setMaxResults(pageSize);

			result = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	
	private static List<ProductAndCategory> report(String name, int pageNumber, int pageSize) {
		Session session = null;
		try {
			session = factory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<ProductAndCategory> criteria = builder.createQuery(ProductAndCategory.class);
			
			Root<Product> rootP = criteria.from(Product.class);
			Root<Category> rootC = criteria.from(Category.class);
			criteria.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"), rootC.get("name").alias("categoryName"));
			//JOIN
			criteria.where(builder.equal(rootP.get("category"), rootC.get("id")));
			
			if (name!= null && !name.isBlank()) {
				criteria.where(builder.like(rootP.get("name"), "%" + name + "%"));
			}
			
			Query q = session.createQuery(criteria);
			q.setFirstResult((pageNumber - 1) * pageSize);
			q.setMaxResults(pageSize);
			List<ProductAndCategory> result = q.getResultList();
			
			logger.info(result.size());

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

}
