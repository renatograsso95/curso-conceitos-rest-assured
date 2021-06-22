package qaops.api.dominio;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties( ignoreUnknown = true )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @JsonAlias( "first_name" )
    private String name;
    @JsonAlias( "last_name" )
    private String lastName;
    private String job;
    private String email;


}