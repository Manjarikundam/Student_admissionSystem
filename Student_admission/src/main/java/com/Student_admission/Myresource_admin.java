package com.Student_admission;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Bean.ApplicationBean;
import com.Bean.ClgadminBean;
import com.Bean.LoginBean;
import com.Bean.Selected_studentsBean;
import com.Bean.SubadBean;
import com.DAO.AdminDao;

@Path("myresource1")
public class Myresource_admin {

	@GET
	@Path("admin_insert/{clgcode}/{clgname}/{adminname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String admininsertInfo(@PathParam("clgcode") String clgcode, @PathParam("clgname") String clgname,
			@PathParam("adminname") String adminname) throws ClassNotFoundException, SQLException {
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

		String result = new AdminDao().insert(clgbean);
		return result;

	}

	@Path("view_admins")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ClgadminBean> reviewadminInfo(ClgadminBean clgbean) {

		ArrayList<ClgadminBean> result = new AdminDao().review_admins();

		return result;

	}

	@Path("review_applications/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ApplicationBean> applicant_review(ApplicationBean applicationbean,
			@PathParam("code") String code) {

		ArrayList<ApplicationBean> result = new AdminDao().review_applications(code);

		return result;

	}

	@Path("selected_students_ofchoice/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Selected_studentsBean> selected_ofchoice(ApplicationBean applicationbean,
			@PathParam("code") String code) {

		ArrayList<Selected_studentsBean> result = new AdminDao().selected_ofchoice(code);

		return result;

	}

	@Path("confirm/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ApplicationBean> confirm(ApplicationBean applicationbean, @PathParam("code") String code) {

		ArrayList<ApplicationBean> result = new AdminDao().confirm(code);

		return result;

	}

	@Path("accept/{applicant_no}/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String accept(@PathParam("applicant_no") String applicant_no, @PathParam("code") String code) {
		String result = new AdminDao().accept(applicant_no, code);

		return result;

	}

	@Path("stud_ofgiven_dept/{code}/{dept}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Selected_studentsBean> selected_studof_givendept(@PathParam("code") String code,
			@PathParam("dept") String dept) {

		ArrayList<Selected_studentsBean> result = new AdminDao().Stud_ofgiven_dept(code, dept);

		return result;

	}

	@Path("selected_list/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Selected_studentsBean> selected_studList(@PathParam("code") String code) {

		ArrayList<Selected_studentsBean> result = new AdminDao().selected_list(code);

		return result;

	}

	@Path("reject/{applicant_no}/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String reject(@PathParam("applicant_no") String applicant_no, @PathParam("code") String code) {
		String result = new AdminDao().reject(applicant_no, code);

		return result;

	}

}
