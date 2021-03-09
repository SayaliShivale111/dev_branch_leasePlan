package com.serenity.bdd.api.response;

import com.serenity.bdd.commontasks.CommonRequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class XkcdResponse {

  @Step("Get response of xkcd info json")
  public Response getResponse(String title) {
    return SerenityRest.given().spec(CommonRequestSpec.xkcdReqSpec())
        .basePath("info.0.json")
        .queryParam("title", title)
        .get().then().extract().response();
  }
  
  @Step("Get response non existing data of xkcd info json")
  public Response getNonResponse(String strNon) {
    return SerenityRest.given().spec(CommonRequestSpec.xkcdReqSpec())
    		.basePath(strNon+"/info.0.json")
        .get().then().extract().response();
  }
}
