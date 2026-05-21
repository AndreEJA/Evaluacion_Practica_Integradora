package ni.edu.uam.registro_pasteleria_api.servicios;

import ni.edu.uam.registro_pasteleria_api.modelos.Pedido;
import ni.edu.uam.registro_pasteleria_api.repositorio.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepo pedidoRepo;

    public PedidoService(PedidoRepo pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepo.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    public void deletePedido(Long id) {
        pedidoRepo.deleteById(id);
    }
}