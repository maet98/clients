package work.maet.clients.command.commands;

import jakarta.annotation.Nonnull;

public record CreateClientCommand(
        @Nonnull
        String firstName,
        @Nonnull
        String lastName,
        @Nonnull
        String phoneNumber,
        @Nonnull
        String email,
        @Nonnull
        String nationalId
) {
}
