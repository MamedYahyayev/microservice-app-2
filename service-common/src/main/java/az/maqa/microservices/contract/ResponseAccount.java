package az.maqa.microservices.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccount {

    private String id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private Date birthDate;


    public String getFullName() {
        return this.name + " " + this.surname;
    }

}

