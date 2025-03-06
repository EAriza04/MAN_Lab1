package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

public class ClubDeportivoTest {

    private ClubDeportivo c;

    @BeforeEach
    public void init() throws ClubException{
         c = new ClubDeportivo("Futboleros");
    }

    @Test
    @DisplayName("Crear un club con valor negativo eleva una excepción")
    public void constructor_ValorNegativo_LanzaClubException() {
        // Arrange
        int n = -1;

        // Act + Assert
        assertThrows(ClubException.class, () -> new ClubDeportivo("Miembros negativos", n));
    }

}
