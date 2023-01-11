package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.model.StorePojo;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class bestbuyStoreEndPointSteps {
    static ValidatableResponse response;
    static int id;
    static String name = "MineMona";
    static String type = "BigBox2";
    static String address = "20 Coventry";
    static String address2 = "CV 20";
    static String city = "Coventry";
    static String state = "Birmingham";
    static String zip = "54505";
    static int lat = 44;
    static int lng = 45;
    static String hours ="Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";
    private StorePojo.Services services;

    @Steps
    StoreSteps storeSteps;
    @When("^User sends a GET request to stores endpoint$")
    public void userSendsAGETRequestToStoresEndpoint() {
        response = storeSteps.getAllStoreInfo();
    }

    @When("^User sends a POST request by providing the information to stores endpoint$")
    public void userSendsAPOSTRequestByProvidingTheInformationToStoresEndpoint() {
        response = storeSteps.createStore(name, type, address,address2, city, state, zip, lat, lng, hours,services);
        id = response.extract().path("id");
    }

    @Then("^User must get back valid status code 201 for post request$")
    public void userMustGetBackValidStatusCodeForPostRequest() {
        response.statusCode(201);
    }

    @When("^User sends a PUT request by providing the information to stores/id endpoint$")
    public void userSendsAPUTRequestByProvidingTheInformationToStoresIdEndpoint() {
        name = name + "_Updated";
        response = storeSteps.updateStore(id,name, type, address,address2, city, state, zip, lat, lng, hours,services);
    }

    @When("^User sends a DELETE request to stores/id endpoint$")
    public void userSendsADELETERequestToStoresIdEndpoint() {
        storeSteps.deleteStore(id);
    }
}
