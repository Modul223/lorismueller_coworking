package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.*;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of bookings")
public class BookingController {

  @Inject
  BookingService bookingService;

  
  @POST
  @RolesAllowed({"Admin"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added user.")
  public Booking createBooking(Booking booking) {
    return bookingService.createBooking(booking);
  }

  @Path("/{id}")
  @GET
  @RolesAllowed({"Admin"})
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Find Booking by id", description = "Returns a booking with the given id.")
  public Booking findBookingbyId(@PathParam("id") Long id) {
    return bookingService.getBooking(id);
  }

  @GET
  @RolesAllowed({"Admin"})
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Find all Booking", description = "Returns all bookings in a List.")
  public List<Booking> findBookings() {
    return bookingService.findAll();
  }

  @Path("/{id}")
  @DELETE
  @RolesAllowed({"Admin"})
  @Operation(summary = "Deletes a booking.", description = "Deletes a booking by its id.")
  public void deleteBooking(@PathParam("id") Long id) {
    bookingService.deleteBooking(id);
  }

  @Path("/{id}")
  @PUT
  @RolesAllowed({"Admin"})
  @Operation(summary = "Updates an booking.", description = "Updates an bookoing by its id.")
  public Booking updateBooking(@PathParam("id") Long id, Booking booking) {
    return bookingService.updateBooking(id, booking);
  }

}
