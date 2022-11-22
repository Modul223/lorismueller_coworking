package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.*;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthenticateService {

  @Inject
  UserService userService;

  public Response auth(Credential credential) {
    Optional<User> client = userService.findWithEmail(credential.getEmail());
  
    try {
      if (client.isPresent() && client.get().getPassword().equals(credential.getPassword())) {
        String token = Jwt
            .issuer("https://zli.example.com/")
            .upn(credential.getEmail())
            .groups(new HashSet<>(Arrays.asList("Member", "Admin")))
            .expiresIn(Duration.ofHours(24))
            .sign();
        return Response
            .ok(client.get())
            .cookie(new NewCookie("coworking", token))
            .header("Authorization", "Bearer" + token)
            .build();
      }
    } catch (Exception exception) {
      System.err.println("Could not validate passowrd!");
    }
  
    return Response.status(Response.Status.FORBIDDEN).build();
  }
  
}
