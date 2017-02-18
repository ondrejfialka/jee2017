package cz.ucl.jee.storage;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cz.ucl.jee.storage.entities.Item;
import cz.ucl.jee.storage.entities.ItemFilter;

@Path("/storage")
public class StorageService {

	@Inject
	StorageDAO dao;
	
	@POST
	@Path("/items")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item storeItem(Item item){
		//POST stores the item with new unique code, ignore what the client sent
		item.setCode(null);
		item.setStorageDate(new Date());
		return dao.storeItem(item);	
		
	}	
	
	@PUT
	@Path("/items/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item storeItemGivenCode(@PathParam("code") Long code, Item item){
		item.setCode(null);
		item = dao.storeItem(item, code);		
		if (item == null){
			//Item with the specified code was not found - return 404
			throw new NotFoundException();
		}
		return item;
	}	
	
	@GET
	@Path("/items/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("code") Long code){
		return dao.getItem(code);
	}
	
	@GET
	@Path("/items")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItemsByFilter(
			@QueryParam("weightFrom") Double weightFrom,
			@QueryParam("weightTo") Double weightTo,
			@QueryParam("name") String name) {
		
		ItemFilter filter = new ItemFilter();
		filter.setWeightFrom(weightFrom);
		filter.setWeightTo(weightTo);
		filter.setName(name);
		return dao.getItemsByFilter(filter);
	}
	
	@DELETE
	@Path("/items/{code}")
	public Response removeItem(@PathParam("code") Long code){
		if (!dao.removeItem(code)){
			throw new NotFoundException();
		}
		
		return Response.noContent().build();
	}
}
