import com.supmti.tp01.banque.entity.Personne;
import com.supmti.tp01.banque.service.api.BanqueServiceInterface;
import com.supmti.tp01.banque.servlet.BanqueServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMockito extends Mockito {

    @Test
    public void testServlet() throws Exception {
        Personne perosonneMockee = mock(Personne.class);
        when(perosonneMockee.getDateNaissance()).thenReturn("Not found");

        Assertions.assertEquals("Not found", perosonneMockee.getDateNaissance());
        BanqueServiceInterface banqueService =mock(BanqueServiceInterface.class);
        when(banqueService.creerCompte(null)).thenReturn(null);

    }
}