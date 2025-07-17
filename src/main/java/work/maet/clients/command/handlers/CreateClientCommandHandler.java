package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.CreateClientCommand;
import work.maet.clients.models.Client;
import work.maet.clients.repository.ClientRepository;

@Component
public class CreateClientCommandHandler {

    private ClientRepository clientRepository;

    public CreateClientCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(CreateClientCommand command) {
        var client = Client.builder()
                .firstName(command.firstName())
                .lastName(command.lastName())
                .nationalId(command.nationalId())
                .email(command.email())
                .phoneNumber(command.phoneNumber())
                .build();
        clientRepository.save(client);
    }
}
