package work.maet.clients.command.handlers;

import work.maet.clients.command.commands.AddAddressCommand;
import work.maet.clients.models.Address;
import work.maet.clients.repository.ClientRepository;

public class AddAddressCommandHandler {

    private final ClientRepository clientRepository;
    private CreateClientCommandHandler command;

    public AddAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(AddAddressCommand command) {
        var client = clientRepository.findById(command.clientId()).orElseThrow();

        var address = Address.builder()
                .line1(command.line1())
                .line2(command.line2())
                .city(command.city())
                .postalCode(command.postalCode())
                .country(command.country())
                .build();
        client.getAddresses().add(address);
        clientRepository.save(client);
    }
}
