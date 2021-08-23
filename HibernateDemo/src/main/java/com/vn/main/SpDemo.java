package com.vn.main;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.query.NativeQuery;
import org.hibernate.result.UpdateCountOutput;

import com.vn.ulti.HibernateUtil;

public class SpDemo {
	
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		
		//call navtive SQL 
		callNative();
		callProcedureCall();
		
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void callNative() {
		Session session = null;
		try {
			session = factory.openSession();
			
			NativeQuery q = session.createNativeQuery("call selectProduct(?0)");
			/* q.setInteger("quantity", 11); */
			q.setParameter(0, 11);
			
			List result = q.getResultList();
			
			result.forEach(e -> {
				System.out.println(e);
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void callProcedureCall() {
		Session session = null;
		try {
			session = factory.openSession();
			
			ProcedureCall call = session.createStoredProcedureCall("selectProduct2");
			call.registerParameter("quantity", Integer.class, ParameterMode.IN);
			call.registerParameter("count", Integer.class, ParameterMode.OUT);
			call.getParameterRegistration("quantity").bindValue(11);
			
			ProcedureOutputs procedureOutputs = call.getOutputs();
			
			UpdateCountOutput resultSet  = (UpdateCountOutput)procedureOutputs.getCurrent();
			int count = (int) procedureOutputs.getOutputParameterValue("count");
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
}
