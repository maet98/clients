package work.maet.clients.mapper;

import work.maet.clients.models.Client;
import work.maet.clients.response.ClientResponse;

public class ClientMapper {

    public static ClientResponse toResponse(Client client) {
        return new ClientResponse(
            client.getId(),
            client.getFirstName(),
            client.getLastName(),
            client.getPhoneNumber(),
            client.getEmail(),
            client.getNationalId(),
            client.getAddresses().stream().map(AddressMapper::toResponse).toList()
        );
    }
}
