package work.maet.clients.response;

import jakarta.annotation.Nonnull;

import java.util.List;

public record PaginationResponse<T>(
        @Nonnull
        List<T> content,
        long totalResult,
        long currentPage,
        int totalPage
) {
}
