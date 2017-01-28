package cz.ucl.jee.storage;

import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cz.ucl.jee.storage.entities.Item;

@Path("/storage")
public class StorageService {

	@Inject
	StorageDAO dao;
	
	@POST
	@Path("/item")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String storeItem(Item item){
		item.setStorageDate(new Date());
		dao.storeItem(item);		
		return "OK";
	}
	
}
