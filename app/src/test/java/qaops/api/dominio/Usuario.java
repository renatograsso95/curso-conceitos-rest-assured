package qaops.api.dominio;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

    @JsonAlias("first_name")
    private String name;
    @JsonAlias("last_name")
    private String lastName;
    private String job;
    private String email;

    public Usuario() {

    }

    public Usuario(String name, String job, String email) {
        this.name = name;
        this.job = job;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getter é usado para serielizacao transformando um objeto em um json
    public String getLastName() {
        return lastName;
    }


    //Setter é usado para deserielizacao transformando um json em objeto
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
