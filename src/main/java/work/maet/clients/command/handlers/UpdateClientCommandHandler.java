package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.UpdateClientCommand;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.repository.ClientRepository;

@Component
public class UpdateClientCommandHandler {
    private final ClientRepository clientRepository;

    public UpdateClientCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(UpdateClientCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + command.clientId()));
        client.setFirstName(command.firstName());
        client.setLastName(command.lastName());
        client.setPhoneNumber(command.phoneNumber());
        client.setEmail(command.email());
        clientRepository.save(client);
    }
}
