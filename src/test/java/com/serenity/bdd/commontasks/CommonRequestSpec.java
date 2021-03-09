package com.serenity.bdd.commontasks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class CommonRequestSpec {
  /**
   * Get Request Specification for endpoint Api
   *
   * @return RequestSpecification
   */
  public static RequestSpecification xkcdReqSpec() {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
        .getInstance(EnvironmentVariables.class);

    String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
        .getProperty("baseurl");
    System.out.println("BaseUrl ANY API:"+ baseUrl);

    return new RequestSpecBuilder().setBaseUri(baseUrl)
        .setContentType(ContentType.JSON)
        .build();
  }
}
