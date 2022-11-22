package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Credential;
import ch.zli.m223.service.AuthenticateService;

@Path("/authentication")
@Tag(name = "Authentication", description = "Handling of the Authentication")
@PermitAll
public class AuthenticateController {
  
  @Inject
  AuthenticateService authservice;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
    summary = "Authenticate a user / login.",
    description = "Return token when successful authenticated"
  )
  public Response create(@Valid Credential credential) {
    return this.authservice.auth(credential);
  }
}
