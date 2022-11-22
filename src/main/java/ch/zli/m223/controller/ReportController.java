package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Report;
import ch.zli.m223.service.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/reports")
@Tag(name = "Report", description = "Posting of reports")
public class ReportController {

  @Inject
  ReportService reportService;
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Creates a new report.", description = "Creates a new report and returns the newly added report.")
  public Report createReport(Report report) {
    return reportService.createReport(report);
  }
  
}
