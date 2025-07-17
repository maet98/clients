package work.maet.clients.query.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.models.Client;
import work.maet.clients.query.queries.GetClientByIdQuery;
import work.maet.clients.repository.ClientRepository;

@Component
public class GetClientByIdQueryHandler {
    private final ClientRepository clientRepository;

    public GetClientByIdQueryHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client Handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + query.clientId()));
    }
}
