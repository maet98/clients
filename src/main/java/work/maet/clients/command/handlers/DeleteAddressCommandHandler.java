package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.DeleteAddressCommand;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.repository.ClientRepository;

@Component
public class DeleteAddressCommandHandler {
    private ClientRepository clientRepository;

    public DeleteAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(DeleteAddressCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + command.clientId()));
        client.getAddresses().removeIf((add) -> add.getId().equals(command.AddressId()));
        clientRepository.save(client);
    }
}
