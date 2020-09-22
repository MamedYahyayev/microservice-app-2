package az.maqa.microservices.request;

import lombok.Data;

import java.util.Date;

@Data
public class RequestAccount {

    private String name;

    private String surname;

    private String username;

    private String password;

    private String email;

    private Date birthDate;
}
