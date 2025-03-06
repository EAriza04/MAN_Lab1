package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GrupoTest {

    private Grupo g;

    // Arrange
    @BeforeEach
    public void init() throws ClubException {
        g = new Grupo("1","Fútbol", 10, 0, 20);
    }

    @Test
    @DisplayName("Actualizar plazas cambia correctamente el valor correspondiente")
    public void actualizarPlazas_NuevoValor_ValorActualizado() throws ClubException {
        // Arrange
        int n = 9;
        
        // Act
        g.actualizarPlazas(n);

        // Assert
        assertEquals(n, g.getPlazas());
    }

    @Test
    @DisplayName("Actualizar plazas con un valor incorrecto eleva una excepción")
    public void actualizarPlazas_ValorIncorrecto_LanzaClubException() throws ClubException {
        // Arrange
        int n1 = -1;
        int n2 = g.getMatriculados() - 1;

        // Act + Assert
        assertThrows(ClubException.class, () -> g.actualizarPlazas(n1));
        assertThrows(ClubException.class, () -> g.actualizarPlazas(n2));
    }

    @Test
    @DisplayName("Matricular personas aumenta el número de matriculados correctamente")
    public void Matricular_PersonaNueva_Anyadematriculado() throws ClubException{
        // Arrange
        int matriculadosAntes = g.getMatriculados();
        int Nmatricular = 5;

        // Act
        g.matricular(Nmatricular);

        // Assert
        assertEquals(g.getMatriculados(), matriculadosAntes+Nmatricular);
    }



}
