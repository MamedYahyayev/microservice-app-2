package az.maqa.microservices.controller;

import az.maqa.microservices.dto.TicketDTO;
import az.maqa.microservices.request.RequestTicket;
import az.maqa.microservices.response.ResponseTicket;
import az.maqa.microservices.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.lang.reflect.Type;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final ModelMapper modelMapper;

    @GetMapping
    public Page<ResponseTicket> getAllTickets(Pageable pageable) {
        Page<TicketDTO> tickets = ticketService.getPagination(pageable);
        Type listType = new TypeToken<Page<ResponseTicket>>() {
        }.getType();
        return modelMapper.map(tickets, listType);
    }

    @GetMapping("/{id}")
    public ResponseTicket getTicketById(@PathVariable String id) {
        TicketDTO tickets = ticketService.getById(id);
        return modelMapper.map(tickets, ResponseTicket.class);
    }

    @PostMapping
    public ResponseTicket createTicket(@RequestBody RequestTicket requestTicket) {
        TicketDTO tickets = ticketService.save(requestTicket);
        return modelMapper.map(tickets, ResponseTicket.class);
    }

    @PutMapping("/{id}")
    public ResponseTicket updateTicket(@RequestBody RequestTicket requestTicket, @PathVariable String id) {
        TicketDTO tickets = ticketService.update(requestTicket, id);
        return modelMapper.map(tickets, ResponseTicket.class);
    }
}
