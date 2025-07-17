package work.maet.clients.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import work.maet.clients.command.commands.*;
import work.maet.clients.command.handlers.*;
import work.maet.clients.controller.command.request.AddAddressRequest;
import work.maet.clients.controller.command.request.UpdateAddressRequest;
import work.maet.clients.controller.command.request.UpdateClientRequest;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientCommandController {

    private final CreateClientCommandHandler createClientCommandHandler;
    private final UpdateClientCommandHandler updateClientCommandHandler;
    private final DeleteClientCommandHandler deleteClientCommandHandler;

    private final AddAddressCommandHandler addAddressCommandHandler;
    private final UpdateAddressCommandHandler updateAddressCommandHandler;
    private final DeleteAddressCommandHandler deleteAddressCommandHandler;

    public ClientCommandController(
            CreateClientCommandHandler createClientCommandHandler,
            UpdateClientCommandHandler updateClientCommandHandler,
            DeleteClientCommandHandler deleteClientCommandHandler,
            AddAddressCommandHandler addAddressCommandHandler,
            UpdateAddressCommandHandler updateAddressCommandHandler,
            DeleteAddressCommandHandler deleteAddressCommandHandler
    ) {
        this.createClientCommandHandler = createClientCommandHandler;
        this.updateClientCommandHandler = updateClientCommandHandler;
        this.deleteClientCommandHandler = deleteClientCommandHandler;
        this.addAddressCommandHandler = addAddressCommandHandler;
        this.updateAddressCommandHandler = updateAddressCommandHandler;
        this.deleteAddressCommandHandler = deleteAddressCommandHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createClient(@RequestBody CreateClientCommand command) {
        createClientCommandHandler.handle(command);
    }

    @PostMapping("/{clientId}/address")
    @ResponseStatus(HttpStatus.CREATED)
    private void addAddress(
            @PathVariable Long clientId,
            @RequestBody AddAddressRequest request
    ) {
        var command = new AddAddressCommand(
                clientId,
                request.line1(),
                request.line2(),
                request.city(),
                request.postalCode(),
                request.province(),
                request.country()
        );
        addAddressCommandHandler.handle(command);
    }

    @PutMapping("/{id}")
    private void  updateClient(@PathVariable Long id, @RequestBody UpdateClientRequest request) {
        var command = new UpdateClientCommand(
                id,
                request.firstName(),
                request.lastName(),
                request.phoneNumber(),
                request.email()
        );
        updateClientCommandHandler.handle(command);
    }

    @PutMapping("/{clientId}/address/{addressId}")
    private void  updateAddress(
            @PathVariable Long clientId,
            @PathVariable Long addressId,
            @RequestBody UpdateAddressRequest request
    ) {
        var command = new UpdateAddressCommand(
                clientId,
                addressId,
                request.line1(),
                request.line2(),
                request.city(),
                request.postalCode(),
                request.province(),
                request.country()
        );
        updateAddressCommandHandler.handle(command);
    }

    @DeleteMapping("/{id}")
    private void  deleteClient(@PathVariable Long id) {
        var command = new DeleteClientCommand(id);
        deleteClientCommandHandler.handle(command);
    }

    @DeleteMapping("/{clientId}/address/{addressId}")
    private void deleteAddress(@PathVariable Long clientId, @PathVariable Long addressId) {
        var command = new DeleteAddressCommand(clientId, addressId);
        deleteAddressCommandHandler.handle(command);
    }

}