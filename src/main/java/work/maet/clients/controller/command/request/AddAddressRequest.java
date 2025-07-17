package work.maet.clients.controller.command.request;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

public record AddAddressRequest(
        @Nonnull
        String line1,
        @Nullable
        String line2,
        @Nonnull
        String city,
        @Nonnull
        String postalCode,
        @Nonnull
        String province,
        @Nonnull
        String country
) {
}
