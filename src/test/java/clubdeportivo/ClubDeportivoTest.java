package clubdeportivo;

import org.junit.jupiter.api.BeforeEach;

public class ClubDeportivoTest {

    private ClubDeportivo c;

    @BeforeEach
    public void init() throws ClubException{
         c = new ClubDeportivo("Futboleros");
    }


}
