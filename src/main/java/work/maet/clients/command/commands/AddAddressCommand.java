package work.maet.clients.command.commands;

public record AddAddressCommand(
        Long clientId,
        String line1,
        String line2,
        String city,
        String postalCode,
        String province,
        String country
) {
}
