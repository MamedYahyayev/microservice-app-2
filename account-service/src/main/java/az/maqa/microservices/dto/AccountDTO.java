package az.maqa.microservices.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDTO {

    private String id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private Date birthDate;

}
