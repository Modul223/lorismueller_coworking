package ch.zli.m223.controller;

import javax.annotation.security.RolesAllowed;
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

  // Registrierung von neuem User
  // Erstellen von neuem Mitglied -> durch Administrator
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Creates a new user.", description = "Creates a new user and returns the newly added user.")
  public User create(User user) {
    return userService.createUser(user);
  }

  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Find User by id", description = "Returns a user with the given id.")
  public User findUserbyId(@PathParam("id") Long id) {
    return userService.getUser(id);
  }

  @Path("/{id}")
  @DELETE
  @Operation(summary = "Deletes an user.", description = "Deletes an user by its id.")
  public void delete(@PathParam("id") Long id) {
    userService.deleteUser(id);
  }

  @Path("/{id}")
  @PUT
  @Operation(summary = "Updates an user.", description = "Updates an user by its id.")
  public User update(@PathParam("id") Long id, User user) {
    return userService.updateUser(id, user);
  }

}
