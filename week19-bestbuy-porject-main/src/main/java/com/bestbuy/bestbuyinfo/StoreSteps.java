package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StorePojo;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoreSteps extends TestUtils {
    @Step("Creating student with name : {0}, type: {1}, address: {2}, address2: {3} , city: {4}, state: {5}, zip: {6}, lat:{7},lng:{8}, hours:{9}")
    public ValidatableResponse createStore(String name, String type, String address,
                                           String address2, String city, String state, String zip, int lat, int lng, String hours,StorePojo.Services services) {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        StorePojo.Services service = new StorePojo.Services();
        service.setServices(services);

        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(storePojo)
                .when()
                .post(EndPoints.CREATE_STORES)
                .then().log().all();
    }

    @Step("Getting the store information with id: {0}")
    public  ValidatableResponse getStoreInfoById(int id){
        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Accept", "application/json")
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_STORES_BY_ID)
                .then().log().all();
    }

    @Step("Getting the store information with id: {0}")
    public  ValidatableResponse getAllStoreInfo(){
        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_STORES)
                .then().log().all();
    }

    @Step("Creating student with name : {0}, type: {1}, address: {2}, address2: {3} , city: {4}, state: {5}, zip: {6}, lat:{7},lng:{8}, hours:{9}")
    public ValidatableResponse updateStore(int id,String name, String type, String address,
                                           String address2, String city, String state, String zip, int lat, int lng, String hours,StorePojo.Services services) {
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        StorePojo.Services service = new StorePojo.Services();
        service.setServices(services);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id",id)
                .body(storePojo)
                .when()
                .put(EndPoints.UPDATE_STORES_BY_ID)
                .then().log().all();
    }

    @Step("Deleting store information with id: {0}")
    public ValidatableResponse deleteStore(int id){
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_STORES_BY_ID)
                .then();
    }
}
