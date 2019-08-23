package com.Student_admission;



import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.Bean.ApplicationBean;
import com.Bean.ClgadminBean;
import com.Bean.LoginBean;
import com.DAO.AdminDao;
import com.DAO.LoginDao;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	
	@GET
	@Path("insert/{appno}/{name}/{password}/{board}/{perc}/{gpa}/{school}/{dept}/{college_ch1}/{college_ch2}/pending")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String applicantInfo(@PathParam("appno") int applicant_no, @PathParam("name") String name, @PathParam("password") String password,
			@PathParam("board") String board, @PathParam("perc") int perc, @PathParam("gpa") String gpa,
			@PathParam("school") String school, @PathParam("dept") String dept, @PathParam("college_ch1") String college_ch1,@PathParam("college_ch2") String college_ch2)
			throws ClassNotFoundException, SQLException {
		
		ApplicationBean applicationbean = new ApplicationBean();
		applicationbean.setApplicant_no(applicant_no);
		applicationbean.setName(name);
		applicationbean.setPassword(password);
		applicationbean.setBoard(board);
		applicationbean.setPercentage(perc);
		applicationbean.setGpa(gpa);
		applicationbean.setSchool_name(school);
		applicationbean.setDept_choice(dept);
		applicationbean.setCollege_ch1(college_ch1);
		applicationbean.setCollege_ch2(college_ch2);
		applicationbean.setStatus("pending");

		
		LoginBean loginbean=new LoginBean();
		loginbean.setName(applicationbean.getName());
		loginbean.setPassword(applicationbean.getPassword());
		loginbean.setRole("user");
		
		
		String result=new LoginDao().insert(applicationbean);
		//out.println("applied successfully");
			return result;
		
		}

	
	

	@POST
	@Path("edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String edit(ApplicationBean applicationbean) {
		String result=new LoginDao().edit(applicationbean);
			return result;
		}


	
	
	@Path("viewstatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<ApplicationBean> user( ApplicationBean applicationbean) {

		ArrayList<ApplicationBean> result = new LoginDao().viewstatus(applicationbean);

		return result;

	}
	
	

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getIt(LoginBean loginbean) {

		
		
		String result = new LoginDao().check(loginbean);
		return result;
	
	}
	
	@GET
	@Path("getclgnames")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClgadminBean> getNamesList(){
		return LoginDao.getNameslist();
	}

	
}
