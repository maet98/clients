package work.maet.clients.command.commands;

import jakarta.annotation.Nonnull;

public record DeleteClientCommand(
        @Nonnull
        Long clientId
) {
}
