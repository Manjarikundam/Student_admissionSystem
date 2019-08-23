package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.Bean.ApplicationBean;
import com.Bean.LoginBean;
import com.Bean.SubadBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Servlett")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String varname = request.getParameter("varname");
		PrintWriter out = response.getWriter();

		if (varname.equals("login")) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");

			LoginBean loginbean = new LoginBean();
			loginbean.setName(name);
			loginbean.setPassword(password);

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource/login");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.post(Entity.entity(loginbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			String[] values = status.split(",", 2);

			String role = values[0];
			String code = values[1];
			if (role.equals("error")) {
				response.sendRedirect("");
			} else if (role.equals("subadmin")) {
				request.getSession().setAttribute("college_code", code);
				response.sendRedirect("SubadminFunctions.jsp");

			} else if (role.equals("admin")) {
				response.sendRedirect("AdminFunctions.jsp");

			} else if (role.equals("user")) {

				ApplicationBean applicationbean = new ApplicationBean();
				applicationbean.setName(name);
				applicationbean.setStatus(status);
				Client client1 = ClientBuilder.newClient(new ClientConfig());
				WebTarget webTarget1 = client
						.target("http://localhost:8012/Student_admission/webapi/myresource/viewstatus");
				Invocation.Builder invocationBuilder1 = webTarget1.request(MediaType.APPLICATION_JSON);
				Response clientResponse1 = invocationBuilder1
						.post(Entity.entity(applicationbean, MediaType.APPLICATION_JSON));
				GenericType<ArrayList<ApplicationBean>> gType = new GenericType<ArrayList<ApplicationBean>>() {
				};

				session.setAttribute("name", loginbean.getName());
				ArrayList<ApplicationBean> list1 = clientResponse1.readEntity(gType);
				for (int i = 0; i < list1.size(); i++) {
					if ((list1.get(i).getStatus().equals("pending")) || (list1.get(i).getStatus().equals("accepted"))) {
						RequestDispatcher dispatch = request.getRequestDispatcher("UserFunctions.jsp");
						request.setAttribute("view_details", list1);
						dispatch.forward(request, response);
					} else {

						RequestDispatcher dispatch = request.getRequestDispatcher("editFunctions.jsp");
						request.setAttribute("view_details", list1);
						dispatch.forward(request, response);
					}

				}
			}

		}

		else if (varname.equals("insert")) {

			int applicant_no = Integer.parseInt(request.getParameter("applicant_no"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String board = request.getParameter("board");
			String p = request.getParameter("percentage");
			int percentage = Integer.parseInt(p);
			String gpa = request.getParameter("gpa");
			String school_name = request.getParameter("school_name");
			String dept_choice = request.getParameter("dept_choice");
			String college_ch1 = request.getParameter("college_ch1");
			String college_ch2 = request.getParameter("college_ch2");

			ApplicationBean applicationbean = new ApplicationBean();
			applicationbean.setApplicant_no(applicant_no);
			applicationbean.setName(name);
			applicationbean.setPassword(password);
			applicationbean.setBoard(board);
			applicationbean.setPercentage(percentage);
			applicationbean.setGpa(gpa);
			applicationbean.setSchool_name(school_name);
			applicationbean.setDept_choice(dept_choice);
			applicationbean.setCollege_ch1(college_ch1);
			applicationbean.setCollege_ch2(college_ch2);
			applicationbean.setStatus("pending");

			LoginBean loginbean = new LoginBean();
			loginbean.setName(applicationbean.getName());
			loginbean.setPassword(applicationbean.getPassword());
			loginbean.setRole("user");

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource/insert/"
					+ applicant_no + "/" + name + "/" + password + "/" + board + "/" + percentage + "/" + gpa + "/"
					+ school_name + "/" + dept_choice + "/" + college_ch1 + "/" + college_ch2 + "/pending");
			Response result = webTarget.request(MediaType.APPLICATION_JSON).get();
			out.println("applied successfully");
		} else if (varname.equals("edit")) {
			String name = (String) session.getAttribute("name");
			String dept_choice = request.getParameter("dept_choice");
			String college_ch1 = request.getParameter("college_ch1");
			ApplicationBean applicationbean = new ApplicationBean();
			applicationbean.setDept_choice(dept_choice);
			applicationbean.setCollege_ch1(college_ch1);
			applicationbean.setName(name);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource/edit");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder
					.post(Entity.entity(applicationbean, MediaType.APPLICATION_JSON));
			String status = clientResponse.readEntity(String.class);
			out.println(status);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
