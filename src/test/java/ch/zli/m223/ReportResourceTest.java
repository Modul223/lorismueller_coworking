package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ReportResourceTest {

  @Test
  @TestSecurity(user = "testUser", roles = "Admin")
  public void testReportEndpointPost() {
    given().contentType(ContentType.JSON)
        .body(
            "{\"message\":\"wackelkontakt\",\"date\":\"2022-12-14\",\"user\":{\"id\":2}}")
        .when().post("/reports")
        .then()
        .statusCode(200);
  }

  @Test
  public void testReportEndpointPostUnautorized() {
    given().contentType(ContentType.JSON)
        .body(
            "{\"message\":\"wackelkontakt\",\"date\":\"2022-12-14\",\"user\":{\"id\":2}}")
        .when().post("/reports")
        .then()
        .statusCode(401);
  }

  @Test
  @TestSecurity(user = "testUser", roles = "Admin")
  public void testReportEndpointPostInvalidUser() {
    given().contentType(ContentType.JSON)
        .body(
            "{\"message\":\"wackelkontakt\",\"date\":\"2022-12-14\",\"user\":{\"id\":132423}}")
        .when().post("/reports")
        .then()
        .statusCode(500);
  }

  
}
