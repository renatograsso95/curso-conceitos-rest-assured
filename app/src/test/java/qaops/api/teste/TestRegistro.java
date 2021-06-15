package qaops.api.teste;

import org.apache.http.HttpStatus;
import org.junit.Test;
import qaops.api.dominio.Usuario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class TestRegistro extends TestBase {

    private static final String REGISTRAR_USUARIO_ENDPOINT = "/register";

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
}
