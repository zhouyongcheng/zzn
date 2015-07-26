package cn.tradewin.angular.ws.resource;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileResource {
	
	private static final String FILE_TXT = "/home/cmwin/downloads/file.txt";
	private static final String FILE_PDF = "/home/cmwin/downloads/file.pdf";
	private static final String FILE_IMG = "/home/cmwin/downloads/file.img";
	private static final String FILE_XLS = "/home/cmwin/downloads/file.xls";
	
	
	@GET
	@Path("txt")
	@Produces(MediaType.TEXT_PLAIN)
	public Response downloadTxt() {
		File f = new File(FILE_TXT);
		ResponseBuilder response = Response.ok((Object)f);
		response.header("Content-Disposition", "attachement; filename=\"server_file.txt\"");
		return response.build();
	}
	
	@GET
	@Path("pdf")
	@Produces("application/pdf")
	public Response downloadPdf() {
		File f = new File(FILE_PDF);
		ResponseBuilder response = Response.ok((Object)f);
		response.header("Content-Disposition", "attachement; filename=\"server_file.pdf\"");
		return response.build();
	}
	
	@GET
	@Path("pdf")
	@Produces("image/png")
	public Response downloadImg() {
		File f = new File(FILE_PDF);
		ResponseBuilder response = Response.ok((Object)f);
		response.header("Content-Disposition", "attachement; filename=\"server_file.pdf\"");
		return response.build();
	}
	
	
	
}
