package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.DeleteClientCommand;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.repository.ClientRepository;

@Component
public class DeleteClientCommandHandler {
    private ClientRepository clientRepository;

    public DeleteClientCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(DeleteClientCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + command.clientId()));
        clientRepository.delete(client);
    }
}