package qaops.api.teste;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import qaops.api.dominio.Usuario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class TestRegistro extends TestBase {

    private static final String REGISTRAR_USUARIO_ENDPOINT = "/register";
    private static final String LOGIN_USUARIO_ENDPOINT = "/login";

    @BeforeClass
    public static void setupRegistro(){
        RestAssured.responseSpecification = new ResponseSpecBuilder()
              .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }

    //Esse teste deveria estar no teste login, porém esta aqui para mostrar a funcionalidade de multiplos setuups e ResponseSpec
    @Test
    public void testeNaoEfetuaRegistroQuandoSenhaEstaFaltando(){
        Usuario usuario = new Usuario();
        usuario.setEmail("sydney@fife");

       given().
                    body(usuario)
                .when()
                    .post(REGISTRAR_USUARIO_ENDPOINT)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).
                    body("error", is("Missing password"));
    }

    @Test
    public void testeLoginNaoEfetuadoQuandoASenhaEstaFaltando(){
        Usuario usuario = new Usuario();
        usuario.setEmail("sydney@fife");

        given().
                body(usuario)
                .when()
                .post(LOGIN_USUARIO_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST).
                body("error", is("Missing password"));
    }
}
