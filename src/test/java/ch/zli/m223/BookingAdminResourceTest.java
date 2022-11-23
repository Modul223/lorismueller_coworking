package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookingAdminResourceTest {

  @Test
  @TestSecurity(user = "testAdmin", roles = { "Admin" })
  public void testAdminBookingControllerGetEndpoint() {
    given()
        .when().get("/bookings")
        .then()
        .statusCode(200);
  }

  @Test
  @TestSecurity(user = "testAdmin", roles = { "Member" })
  public void testAdminBookingControllerGetEndpointUnauthorized() {
    given()
        .when().get("/bookings")
        .then()
        .statusCode(403);
  }

  @Test
  @TestSecurity(user = "testAdmin", roles = "Admin")
  public void testAdminBookingControllerDelete() {
    given()
      .when().delete("bookings/" + 2L)
      .then()
        .statusCode(204);
  }


}
