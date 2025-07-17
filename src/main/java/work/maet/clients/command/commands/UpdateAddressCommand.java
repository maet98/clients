package work.maet.clients.command.commands;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

public record UpdateAddressCommand(
        @Nonnull
        Long clientId,
        @Nonnull
        Long addressId,
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
