package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.Bean.ApplicationBean;
import com.Bean.ClgadminBean;
import com.Bean.Selected_studentsBean;

/**
 * Servlet implementation class SubadminServlet
 */
public class SubadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubadminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationBean applicationbean = new ApplicationBean();
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		String varname = request.getParameter("varname");
		if (varname.equals("applicant_review")) {

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8012/Student_admission/webapi/myresource1/review_applications/"
							+ request.getSession().getAttribute("college_code"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<ApplicationBean>> gType = new GenericType<ArrayList<ApplicationBean>>() {
			};
			ArrayList<ApplicationBean> reviewlist = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Applicant_review.jsp");
			request.setAttribute("applicantreview", reviewlist);
			dispatch.forward(request, response);
		}

		else if (varname.equals("confirm_students")) {
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource1/confirm/"
					+ request.getSession().getAttribute("college_code"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<ApplicationBean>> gType = new GenericType<ArrayList<ApplicationBean>>() {
			};
			ArrayList<ApplicationBean> reviewlist = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Confirm.jsp");
			request.setAttribute("confirm", reviewlist);
			dispatch.forward(request, response);
		}

		else if (varname.equals("accept")) {
			String applicant_no1 = request.getParameter("applicant_no");
			int applicant_no = Integer.valueOf(applicant_no1);
			String name = request.getParameter("name");
			String percentage1 = request.getParameter("percentage");
			int percentage = Integer.valueOf(percentage1);
			String dept_choice = request.getParameter("dept_choice");
			String college_ch1 = request.getParameter("college_ch1");

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource1/accept/"
					+ applicant_no1 + "/" + request.getSession().getAttribute("college_code"));
			Response status = webTarget.request(MediaType.APPLICATION_JSON).get();
			out.println(status);

		} else if (varname.equals("reject")) {
			String applicant_no1 = request.getParameter("applicant_no");
			int applicant_no = Integer.valueOf(applicant_no1);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8012/Student_admission/webapi/myresource1/reject/"
					+ applicant_no1 + "/" + request.getSession().getAttribute("college_code"));
			Response status = webTarget.request(MediaType.APPLICATION_JSON).get();

			String name = request.getParameter("name");

			out.println(name + "  rejected");
		} else if (varname.equals("name")) {
			response.sendRedirect("name.jsp");

		} else if (varname.equals("stud_ofgiven_dept")) {
			String dept = request.getParameter("alloted");
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8012/Student_admission/webapi/myresource1/stud_ofgiven_dept/"
							+ request.getSession().getAttribute("college_code") + "/" + dept);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<Selected_studentsBean>> gType = new GenericType<ArrayList<Selected_studentsBean>>() {
			};
			ArrayList<Selected_studentsBean> deptList = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Stud_ofgiven_dept.jsp");
			request.setAttribute("studentsOfGivenDepartment", deptList);
			dispatch.forward(request, response);
		} else if (varname.equals("selected_students")) {
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8012/Student_admission/webapi/myresource1/selected_list/"
							+ request.getSession().getAttribute("college_code"));
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<Selected_studentsBean>> gType = new GenericType<ArrayList<Selected_studentsBean>>() {
			};
			ArrayList<Selected_studentsBean> deptList = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Selected_studentsList.jsp");
			request.setAttribute("selected_list", deptList);
			dispatch.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
