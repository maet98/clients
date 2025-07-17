package work.maet.clients.query.queries;

import jakarta.annotation.Nonnull;

public record GetClientByIdQuery(
        @Nonnull
        Long clientId
) {
}
