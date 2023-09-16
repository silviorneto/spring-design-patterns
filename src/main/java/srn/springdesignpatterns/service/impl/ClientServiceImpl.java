package srn.springdesignpatterns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srn.springdesignpatterns.model.Address;
import srn.springdesignpatterns.model.Client;
import srn.springdesignpatterns.repository.AddressRepository;
import srn.springdesignpatterns.repository.ClientRepository;
import srn.springdesignpatterns.service.ClientService;
import srn.springdesignpatterns.service.ViaCepService;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> getAll() {
        return clientRepo.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepo.findById(id);
    }

    @Override
    public void save(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientFound = clientRepo.findById(id);
        if (clientFound.isPresent()) {
            saveClientWithCep(client);
        }
//      Apresentar uma exceção caso não encontre
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepo.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.getCep(cep);
            addressRepo.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepo.save(client);
    }
}
