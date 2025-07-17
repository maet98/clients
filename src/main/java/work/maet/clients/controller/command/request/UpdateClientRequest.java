package work.maet.clients.controller.command.request;

public record UpdateClientRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email
) {
}
