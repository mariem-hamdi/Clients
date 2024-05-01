
package BookTrainSimple.vente.en.ligne;



import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;





@Path("/clients")
public class MyResource {
    ClientBD clientbd =new ClientBD();
    
    @GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Client> getClients()
	{
		return clientbd.getClients();
	}
    
    
    @GET
	@Path("/client/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Client getClient(@PathParam("id")int id) 
	{
		return clientbd.getClients(id);
	}
	
	@POST
	@Path("/client")
	@Produces(MediaType.APPLICATION_XML)
	public Client createClient(Client c1) {
		System.out.println(c1);
		clientbd.create(c1);
		return c1;
	}
	
	@PUT
	@Path("/client")
	@Produces(MediaType.APPLICATION_XML)
	public Client updateTrain(Client c1) {
		System.out.println(c1);
		if(clientbd.getClients(c1.getId()).getId()==0) 
		{
			clientbd.create(c1);
			return c1;
		}
		else
		{
			clientbd.update(c1);
			return c1;
		}
	
	}
	
	@DELETE
	@Path("/51236")
	@Produces(MediaType.APPLICATION_XML)
	public Client killTrain(Client c1) 
	{
		Client c =clientbd.getClients(51236);
		if (c.getId()!=0) {
		clientbd.delete(51236);
		}
		return c1;
	}
	
	
	
}
