package work.maet.clients.response;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

public record AddressResponse(
        @Nonnull
        Long id,
        @Nonnull
        String line1,
        @Nullable
        String line2,
        @Nonnull
        String city,
        @Nonnull
        String province,
        @Nonnull
        String postalCode,
        @Nonnull
        String country
) {
}
