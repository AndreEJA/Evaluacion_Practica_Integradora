package ni.edu.uam.registro_pasteleria_api.repositorio;

import ni.edu.uam.registro_pasteleria_api.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}