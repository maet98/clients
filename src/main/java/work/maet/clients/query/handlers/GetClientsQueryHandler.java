package work.maet.clients.query.handlers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import work.maet.clients.models.Client;
import work.maet.clients.query.queries.GetClientsQuery;
import work.maet.clients.repository.ClientRepository;

@Component
public class GetClientsQueryHandler {
    private final ClientRepository clientRepository;
    private final int DEFAULT_PAGINATION_SIZE = 20;

    public GetClientsQueryHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Page<Client> Handle(GetClientsQuery query) {
        var pageable = PageRequest.of(query.pageNumber(), DEFAULT_PAGINATION_SIZE);
        return this.clientRepository.search(query.name(), pageable);
    }
}
