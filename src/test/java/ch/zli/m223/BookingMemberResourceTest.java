package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class BookingMemberResourceTest {

  @Test
  @TestSecurity(user = "testMember", roles = { "Member" })
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
