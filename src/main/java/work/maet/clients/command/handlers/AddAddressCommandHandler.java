package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.AddAddressCommand;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.models.Address;
import work.maet.clients.repository.ClientRepository;

@Component
public class AddAddressCommandHandler {

    private final ClientRepository clientRepository;

    public AddAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(AddAddressCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + command.clientId()));

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
