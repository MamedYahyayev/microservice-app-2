package az.maqa.microservices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "created_at", columnDefinition = "timestamp default sysdate")
    private Date createdAt;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean active;


}
