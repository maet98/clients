package work.maet.clients.query.queries;

import jakarta.annotation.Nullable;

public record GetClientsQuery(
        @Nullable
        String name,
        int pageNumber
) {
}
