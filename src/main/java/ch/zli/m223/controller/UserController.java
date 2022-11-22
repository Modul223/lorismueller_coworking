package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.User;
import ch.zli.m223.service.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {

  @Inject
  UserService userService;

  //Registrierung von neuem User
  //Erstellen von neuem Mitglied -> durch Administrator
  @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new user.", 
        description = "Creates a new user and returns the newly added user."
    )
    public User create(User user) {
       return userService.createUser(user);
    }

}
