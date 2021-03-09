package com.serenity.bdd.stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import com.serenity.bdd.api.response.XkcdResponse;
import com.serenity.bdd.commontasks.CommonFunctions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GetXkcdInfoSteps 
{
	@Steps
	XkcdResponse xkcdResponse;
	
	@Steps
	CommonFunctions commonFunctions;
	
	@Given("I call the info json details endpoint for title {string}")
	public void i_call_the_info_json_details_endpoint_for_title(String string) {
	    // Write code here that turns the phrase above into concrete actions
		xkcdResponse.getResponse(string);
	}

	@When("title details should be retrieved")
	public void title_details_should_be_retrieved() {
	    // Write code here that turns the phrase above into concrete actions
		commonFunctions.responseCodeIs(200, lastResponse());
	}
	
	@When("I call the get num details endpoint for non-existent user {string}")
	public void i_call_the_get_num_details_endpoint_for_non_existent_user(String string) {
	    // Write code here that turns the phrase above into concrete actions
		xkcdResponse.getNonResponse(string);
	}

	@Then("title should be {string}")
	public void title_should_be(String title) {
	    // Write code here that turns the phrase above into concrete actions
		commonFunctions.verifyResponseValue("title",title, lastResponse());
	}

	@Then("empty or page not found response should be returned")
	public void empty_or_page_not_found_response_should_be_returned() {
	    // Write code here that turns the phrase above into concrete actions
		commonFunctions.responseCodeIs(404, lastResponse());
		//commonFunctions.responseShouldBeEmptyList(lastResponse());
	}
	
	@Then("the schema should match with the specification defined in {string}")
	public void the_schema_should_match_with_the_specification_defined_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
		commonFunctions.verifyResponseSchema(lastResponse(), string);
	}
}
