package com.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Bean.AdminBean;
import com.Bean.ApplicationBean;
import com.Bean.ClgadminBean;
import com.Bean.LoginBean;
import com.Bean.SubadBean;

public class LoginDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_admission");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public String check(LoginBean loginbean) {
		String code = null;

		LoginBean loginbean1 = entityManager.find(LoginBean.class, loginbean.getName());
		String name = loginbean1.getName();
		String role = null;

		if (loginbean1.getName().equals(null))
			role = "error";

		if (loginbean1.getName().equals(loginbean.getName())
				&& loginbean1.getPassword().equals(loginbean.getPassword())) {
			if (loginbean1.getRole().equals("admin")) {
				role = "admin";
			} else if (loginbean1.getRole().equals("user")) {
				role = "user";
			} else if (loginbean1.getRole().equals("subadmin")) {
				code = entityManager.find(ClgadminBean.class, entityManager.find(SubadBean.class, name).getClgcode())
						.getClgcode();
				role = "subadmin";
			}

		}

		else {

			role = "wrong password";
		}
		return role + "," + code;

	}

	public String insert(ApplicationBean applicationbean) {

		applicationbean.getApplicant_no();
		applicationbean.getName();
		applicationbean.getPassword();
		applicationbean.getBoard();
		applicationbean.getPercentage();
		applicationbean.getGpa();
		applicationbean.getSchool_name();
		applicationbean.getDept_choice();
		applicationbean.getCollege_ch1();
		applicationbean.getCollege_ch2();
		applicationbean.getStatus();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_admission");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(applicationbean);

		LoginBean loginbean = new LoginBean();
		loginbean.getName();
		loginbean.getPassword();
		loginbean.getRole();
		loginbean.setName(applicationbean.getName());
		loginbean.setPassword(applicationbean.getPassword());
		loginbean.setRole("user");
		entityManager.persist(loginbean);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "student applied successfully";

	}

	public static ArrayList<ClgadminBean> getNameslist() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_admission");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<ClgadminBean> query = entityManager.createQuery("SELECT c FROM com.Bean.ClgadminBean c ",
				ClgadminBean.class);
		ArrayList<ClgadminBean> list = (ArrayList<ClgadminBean>) query.getResultList();

		return list;
	}

	public ArrayList<ApplicationBean> viewstatus(ApplicationBean applicationbean) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_admission");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String name = applicationbean.getName();
		entityManager.getTransaction().begin();
		String status = applicationbean.getStatus();

		TypedQuery<ApplicationBean> query = entityManager
				.createQuery("SELECT c FROM ApplicationBean c where c.name='" + name + "'", ApplicationBean.class);
		ArrayList<ApplicationBean> results = (ArrayList<ApplicationBean>) query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return results;

	}

	public String edit(ApplicationBean applicationbean) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student_admission");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT c FROM ApplicationBean c where name=:name",
				ApplicationBean.class);
		query.setParameter("name", applicationbean.getName());
		List<ApplicationBean> list = query.getResultList();
		ApplicationBean applicationbean1 = list.get(0);
		applicationbean1.setDept_choice(applicationbean.getDept_choice());
		applicationbean1.setCollege_ch1(applicationbean.getCollege_ch1());
		applicationbean1.setStatus("pending");
		entityManager.persist(applicationbean1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "student applied successfully";

	}

}
