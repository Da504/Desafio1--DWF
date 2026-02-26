package sv.edu.udb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoMateriaId implements Serializable {

    @Column(name = "id_alumno")
    private Long alumnoId;

    @Column(name = "id_materia")
    private Long materiaId;
}