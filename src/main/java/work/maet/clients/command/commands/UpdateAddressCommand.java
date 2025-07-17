package work.maet.clients.command.commands;

public record UpdateAddressCommand(
        Long clientId,
        Long AddressId,
        String line1,
        String line2,
        String city,
        String postalCode,
        String province,
        String country
) {
}
