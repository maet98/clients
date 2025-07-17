package work.maet.clients.command.commands;

public record DeleteAddressCommand(
        Long clientId,
        Long AddressId
) {
}
