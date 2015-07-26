package cn.tradewin.angular.ws.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import cn.tradewin.angular.persist.model.Account;

@Path("/demos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

	@GET
	@Path("{id}")
	public Response getAccount(@PathParam("id") String id) {
		Account a = new Account();
		a.setId("101");
		a.setEmail("zhouyc@tradewin.cn");
		ResponseBuilder builder = Response.ok(a);
		builder.language("en").header("content-type", "application/json");
		return builder.build();
	}
}
