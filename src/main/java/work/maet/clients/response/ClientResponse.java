package work.maet.clients.response;

import jakarta.annotation.Nonnull;

import java.util.List;

public record ClientResponse(
        @Nonnull
        Long id,
        @Nonnull
        String firstName,
        @Nonnull
        String lastName,
        @Nonnull
        String phoneNumber,
        @Nonnull
        String email,
        @Nonnull
        String nationalId,
        @Nonnull
        List<AddressResponse> addresses
) {
}
