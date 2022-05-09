package tests;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.is;

public class DemoWebShopTests {

    @Test
    void addToCartAsNewUserTest() {
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body("product_attribute_72_5_18=53" +
                                "&product_attribute_72_6_19=54" +
                                "&product_attribute_72_3_20=57" +
                                "&addtocart_72.EnteredQuantity=1")
                        .when()
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("(1)"));
        /*
        Unirest.setTimeouts(0, 0);
    HttpResponse<String> response = Unirest.post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
    .header("Cookie", "Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; __utma=78382081.950524802.1652111417.1652111417.1652111417.1; __utmc=78382081; __utmz=78382081.1652111417.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __utmb=78382081.4.10.1652111417; __atuvc=2%7C19; __atuvs=627939891b4ff85f001; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c")
    .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
    .asString();

                 */
    }

    @Test
    void addToCartWithCookieTest() {
        Integer cartSize = 0;
        ValidatableResponse response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c;" +
                                " ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687;")
                        .body("product_attribute_72_5_18=53" +
                                "&product_attribute_72_6_19=54" +
                                "&product_attribute_72_3_20=57" +
                                "&addtocart_72.EnteredQuantity=1")
                        .when()
                        .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));

//        assertThat(response.extract().path("updatetopcartsectionhtml").toString())
//                .body("updatetopcartsectionhtml", is("(11)"));
//
//        System.out.println(response);

        /*
        Unirest.setTimeouts(0, 0);
    HttpResponse<String> response = Unirest.post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
    .header("Cookie", "Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; __utma=78382081.950524802.1652111417.1652111417.1652111417.1; __utmc=78382081; __utmz=78382081.1652111417.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __utmb=78382081.4.10.1652111417; __atuvc=2%7C19; __atuvs=627939891b4ff85f001; ARRAffinity=1818b4c81d905377ced20e7ae987703a674897394db6e97dc1316168f754a687; Nop.customer=bd23a250-da6f-46b9-84ea-16166af02d5c")
    .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
    .asString();

                 */
    }
}
