package cl.camila.service;

import cl.camila.model.Alumno;
import cl.camila.repository.AlumnoReppository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AlumnoServiceImplTest {

    private AlumnoServiceImpl alumnoSvc;

    @Mock
    private AlumnoReppository alumnoReppository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); //inicializa los mocks de esta prueba
        alumnoSvc = new AlumnoServiceImpl(alumnoReppository);
    }

    @Test
    public void givenObjetoAlumnoThenSaveItInRepo(){
        Alumno alumno = new Alumno("Pedro", "145-7");
        alumno.setId(1L);

        when(alumnoReppository.save(any(Alumno.class))).thenReturn(alumno); // Cuando save se llame en el repositorio, retorna el estudiante
        alumnoSvc.save(alumno); // Llamada al método a probar
        verify(alumnoReppository).save(eq(alumno)); // Verifica si save fue llamado con el estudiante correcto

    }


}
