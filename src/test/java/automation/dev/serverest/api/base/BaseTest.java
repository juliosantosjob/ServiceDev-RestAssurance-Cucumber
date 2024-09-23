package automation.dev.serverest.api.base;

import automation.dev.serverest.api.setupenv.Environment;
import automation.dev.serverest.api.setupenv.Routes;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest implements Constants {
    protected static RequestSpecification requester;
    protected String APP_BASE_URL = Environment.getBaseUrl();
    protected static String USERS = "/usuarios/";
    protected static String LOGIN = "/login/";

    @BeforeEach
    public void setupRestAssured() {
        requester = RestAssured.given()
                .baseUri(APP_BASE_URL)
                .header("Content-Type", Constants.CONTENT_TYPE);

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(Constants.MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig()
                        .enableLoggingOfRequestAndResponseIfValidationFails());
    }
}