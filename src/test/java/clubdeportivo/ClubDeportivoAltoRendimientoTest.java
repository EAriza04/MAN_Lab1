// Eduardo Ariza Abad y Enrique Ibáñez Rico

package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClubDeportivoAltoRendimientoTest {

private ClubDeportivoAltoRendimiento c;

    // Arrange
    @BeforeEach
    public void init() throws ClubException{
         c = new ClubDeportivoAltoRendimiento("Deportes UMA", 10, 10);
    }
    
    @Test
    @DisplayName("Crear un club con valor negativo eleva una excepción")
    public void constructor_ValorNegativo_LanzaClubException() {
        // Arrange
        int n = -1;

        // Act + Assert
        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento("Miembros negativos", 10, n));
    }

    @Test
    @DisplayName("Crear un club con valor negativo eleva una excepción")
    public void constructor_ValorNegativo2_LanzaClubException() {
        // Arrange
        int n = -1;

        // Act + Assert
        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento("Miembros negativos", 10, 10, n));
    }

    @Test
    @DisplayName("Añadir una actividad a un club inserta un nuevo grupo al club y ajusta su número de miembros")
    public void anyadirActividad_grupoValidoNuevo_InsertadoCorrectamente() throws ClubException {
        // Arrange
        String[] g = {"1", "Fútbol", "15", "3", "20"};
        int plazasAntes = c.plazasLibres("Fútbol");

        // Act
        c.anyadirActividad(g);

        // Assert
        assertNotEquals(plazasAntes, c.plazasLibres("Fútbol"));
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
    @DisplayName("Añadir una actividad con falta de datos eleva una excepción")
    public void anyadirActividad_grupoFaltaDatos_LanzaClubException() throws ClubException {
        // Arrange
        String[] g = {"1", "Fútbol", "error", "3"};

        // Act + Assert
        assertThrows(ClubException.class, () -> c.anyadirActividad(g));
    }

    @Test
    @DisplayName("Añadir una actividad con datos nullos eleva una excepción")
    public void anyadirActividad_grupoNulo_LanzaClubException() throws ClubException {
        // Arrange
        String[] g = null;

        // Act + Assert
        assertThrows(ClubException.class, () -> c.anyadirActividad(g));
    }

     @Test
    @DisplayName("El método ingresos devuelve los ingresos totales del club")
    public void ingresos_DevuelveIngresos() throws ClubException {
        // Arrange
        double esperado = 60*1.1;
        String actividad = "Fútbol";
        c = new ClubDeportivoAltoRendimiento("Miembros negativos", 10, 10, 10);

        // Act
        c.anyadirActividad(new Grupo("1", actividad, 10, 3, 20));

        // Act
        assertEquals(esperado, c.ingresos());
    }

}