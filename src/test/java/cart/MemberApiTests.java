package cart;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static cart.ProductTestStep.상품_전체목록_조회;
import static org.assertj.core.api.Assertions.assertThat;

class MemberApiTests extends AcceptanceTest{
    @DisplayName("회원목록 조회")
    @Test
    public void getMembers() {
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/members/allMembers")
                .then().log().all()
                .extract();


        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
