package work.maet.clients.query.handlers;

import work.maet.clients.models.Client;
import work.maet.clients.query.queries.GetClientByIdQuery;
import work.maet.clients.repository.ClientRepository;

public class GetClientByIdQueryHandler {
    private final ClientRepository clientRepository;

    public GetClientByIdQueryHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client Handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.clientId()).orElseThrow();
    }
}
