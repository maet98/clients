package work.maet.clients.response;

import work.maet.clients.models.Address;

import java.util.List;

public record ClientResponse(
        long id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String nationalId,
        List<AddressResponse> addresses
) {
}
