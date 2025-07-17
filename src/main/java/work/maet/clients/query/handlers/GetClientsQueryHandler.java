package work.maet.clients.query.handlers;

import work.maet.clients.models.Client;
import work.maet.clients.query.queries.GetClientsQuery;
import work.maet.clients.repository.ClientRepository;

import java.util.List;

public class GetClientsQueryHandler {
    private final ClientRepository clientRepository;

    public GetClientsQueryHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(GetClientsQuery query) {
        return this.clientRepository.search(query.name());
    }
}
