package work.maet.clients.controller.query;

import org.springframework.web.bind.annotation.*;
import work.maet.clients.mapper.ClientMapper;
import work.maet.clients.models.Client;
import work.maet.clients.query.handlers.GetClientByIdQueryHandler;
import work.maet.clients.query.handlers.GetClientsQueryHandler;
import work.maet.clients.query.queries.GetClientByIdQuery;
import work.maet.clients.query.queries.GetClientsQuery;
import work.maet.clients.response.ClientResponse;
import work.maet.clients.response.PaginationResponse;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientQueryController {
    private final GetClientsQueryHandler getClientsQueryHandler;
    private final GetClientByIdQueryHandler getClientByIdQueryHandler;

    public ClientQueryController(
            GetClientsQueryHandler getClientsQueryHandler,
            GetClientByIdQueryHandler getClientByIdQueryHandler
    ) {
        this.getClientByIdQueryHandler = getClientByIdQueryHandler;
        this.getClientsQueryHandler = getClientsQueryHandler;
    }

    @GetMapping("/{id}")
    private ClientResponse getClientById(@PathVariable Long id) {
        var query = new GetClientByIdQuery(id);
        var client = getClientByIdQueryHandler.Handle(query);
        return ClientMapper.toResponse(client);
    }

    @GetMapping("")
    private PaginationResponse<Client> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "0") int pageNumber
    ) {
        var query = new GetClientsQuery(name, pageNumber);
        var clients = getClientsQueryHandler.Handle(query);
        return new PaginationResponse<>(
                clients.getContent(),
                clients.getTotalElements(),
                clients.getNumber(),
                clients.getTotalPages()
        );
    }

}
