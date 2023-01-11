package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    //This test are for store
    @WithTags({
            @WithTag("feature:SMOKE"),
            @WithTag("feature:NEGATIVE")
    })
    @Title("Provide a 500 status code when incorrect HTTP method is used to access resource for product api")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/product")
                .then()
                .statusCode(500)
                .log().all();
    }

    @WithTags({
            @WithTag("feature:SMOKE"),
            @WithTag("feature:POSITIVE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request for product api")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTags({
            @WithTag("feature:SMOKE"),
            @WithTag("feature:NEGATIVE")
    })
    @Title("This test will provide an error code of 404 when user tries to access an invalid resource for product api")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/products123")
                .then()
                .statusCode(404)
                .log().all();
    }

    //This test are for store
    @WithTags({
            @WithTag("feature:SANITY"),
            @WithTag("feature:NEGATIVE")
    })
    @Title("Provide a 500 status code when incorrect HTTP method is used to access resource for store api")
    @Test
    public void invalidMethod1() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/store")
                .then()
                .statusCode(500)
                .log().all();
    }

    @WithTags({
            @WithTag("feature:SANITY"),
            @WithTag("feature:POSITIVE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request for store api")
    @Test
    public void verifyIfTheStatusCode200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/stores")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTags({
            @WithTag("feature:SANITY"),
            @WithTag("feature:NEGATIVE")
    })
    @Title("This test will provide an error code of 404 when user tries to access an invalid resource for store api")
    @Test
    public void inCorrectResource1() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/stores123")
                .then()
                .statusCode(404)
                .log().all();
    }
}
