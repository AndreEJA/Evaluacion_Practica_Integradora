package ni.edu.uam.registro_pasteleria_api.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "descripcion_pedido", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "total_pedido", nullable = false)
    private double total;

    @Column(name = "estado_pedido", nullable = false, length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @ToString.Exclude
    private Cliente cliente;
}