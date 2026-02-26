package sv.edu.udb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.entity.*;
import sv.edu.udb.repository.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersistenciaTest {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoMateriaRepository alumnoMateriaRepository;

    @Test
    @Commit // Esta anotación hace que los datos persistan
    void testPersistenciaCompleta() {

        // 1. Crear y guardar 2 nuevos profesores
        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Roberto Molina");

        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Elena Castro");

        profesor1 = profesorRepository.save(profesor1);
        profesor2 = profesorRepository.save(profesor2);

        assertNotNull(profesor1.getId());
        assertNotNull(profesor2.getId());
        System.out.println("Profesores guardados: " + profesor1.getNombre() + ", " + profesor2.getNombre());

        // 2. Crear y guardar 2 nuevas materias
        Materia materia1 = new Materia();
        materia1.setNombre("Física");
        materia1.setProfesor(profesor1);

        Materia materia2 = new Materia();
        materia2.setNombre("Química");
        materia2.setProfesor(profesor2);

        materia1 = materiaRepository.save(materia1);
        materia2 = materiaRepository.save(materia2);

        assertNotNull(materia1.getId());
        assertNotNull(materia2.getId());
        System.out.println("Materias guardadas: " + materia1.getNombre() + ", " + materia2.getNombre());

        // 3. Crear y guardar 2 nuevos alumnos
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Fernando");
        alumno1.setApellido("Torres");

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Laura");
        alumno2.setApellido("Mendoza");

        alumno1 = alumnoRepository.save(alumno1);
        alumno2 = alumnoRepository.save(alumno2);

        assertNotNull(alumno1.getId());
        assertNotNull(alumno2.getId());
        System.out.println("Alumnos guardados: " + alumno1.getNombre() + " " + alumno1.getApellido() +
                ", " + alumno2.getNombre() + " " + alumno2.getApellido());

        // 4. Crear inscripciones (alumno_materia)
        AlumnoMateria inscripcion1 = new AlumnoMateria();
        AlumnoMateriaId id1 = new AlumnoMateriaId();
        id1.setAlumnoId(alumno1.getId());
        id1.setMateriaId(materia1.getId());
        inscripcion1.setId(id1);
        inscripcion1.setAlumno(alumno1);
        inscripcion1.setMateria(materia1);

        AlumnoMateria inscripcion2 = new AlumnoMateria();
        AlumnoMateriaId id2 = new AlumnoMateriaId();
        id2.setAlumnoId(alumno2.getId());
        id2.setMateriaId(materia2.getId());
        inscripcion2.setId(id2);
        inscripcion2.setAlumno(alumno2);
        inscripcion2.setMateria(materia2);

        alumnoMateriaRepository.save(inscripcion1);
        alumnoMateriaRepository.save(inscripcion2);

        System.out.println("Inscripciones guardadas: Alumno " + alumno1.getNombre() + " en " + materia1.getNombre() +
                ", Alumno " + alumno2.getNombre() + " en " + materia2.getNombre());

        // 5. Verificar que los datos se guardaron correctamente
        assertEquals(7, profesorRepository.count()); // 5 iniciales + 2 nuevos
        assertEquals(7, materiaRepository.count());  // 5 iniciales + 2 nuevas
        assertEquals(7, alumnoRepository.count());   // 5 iniciales + 2 nuevos

        System.out.println("\n=== VERIFICACIÓN FINAL ===");
        System.out.println("Total de profesores: " + profesorRepository.count());
        System.out.println("Total de materias: " + materiaRepository.count());
        System.out.println("Total de alumnos: " + alumnoRepository.count());
        System.out.println("Total de inscripciones: " + alumnoMateriaRepository.count());
    }
}

