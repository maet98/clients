package work.maet.clients.command.handlers;

import org.springframework.stereotype.Component;
import work.maet.clients.command.commands.UpdateAddressCommand;
import work.maet.clients.exception.NoFoundEntityException;
import work.maet.clients.repository.ClientRepository;

@Component
public class UpdateAddressCommandHandler {
    private final ClientRepository clientRepository;

    public UpdateAddressCommandHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void handle(UpdateAddressCommand command) {
        var client = clientRepository.findById(command.clientId())
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find client with id: " + command.clientId()));
        var address = client.getAddresses().stream()
                .filter( a -> a.getId().equals(command.addressId()))
                .findFirst()
                .orElseThrow(() -> new NoFoundEntityException("Couldn't find address with id: " + command.addressId()));

        address.setLine1(command.line1());
        address.setLine2(command.line2());
        address.setPostalCode(command.postalCode());
        address.setCity(command.city());
        address.setProvince(command.province());
        address.setCountry(command.country());
        clientRepository.save(client);
    }
}
