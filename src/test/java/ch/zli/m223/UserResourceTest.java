package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResourceTest {

  @Test
  public void testUserEndpointPost() {
    given().contentType(ContentType.JSON)
        .body(
            "{\"firstname\":\"test\",\"lastname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
        .when().post("http://localhost:8080/users")
        .then()
        .statusCode(200);
  }

  @Test
  @TestSecurity(user = "testUser", roles = "Admin")
  public void testUserEndpointPut() {
    given()
        .contentType(ContentType.JSON)
        .body(
          "{\"firstname\":\"max\",\"lastname\":\"mustermann\",\"email\":\"test@test.test\",\"password\":\"1234\",\"role\":{\"id\":2}}")
          .when().put("/users/" + 2L)
        .then()
        .statusCode(200);
  }

  @Test
  @TestSecurity(user = "testUser", roles = "Member")
  public void testUserEndpointDeleteUnknownUser() {
    given()
      .when().delete("users/" + 1L)
      .then()
        .statusCode(403);
  }
  
}
