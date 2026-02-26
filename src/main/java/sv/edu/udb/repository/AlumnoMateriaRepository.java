package sv.edu.udb.repository;

import sv.edu.udb.entity.AlumnoMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Long> {
}