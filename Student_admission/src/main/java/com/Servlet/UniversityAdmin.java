package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

import com.Bean.ClgadminBean;
import com.Bean.LoginBean;
import com.Bean.SubadBean;

/**
 * Servlet implementation class UniversityAdmin
 */

@WebServlet("/uniadmin")
public class UniversityAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UniversityAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		String varname = request.getParameter("varname");
		if (varname.equals("add_admins")) {
			String clgcode = request.getParameter("clgcode");
			String clgname = request.getParameter("clgname");
			String adminname = request.getParameter("adminname");

			ClgadminBean clgbean = new ClgadminBean();
			clgbean.setClgcode(clgcode);
			clgbean.setClgname(clgname);
			clgbean.setAdminname(adminname);

			SubadBean subbean = new SubadBean();
			subbean.setName(clgbean.getAdminname());
			subbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
			subbean.setClgcode(clgbean.getClgcode());

			LoginBean loginbean = new LoginBean();
			loginbean.setName(clgbean.getAdminname());
			loginbean.setPassword(clgbean.getClgcode() + clgbean.getClgname());
			loginbean.setRole("subadmin");

			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8012/Student_admission/webapi/myresource1/admin_insert/" + clgcode + "/"
							+ clgname + "/" + adminname);
			Response status = webTarget.request(MediaType.APPLICATION_JSON).get();
		} else if (varname.equals("viewadmins")) {
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8012/Student_admission/webapi/myresource1/view_admins");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

			Response clientResponse = invocationBuilder.get();
			GenericType<ArrayList<ClgadminBean>> gType = new GenericType<ArrayList<ClgadminBean>>() {
			};
			ArrayList<ClgadminBean> cadlist = clientResponse.readEntity(gType);
			RequestDispatcher dispatch = request.getRequestDispatcher("Review_admins.jsp");
			request.setAttribute("adminreview", cadlist);
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
