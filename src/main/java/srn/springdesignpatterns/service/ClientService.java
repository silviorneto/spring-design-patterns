package srn.springdesignpatterns.service;

import srn.springdesignpatterns.model.Client;

import java.util.Optional;


public interface ClientService {
    Iterable<Client> getAll();
    Optional<Client> findById(Long id);
    void save(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
