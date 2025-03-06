package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClubDeportivoTest {

    private ClubDeportivo c;

    @BeforeEach
    public void init() throws ClubException{
         c = new ClubDeportivo("Deportes UMA");
    }

    @Test
    @DisplayName("Crear un club con valor negativo eleva una excepción")
    public void constructor_ValorNegativo_LanzaClubException() {
        // Arrange
        int n = -1;

        // Act + Assert
        assertThrows(ClubException.class, () -> new ClubDeportivo("Miembros negativos", n));
    }

    @Test
    @DisplayName("Añadir una actividad a un club inserta un nuevo grupo al club")
    public void anyadirActividad_grupoValidoNuevo_InsertadoCorrectamente() throws ClubException {
        // Arrange
        String[] g = {"1", "Fútbol", "10", "3", "20"};
        int plazasAntes = c.plazasLibres("Fútbol");

        // Act
        c.anyadirActividad(g);

        // Assert
        assertNotEquals(plazasAntes, c.plazasLibres("Fútbol"));
    }

    @Test
    @DisplayName("Añadir una actividad de un grupo que ya existe actualiza las plazas")
    public void anyadirActividad_grupoValidoRepetido_ActualizadoCorrectamente() throws ClubException {
        // Arrange
        String plazasAntes = "10";
        String plazasDespues = "15";
        String[] g1 = {"1", "Fútbol", plazasAntes, "3", "20"};
        String[] g2 = {"1", "Fútbol", plazasDespues, "3", "20"};

        // Act + Assert
        c.anyadirActividad(g1);
        c.anyadirActividad(g2);

        assertEquals(12, c.plazasLibres("Fútbol"));
    }

    @Test
    @DisplayName("Añadir una actividad con datos erróneos eleva una excepción")
    public void anyadirActividad_grupoNoValido_LanzaClubException() throws ClubException {
        // Arrange
        String[] g = {"1", "Fútbol", "error", "3", "20"};

        // Act + Assert
        assertThrows(ClubException.class, () -> c.anyadirActividad(g));
    }

    @Test
    @DisplayName("Añadir una actividad con datos erróneos eleva una excepción")
    public void anyadirActividad_grupoNulo_LanzaClubException() throws ClubException {
        // Arrange
        Grupo g = null;

        // Act + Assert
        assertThrows(ClubException.class, () -> c.anyadirActividad(g));
    }
}