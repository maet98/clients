package work.maet.clients.controller.command.request;

public record UpdateAddressRequest(
        String line1,
        String line2,
        String city,
        String postalCode,
        String province,
        String country
) {
}
