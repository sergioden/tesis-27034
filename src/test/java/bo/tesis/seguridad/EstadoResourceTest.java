package bo.tesis.seguridad;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class EstadoResourceTest {

    @Test
    void devuelveEstadoOperativo() {
        given()
            .when().get("/api/v1/estado")
            .then()
                .statusCode(200)
                .contentType("application/json")
                .body("servicio", is("api-seguridad"))
                .body("estado", is("OPERATIVO"));
    }

    @Test
    void exponeReadiness() {
        given()
            .when().get("/q/health/ready")
            .then()
                .statusCode(200)
                .body("status", is("UP"));
    }
}
