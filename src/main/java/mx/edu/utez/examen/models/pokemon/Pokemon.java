package mx.edu.utez.examen.models.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.entrenador.Entrenador;

import javax.persistence.*;

@Entity
@Table(name = "pokemones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String type;
    @Column(nullable = false )
    private Long power;
    @Column(nullable = false)
    private Long health;
    @Column(nullable = false)
    private Long attack;
    @Column(nullable = false)
    private Long shield;
    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Entrenador entrenador;
}
