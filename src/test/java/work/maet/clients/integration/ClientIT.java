package work.maet.clients.integration;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import work.maet.clients.command.commands.CreateClientCommand;
import work.maet.clients.controller.command.request.AddAddressRequest;
import work.maet.clients.controller.command.request.UpdateAddressRequest;
import work.maet.clients.controller.command.request.UpdateClientRequest;
import work.maet.clients.models.Address;
import work.maet.clients.models.Client;
import work.maet.clients.repository.ClientRepository;

import java.util.List;


public class ClientIT extends BaseIntegrationTest {

    @LocalServerPort
    private Integer port;

    private final Address address1 =
            Address.builder()
                    .line1("calle 12")
                    .city("Santiago")
                    .province("Santiago")
                    .country("Dominican Republic")
                    .postalCode("51000")
                    .build();


    private final Client client1 =
            Client.builder()
                    .firstName("miguel")
                    .lastName("estevez")
                    .phoneNumber("183912232")
                    .nationalId("123213213")
                    .email("malet@gmail.com")
                    .addresses(List.of(address1))
                    .build();


    @Autowired
    ClientRepository repository;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        repository.deleteAll();
    }

    @Test
    void createClient() {
        var body = new CreateClientCommand(
                "Juan",
                "Perez",
                "849-234-1232",
                "ma@gmail.com",
                "430-1232132-1"
        );

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/v1/clients")
                .then()
                .statusCode(201);
        var count = repository.count();
        assertEquals(1, count);
    }

    @Test
    void searchClients() {
        repository.save(client1);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/clients")
                .then()
                .statusCode(200)
                .body(
                        "totalResult",
                        is(1),
                        "content",
                        hasSize(1));
    }

    @Test
    void updateClient() {
        repository.save(client1);
        var request = new UpdateClientRequest(
                "Miguel",
                "Estevez",
                "183912232",
                "maleta@gmail.com"
        );
        var url = String.format("/api/v1/clients/%d", client1.getId());

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .put(url)
                .then()
                .statusCode(200);

    }

    @Test
    void deleteClient() {
        repository.save(client1);

        var url = String.format("/api/v1/clients/%d", client1.getId());

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .statusCode(200);

        var count = repository.count();
        assertEquals(0, count);
    }

    @Test
    void addAddress() {
        repository.save(client1);
        var body = new AddAddressRequest(
                "Calle 8, Embrujo",
                null,
                "Santiago",
                "51000",
                "Santiago",
                "Dominican republic"
        );

        var url = String.format("/api/v1/clients/%d/address", client1.getId());

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(201);
    }

    @Test
    void updateAddress() {
        repository.save(client1);
        var request = new UpdateAddressRequest(
                "Calle 1, Villa olga",
                "Casa 4",
                "Santiago",
                "51000",
                "Santiago",
                "Dominican Republic"
        );

        var url = String.format("/api/v1/clients/%d/address/%d", client1.getId(), client1.getAddresses().getFirst().getId());

        given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .put(url)
                .then()
                .statusCode(200);

    }

    @Test
    void deleteAddress() {
        repository.save(client1);
        var url = String.format("/api/v1/clients/%d/address/%d", client1.getId(), client1.getAddresses().getFirst().getId());

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(url)
                .then()
                .statusCode(200);

    }
}
