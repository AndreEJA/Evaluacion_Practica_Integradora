package ni.edu.uam.registro_pasteleria_api.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono_cliente", nullable = false, length = 20)
    private String telefono;

    @Column(name = "correo_cliente", nullable = false, unique = true, length = 150)
    private String correo;

    @Column(name = "direccion_cliente", nullable = false, length = 255)
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Pedido> pedidos = new ArrayList<>();
}