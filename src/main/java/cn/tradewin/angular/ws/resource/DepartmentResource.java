package cn.tradewin.angular.ws.resource;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.tapestry5.ioc.annotations.Inject;

import cn.tradewin.angular.persist.model.Department;
import cn.tradewin.angular.persist.services.DepartmentService;

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

	@Inject
	private DepartmentService departmentService;

	@GET
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

//	@GET
//	@Path("{id}")
//	public Department getDepartment(@PathParam("id") String id) {
//		Department d =  departmentService.findDepartment(new Byte(id));
//		if (d == null) {
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		}
//		return d;
//	}
	
	@GET
	@Path("{id}")
	public Response getDepartmentWithCache(@PathParam("id") String id) {
		System.out.println("====== step inot server method ======");
		Department d =  departmentService.findDepartment(new Byte(id));
		
		ResponseBuilder builder = Response.ok(d);
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		c.set(2015, 4, 2, 15, 0, 0);
		builder.expires(c.getTime());
		builder.header("Content-Type", "application/json");
		return builder.build();
		
	}

	@POST
	public Department addDepartment(Department department) {
		departmentService.addDepartment(department);
		return department;
	}

	@PUT
	@Path("{id}")
	public Department updDepartment(Department department) {
		departmentService.updDepartment(department);
		return department;
	}

	@DELETE
	@Path("{id}")
	public int delete(@PathParam("id") Byte id) {
		throw new WebApplicationException("error occurs");
//		return departmentService.delDepartment(id);
	}
}