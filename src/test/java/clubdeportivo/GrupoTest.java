package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GrupoTest {

    private Grupo g;

    // Arrange
    @BeforeEach
    public void init() throws ClubException {
        g = new Grupo("1","Fútbol", 10, 3, 20);
    }

    @Test
    @DisplayName("Crear un grupo con valores incorrectos eleva una excepción")
    public void constructor_ValorIncorrecto_LanzaClubException() throws ClubException {
        // Arrange
        int nplazas= 1;
        int matriculados = 1;
        int tarifa = -1;

        // Act + Assert
        assertThrows(ClubException.class, () -> new Grupo("1", "Fútbol", nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Crear un grupo con más matriculados que plazas eleva una excepción")
    public void constructor_MasPlazasQueMatriculados_LanzaClubException() throws ClubException {
        // Arrange
        int nplazas= 1;
        int matriculados = 2;

        // Act + Assert
        assertThrows(ClubException.class, () -> new Grupo("1", "Fútbol", nplazas, matriculados, 1));
    }

    @Test
    @DisplayName("El método getCodigo devuelve el código")
    public void getCodigos_DevuelveCodigo() {
        // Arrange
        String codigoEsperado = "1";

        // Act + Assert
        assertEquals(codigoEsperado, g.getCodigo());
    }

    @Test
    @DisplayName("El método getActividad devuelve la actividad")
    public void getActividad_DevuelveActividad() {
        // Arrange
        String actividadEsperada = "Fútbol";

        // Act + Assert
        assertEquals(actividadEsperada, g.getActividad());
    }

    @Test
    @DisplayName("El método getPlazas devuelve las plazas")
    public void getPlazas_DevuelvePlazas() {
         // Arrange
         int plazasEsperadas = 10;

        // Act + Assert
        assertEquals(plazasEsperadas, g.getPlazas());
    }

    @Test
    @DisplayName("El método getPlazas devuelve los matriculados")
    public void getMatriculados_DevuelveMatriculados() {
        // Arrange
        int matriculadosEsperados = 3;

        // Act + Assert
        assertEquals(matriculadosEsperados, g.getMatriculados());
    }

    @Test
    @DisplayName("El método getPlazas devuelve la tarifa")
    public void getTarifa_DevuelveTarifa() {
        // Arrange
        int tarifaEsperada = 20;

        // Act + Assert
        assertEquals(tarifaEsperada, g.getTarifa());
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
    public void matricular_PersonasNuevas_Anyadematriculado() throws ClubException{
        // Arrange
        int matriculadosAntes = g.getMatriculados();
        int Nmatricular = 5;

        // Act
        g.matricular(Nmatricular);

        // Assert
        assertEquals(matriculadosAntes+Nmatricular, g.getMatriculados());
    }

    @Test
    @DisplayName("Matricular personas con un valor incorrecto eleva una excepción")
    public void matricular_PersonasNegativas_LanzaClubException() throws ClubException{
        // Arrange
        int plazasLibres = g.plazasLibres();
        int nMatricular1 = -1;
        int nMatricular2 = plazasLibres+1;

        // Act + Assert
        assertThrows(ClubException.class, () -> g.matricular(nMatricular1));
        assertThrows(ClubException.class, () -> g.matricular(nMatricular2));
    }

    @Test
    @DisplayName("El método toString genera la cadena esperada")
    public void toString_CadenaEsperada_GeneraStringCorrecto() {
        // Arrange
        String resultadoEsperado = "(1 - Fútbol - 20.0 euros - P:10 - M:3)";

        // Act + Assert
        assertEquals(resultadoEsperado, g.toString());
    }

    @Test
    @DisplayName("Dos grupos con el mismo código y actividad deben ser iguales según el equals")
    public void equals_CompararGrupos_ComparaCorrectamente() throws ClubException {
        // Arrange
        Grupo g2 = new Grupo("1","Fútbol", 10, 3, 20);
        Grupo g3 = new Grupo("2","Baloncesto", 10, 3, 20);
        
        // Act + Assert
        assertTrue(g.equals(g2));
        assertFalse(g.equals(g3));
    }

    @Test
    @DisplayName("Dos grupos con el mismo código y actividad deben tener el mismo HashCode")
    public void hashCode_CompararGrupos_ComparaCorrectamente() throws ClubException {
        // Arrange
        Grupo g2 = new Grupo("1","Fútbol", 10, 3, 20);
        
        // Act + Assert
        assertEquals(g.hashCode(), g2.hashCode());
    }
    
}