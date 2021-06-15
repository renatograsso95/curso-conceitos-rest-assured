package qaops.api.teste;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import qaops.api.dominio.Usuario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class RegistroTeste extends BaseTeste{


    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando(){
        Usuario usuario = new Usuario();
        usuario.setEmail("sydney@fife");

       given().
                    body(usuario)
                .when()
                    .post("/register")
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).
                    body("error", is("Missing password"));
    }
}
