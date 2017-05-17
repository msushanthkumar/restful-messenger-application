package org.msk.advance.messenger.resources;

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

import org.msk.advance.messenger.model.Message;
import org.msk.advance.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageservice = new MessageService();
	
	@GET
	public List<Message> getMessages(){
		return messageservice.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return messageservice.getMessage(id);
	}
	
	@POST
		
	public Message addMessage(Message message){
			return messageservice.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);	
		return messageservice.updateMessage(message);
	}

	@DELETE
	public Message deleteMessage(@PathParam("messageId") long id){
			return messageservice.removeMessage(id);
	}

}

 