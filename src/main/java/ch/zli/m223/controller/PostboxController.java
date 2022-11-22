package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.PostOfficeBox;
import ch.zli.m223.service.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/postboxes")
@Tag(name = "Postbox", description = "managing of Postboxes.")
public class PostboxController {

  @Inject
  PostboxService postboxService;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Creates a new postbox.", description = "Creates a new postbox and returns the newly added postbox.")
  public PostOfficeBox createReport(PostOfficeBox postbox) {
    return postboxService.createPostbox(postbox);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Index all postboxes.", description = "Returns a list of all postboxes.")
  public List<PostOfficeBox> index() {
    return postboxService.findPostOfficeBoxes();
  }

}
