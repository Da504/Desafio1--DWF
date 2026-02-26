package sv.edu.udb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "alumno_materia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoMateria {

    @EmbeddedId
    private AlumnoMateriaId id;

    @ManyToOne
    @MapsId("alumnoId")
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "id_materia")
    private Materia materia;
}