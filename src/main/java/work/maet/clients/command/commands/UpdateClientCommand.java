package work.maet.clients.command.commands;

public record UpdateClientCommand(
        Long clientId,
        String firstName,
        String lastName,
        String phoneNumber,
        String email
) {
}
