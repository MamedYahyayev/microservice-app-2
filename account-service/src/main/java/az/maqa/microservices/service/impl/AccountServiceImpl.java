package az.maqa.microservices.service.impl;

import az.maqa.microservices.enums.ActiveDeActiveStatus;
import az.maqa.microservices.dto.AccountDTO;
import az.maqa.microservices.entity.Account;
import az.maqa.microservices.repository.AccountRepository;
import az.maqa.microservices.service.AccountService;
import az.maqa.microservices.request.RequestAccount;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> accounts = accountRepository.findAllByActive(ActiveDeActiveStatus.ACTIVE.getStatus());
        Type listType = new TypeToken<List<AccountDTO>>() {
        }.getType();
        return modelMapper.map(accounts, listType);
    }

    @Override
    public AccountDTO getAccountById(String id) {
        Account account = accountRepository.getById(id);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public AccountDTO addAccount(RequestAccount requestAccount) {
        Account account = modelMapper.map(requestAccount, Account.class);
        account.setBirthDate(new Date());
        account.setCreatedAt(new Date());
        account.setActive(true);
        Account savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDTO.class);
    }

    @Override
    public AccountDTO updateAccount(RequestAccount requestAccount, String id) {
        Account account = modelMapper.map(requestAccount, Account.class);
        account.setId(id);
        Account savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDTO.class);
    }
}
