package work.maet.clients.response;

public record AddressResponse(
        Long id,
        String line1,
        String line2,
        String city,
        String province,
        String postalCode,
        String country
) {
}
