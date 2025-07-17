package work.maet.clients.command.handlers;

import work.maet.clients.command.commands.UpdateClientCommand;
import work.maet.clients.repository.ClientRepository;

public class UpdateClientCommandHandler {
    private final ClientRepository clientRepository;

    public UpdateClientCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void Handle(UpdateClientCommand command) {
        var client = clientRepository.findById(command.clientId()).orElseThrow();
        client.setFirstName(command.firstName());
        client.setLastName(command.lastName());
        client.setPhoneNumber(command.phoneNumber());
        client.setEmail(command.email());
        clientRepository.save(client);
    }
}
