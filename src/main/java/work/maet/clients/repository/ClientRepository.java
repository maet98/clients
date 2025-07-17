package work.maet.clients.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import work.maet.clients.models.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query(
            value =
                    "SELECT c FROM client c LEFT JOIN FETCH c.addresses " +
                            "WHERE (:name IS NULL OR c.firstName LIKE :name%)"
    )
    Page<Client> search(String name, Pageable pageable);
}
