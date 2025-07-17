package work.maet.clients.command.handlers;

import work.maet.clients.command.commands.DeleteAddressCommand;
import work.maet.clients.repository.ClientRepository;

public class DeleteAddressCommandHandler {
    private ClientRepository clientRepository;

    public DeleteAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(DeleteAddressCommand command) {
        var client = clientRepository.findById(command.clientId()).orElseThrow();
        client.getAddresses().removeIf((add) -> add.getId().equals(command.AddressId()));
        clientRepository.save(client);
    }
}
