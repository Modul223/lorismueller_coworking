package ch.zli.m223;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AuthorizationResourceTest {

  /*
   * @Test
   * public void testRegisterEndpoint() {
   * var role = new Role();
   * role.setType("Member");
   * role.setId(1L);
   * 
   * var user = new User();
   * user.setEmail("test@test.ch");
   * user.setFirstname("Max");
   * user.setLastname("Mustermann");
   * user.setPassword("12345");
   * user.setRole(role);
   * 
   * given()
   * .contentType(ContentType.JSON)
   * .body(user)
   * .when().post("/users")
   * .then()
   * .statusCode(201);
   * 
   * }
   */

  @Test
  public void testRegisterEndpoint() {
    given().contentType(ContentType.JSON)
        .body(
            "{\"firstname\":\"test\",\"lastname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
        .when().post("http://localhost:8080/users")
        .then()
        .statusCode(200);
  }

  @Test
  public void testLoginEndpoint() {

    given().contentType(ContentType.JSON)
        .body(
            "{\"email\":\"davidbucher@gmail.com\",\"password\":\"1234\"}")
        .when().post("http://localhost:8080/authentication")
        .then()
        .statusCode(200);
  }

  @Test
  public void testLoginEndpointFailed() {
    
    given().contentType(ContentType.JSON)
        .body(
            "{\"email\":\"false@test.test\",\"password\":\"4321\"}")
        .when().post("http://localhost:8080/authentication")
        .then()
        .statusCode(403);
  }

}
