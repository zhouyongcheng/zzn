package cn.tradewin.angular.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.tapestry5.ioc.annotations.Inject;

import cn.tradewin.angular.persist.model.Account;
import cn.tradewin.angular.persist.services.AccountService;

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
	
	@Inject
	private AccountService accountService;
	
	@GET
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@POST
	public int create(Account account) {
		return accountService.addAccount(account);
	}
	
	@GET
	@Path("{id}")
	public Account detail(@PathParam("id") String id) {
		return accountService.findAccount(id);
	}
	
	@DELETE
	@Path("{id}")
	public int delete(@PathParam("id") String id) {
		return accountService.delAccount(id);
	}
	
	@PUT
	@Path("{id}")
	public int update(Account account) {
		return accountService.updAccount(account);
	}
}