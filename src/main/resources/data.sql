-- Insertar 5 profesores
INSERT INTO profesor (nombre) VALUES
                                  ('Carlos Martínez'),
                                  ('María López'),
                                  ('José Rodríguez'),
                                  ('Ana García'),
                                  ('Pedro Sánchez');

-- Insertar 5 materias
INSERT INTO materia (nombre, id_profesor) VALUES
                                              ('Matemáticas', 1),
                                              ('Lenguaje', 2),
                                              ('Ciencias', 3),
                                              ('Historia', 4),
                                              ('Inglés', 5);

-- Insertar 5 alumnos
INSERT INTO alumno (nombre, apellido) VALUES
                                          ('Juan', 'Pérez'),
                                          ('María', 'González'),
                                          ('Luis', 'Hernández'),
                                          ('Ana', 'Díaz'),
                                          ('Carlos', 'Ramírez');

-- Insertar inscripciones (alumno_materia)
INSERT INTO alumno_materia (id_alumno, id_materia) VALUES
                                                       (1, 1), (1, 2), (1, 3),
                                                       (2, 2), (2, 4), (2, 5),
                                                       (3, 1), (3, 3), (3, 5),
                                                       (4, 2), (4, 4),
                                                       (5, 1), (5, 3), (5, 4), (5, 5);