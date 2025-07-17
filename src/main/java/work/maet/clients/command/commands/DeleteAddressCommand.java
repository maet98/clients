package work.maet.clients.command.commands;

import jakarta.annotation.Nonnull;

public record DeleteAddressCommand(
        @Nonnull
        Long clientId,
        @Nonnull
        Long AddressId
) {
}
