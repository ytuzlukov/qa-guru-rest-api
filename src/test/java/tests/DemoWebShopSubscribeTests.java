package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemoWebShopSubscribeTests {
    String emailForPositiveSubscribe = "test@yandex.ru";

    @Test
    void positiveSubscribeTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("email=" + emailForPositiveSubscribe)
                .when()
                .post("http://demowebshop.tricentis.com/subscribenewsletter")
                .then()
                .statusCode(200)
                .body("Success", is(true))
                .body("Result", is("Thank you for signing up!" +
                                            " A verification email has been sent." +
                                            " We appreciate your interest."));
        /*
    Unirest.setTimeouts(0, 0);
HttpResponse<String> response = Unirest.post("http://demowebshop.tricentis.com/subscribenewsletter")
  .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
  .header("Cookie", "Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; __utmc=78382081; __utmz=78382081.1652111417.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utma=78382081.950524802.1652111417.1652111417.1652117417.2; __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=53&RecentlyViewedProductIds=26&RecentlyViewedProductIds=48&RecentlyViewedProductIds=14; __atuvc=14%7C19; __atuvs=62794faee524826600b; __utmb=78382081.25.10.1652117417; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c")
  .body("email=test%40yandex.ru")
  .asString();

     */
    }
}
