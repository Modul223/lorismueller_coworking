package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookingMemberResourceTest {

  @Test
  @TestSecurity(user = "testUser", roles = { "Member" })
  public void testBookingMemberControllerGetByIdEndpoint() {
    given()
        .when().get("member/bookings/" + 1L)
        .then()
        .statusCode(200);
  }

  @Test
  public void testBookingMemberControllerGetByIdEndpointUnauthorized() {
    given()
        .when().get("member/bookings/" + 1L)
        .then()
        .statusCode(401);
  }

  @Test
  @TestSecurity(user = "testMember", roles = "Member")
  public void testBookingMemberControllerDelete() {
    given()
      .when().delete("member/bookings/" + 1L)
      .then()
        .statusCode(204);
  }


}
