package az.maqa.microservices.service;

import az.maqa.microservices.dto.AccountDTO;
import az.maqa.microservices.request.RequestAccount;

import java.util.List;


public interface AccountService {

    List<AccountDTO> getAllAccount();

    AccountDTO getAccountById(String id);

    AccountDTO addAccount(RequestAccount requestAccount);

    AccountDTO updateAccount(RequestAccount requestAccount, String id);
}
