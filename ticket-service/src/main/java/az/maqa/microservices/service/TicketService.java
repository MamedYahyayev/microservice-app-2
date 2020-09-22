package az.maqa.microservices.service;

import az.maqa.microservices.dto.TicketDTO;
import az.maqa.microservices.request.RequestTicket;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface TicketService {

    TicketDTO save(RequestTicket requestTicket);

    TicketDTO update(RequestTicket requestTicket , String id);

    TicketDTO getById(String id);

    Page<TicketDTO> getPagination(Pageable pageable);


}
