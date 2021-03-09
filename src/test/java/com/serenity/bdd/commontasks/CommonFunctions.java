package com.serenity.bdd.commontasks;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class CommonFunctions {

  @Step("Verify that API response is {0}")
  public void responseCodeIs(int responseCode, Response lastResponse) {
    assertThat(lastResponse.statusCode()).isEqualTo(responseCode);
    System.out.println("Status Line:"+lastResponse.getStatusLine());
    System.out.println("Response Body"+lastResponse.asString());
  }

  @Step("Verify that response is empty list")
  public void responseShouldBeEmptyList(Response lastResponse) {
    assertThat(lastResponse.getBody().jsonPath().getList("").size()).isEqualTo(0);
  }

  @Step("Verify that response is not empty list")
  public void responseShouldNotBeEmptyList(Response lastResponse) {
    assertThat(lastResponse.getBody().jsonPath().getList("").size()).isNotEqualTo(0);
  }
  @Step("Verify response schema with {1}")
  public void verifyResponseSchema(Response lastResponse, String schemaJson) {
    lastResponse.then().body(matchesJsonSchemaInClasspath("schema/" + schemaJson));
  }
  
  @Step("Verify response key with value")
  public void verifyResponseValue(String key, String value, Response lastResponse) {
	  String resp= lastResponse.asString();
      JsonPath jsonPath=new JsonPath(resp);
      System.out.println("Json Value:"+jsonPath.get(key).toString().replaceAll("(^\\[|\\]$)", ""));
      assertThat(jsonPath.get(key).toString().replaceAll("(^\\[|\\]$)", "").equalsIgnoreCase(value));
  }
  
  @Step("Get Number/Integer from response")
  public String getInt(Response userDetailResp, String num ) {
    return String.valueOf(userDetailResp.getBody().jsonPath().getInt("[0]."+num));
  }

  @Step("Get string from response")
  public String getString(Response userDetailResp, String str) {
    return (userDetailResp.getBody().jsonPath().getString("[0]."+str));
  }

  @Step("Validate string {0} present in response")
  public void validateUserName(String key, String strText, Response lastResponse) {
	System.out.println("Username "+getString(lastResponse, key)+ strText);
    assertThat(getString(lastResponse, key )).isEqualToIgnoringCase(strText);
  }
}
