package az.maqa.microservices.service.impl;

import az.maqa.microservices.client.AccountServiceClient;
import az.maqa.microservices.contract.ResponseAccount;
import az.maqa.microservices.dto.TicketDTO;
import az.maqa.microservices.entity.PriorityType;
import az.maqa.microservices.entity.Ticket;
import az.maqa.microservices.entity.TicketStatus;
import az.maqa.microservices.entity.es.TicketModel;
import az.maqa.microservices.repository.TicketRepository;
import az.maqa.microservices.repository.es.TicketElasticRepository;
import az.maqa.microservices.request.RequestTicket;
import az.maqa.microservices.service.TicketNotificationService;
import az.maqa.microservices.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;


@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository elasticRepository;
    private final ModelMapper modelMapper;
    private final AccountServiceClient accountServiceClient;
    private final TicketNotificationService ticketNotificationService;

    @Override
    @Transactional
    public TicketDTO save(RequestTicket requestTicket) {
        TicketDTO ticketDTO = modelMapper.map(requestTicket, TicketDTO.class);

        Ticket ticket = new Ticket();

        ticket = saveTicketToMySQL(ticketDTO, ticket);

        saveTicketToElasticSearch(ticketDTO, ticket);

        ticketNotificationService.sendToQueue(ticket);

        return modelMapper.map(ticket, TicketDTO.class);
    }


    @Override
    public TicketDTO update(RequestTicket requestTicket, String id) {
        return null;
    }

    @Override
    public TicketDTO getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDTO> getPagination(Pageable pageable) {
        return null;
    }


    private Ticket saveTicketToMySQL(TicketDTO ticketDTO, Ticket ticket) {
        ResponseAccount account = accountServiceClient.retrieveAccountById(ticketDTO.getAssignee());
        log.info("Account: " + account);
        if (ticketDTO.getDescription() == null)
            throw new IllegalStateException("Description can not be null");

        ticket.setDescription(ticketDTO.getDescription());
        ticket.setNotes(ticketDTO.getNotes());
        ticket.setTicketDate(ticketDTO.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDTO.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDTO.getPriorityType()));
        ticket.setAssignee(account.getId());

        ticket = ticketRepository.save(ticket);
        return ticket;
    }

    private void saveTicketToElasticSearch(TicketDTO ticketDTO, Ticket ticket) {
        ResponseAccount account = accountServiceClient.retrieveAccountById(ticketDTO.getAssignee());
        TicketModel ticketModel = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(account.getFullName())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        elasticRepository.save(ticketModel);
    }

}
