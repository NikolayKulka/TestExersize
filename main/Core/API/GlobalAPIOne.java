package Core.API;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class GlobalAPIOne {


	public Response ApiGet(String url) {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target(url);
		Response response  = webResource.request(MediaType.APPLICATION_JSON_TYPE).get();
		response.bufferEntity();
		System.out.println("POST STATUS GlobalAPI: " + response.getStatus());
		return response;
	}


}