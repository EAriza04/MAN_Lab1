package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void Matricular_Grupo_Anyadematriculado() throws ClubException{
        // Arrange
        int matriculadosAntes = g.getMatriculados();
        int Nmatricular = 5;

        // Act
        g.matricular(Nmatricular);

        // Assert
        assertEquals(g.getMatriculados(), matriculadosAntes+Nmatricular);
    }

}
