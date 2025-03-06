package clubdeportivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrupoTest {

    private Grupo g;

    @BeforeEach
    public void init() throws ClubException {
        g=new Grupo("1","Fútbol", 10, 0, 20);
    }

    @Test
    public void Matricular_Grupo_Anyadematriculado(){
        int p = g.plazasLibres();

    }
}
