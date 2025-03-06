package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClubDeportivoTest {

    private ClubDeportivo c;

    // Arrange
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

    @Test
    @DisplayName("Matricular más personas que plazas libres eleva una excepción")
    public void matricular_MasPersonasQuePlazasLibres_LanzaClubException() throws ClubException {
        // Arrange
        String actividad = "Fútbol";
        int personas = 11;
        c.anyadirActividad(new Grupo("1", actividad, 10, 3, 20));

        // Act + Assert
        assertThrows(ClubException.class, () -> c.matricular(actividad, personas));
    }

    @Test
    @DisplayName("Matricular menos personas que plazas matricula a todos")
    public void matricular_MenosPersonasQuePlazasLibres_Deja0SinMatricular() throws ClubException {
        // Arrange
        String actividad = "Fútbol";
        int personas = 11;
        c.anyadirActividad(new Grupo("1", actividad, 10, 3, 20));
        c.anyadirActividad(new Grupo("2", actividad, 5, 0, 10));

        // Act
        c.matricular(actividad, personas);

        // Assert
        assertEquals(1, c.plazasLibres(actividad));
    }

    
}