package az.maqa.microservices.client;

import az.maqa.microservices.contract.ResponseAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @RequestMapping(value = "/account/{id}")
    ResponseAccount retrieveAccountById(@PathVariable("id") String id);

}
