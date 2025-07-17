package work.maet.clients.command.commands;

public record CreateClientCommand(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String nationalId
) {
}
