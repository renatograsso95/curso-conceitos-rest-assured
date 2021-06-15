package qaops.api.teste;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import qaops.api.dominio.Usuario;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

public class RegistroTeste {

    @BeforeClass
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }
    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando(){
        Usuario usuario = new Usuario();
        usuario.setEmail("sydney@fife");
       given().
                contentType(ContentType.JSON).
                    body(usuario)
                .when()
                    .post("/register")
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).
                    body("error", is("Missing password"));
    }
}
