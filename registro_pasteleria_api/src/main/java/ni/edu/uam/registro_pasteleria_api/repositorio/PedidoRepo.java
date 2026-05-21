package ni.edu.uam.registro_pasteleria_api.repositorio;

import ni.edu.uam.registro_pasteleria_api.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Pedido,Long> {
}
