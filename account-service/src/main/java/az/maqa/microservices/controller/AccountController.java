package az.maqa.microservices.controller;

import az.maqa.microservices.contract.ResponseAccount;
import az.maqa.microservices.dto.AccountDTO;
import az.maqa.microservices.request.RequestAccount;
import az.maqa.microservices.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<ResponseAccount> retrieveAllAccount() {
        List<AccountDTO> accounts = accountService.getAllAccount();
        Type listType = new TypeToken<List<ResponseAccount>>() {
        }.getType();
        return modelMapper.map(accounts, listType);

    }

    @GetMapping("/{id}")
    public ResponseAccount retrieveAccountById(@PathVariable("id") String id) {
        AccountDTO account = accountService.getAccountById(id);
        return modelMapper.map(account, ResponseAccount.class);
    }

    @PostMapping
    public ResponseAccount saveAccount(@RequestBody RequestAccount requestAccount) {
        AccountDTO accountDTO = accountService.addAccount(requestAccount);
        return modelMapper.map(accountDTO, ResponseAccount.class);
    }

    @PutMapping("/{id}")
    public ResponseAccount updateAccount(@PathVariable("id") String id, @RequestBody RequestAccount requestAccount) {
        AccountDTO accountDTO = accountService.updateAccount(requestAccount, id);
        return modelMapper.map(accountDTO, ResponseAccount.class);
    }

}
