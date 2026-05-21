package ni.edu.uam.registro_pasteleria_api.servicios;

import ni.edu.uam.registro_pasteleria_api.modelos.Cliente;
import ni.edu.uam.registro_pasteleria_api.repositorio.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ClienteService {

        private final ClienteRepo clienteRepo;

        public ClienteService(ClienteRepo clienteRepo) {
            this.clienteRepo = clienteRepo;
        }

        public List<Cliente> getAllClientes() {
            return clienteRepo.findAll();
        }

        public Cliente getClienteById(Long id) {
            return clienteRepo.findById(id).orElse(null);
        }

        public Cliente saveCliente(Cliente cliente) {
            return clienteRepo.save(cliente);
        }

        public void deleteCliente(Long id) {
            clienteRepo.deleteById(id);
        }
    }

