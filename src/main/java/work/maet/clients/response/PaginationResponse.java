package work.maet.clients.response;

import java.util.List;

public record PaginationResponse<T>(
        List<T> content,
        long totalResult,
        long currentPage,
        int totalPage
) {
}
