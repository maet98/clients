package work.maet.clients.command.handlers;

import work.maet.clients.command.commands.DeleteClientCommand;
import work.maet.clients.repository.ClientRepository;

public class DeleteClientCommandHandler {
    private ClientRepository clientRepository;

    public DeleteClientCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(DeleteClientCommand command) {
        var client = clientRepository.findById(command.clientId()).orElseThrow();
        clientRepository.delete(client);
    }
}