package work.maet.clients.controller.command.request;

import jakarta.annotation.Nonnull;

public record UpdateClientRequest(
        @Nonnull
        String firstName,
        @Nonnull
        String lastName,
        @Nonnull
        String phoneNumber,
        @Nonnull
        String email
) {
}
