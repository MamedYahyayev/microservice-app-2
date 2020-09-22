package az.maqa.microservices.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private Date createdAt;

    private Date updatedAt;

}
