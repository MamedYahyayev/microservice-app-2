package az.maqa.microservices.repository;

import az.maqa.microservices.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findAllByActive(Boolean active);

    Account getById(String id);


}
