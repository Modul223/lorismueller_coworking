package ch.zli.m223.controller;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/member/bookings")
@Tag(name = "Bookings for Members", description = "Handling of bookings for members")
public class MemberBookingController {

  @Inject
  BookingService bookingService;

  
  @POST
  @RolesAllowed({"Member"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added booking.")
  public Booking createBooking(Booking booking) {
    return bookingService.createBooking(booking);
  }

  @Path("/{id}")
  @GET
  @RolesAllowed({"Member"})
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Find Booking from Member by id", description = "Returns a booking from member with the given id.")
  public Booking findBookingbyId(@PathParam("id") Long id) {
    return bookingService.getBooking(id);
  }

  @Path("/{id}")
  @DELETE
  @RolesAllowed({"Member"})
  @Operation(summary = "Deletes a booking.", description = "Deletes a booking by its id.")
  public void deleteBooking(@PathParam("id") Long id) {
    bookingService.deleteBooking(id);
  }

}
