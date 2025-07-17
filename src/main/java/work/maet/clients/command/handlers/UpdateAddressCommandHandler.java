package work.maet.clients.command.handlers;

import work.maet.clients.command.commands.UpdateAddressCommand;
import work.maet.clients.repository.ClientRepository;

public class UpdateAddressCommandHandler {
    private final ClientRepository clientRepository;

    public UpdateAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void Handle(UpdateAddressCommand command) {
        var client = clientRepository.findById(command.clientId()).orElseThrow();
        var address = client.getAddresses().stream()
                .filter( a -> a.getId().equals(command.AddressId()))
                .findFirst()
                .orElseThrow();

        address.setLine1(command.line1());
        address.setLine2(command.line2());
        address.setPostalCode(command.postalCode());
        address.setCity(command.city());
        address.setCountry(command.country());
        clientRepository.save(client);
    }
}
