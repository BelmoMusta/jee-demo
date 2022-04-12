import com.supmti.tp01.banque.servlet.BanqueServlet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestServlet extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletConfig config = mock(ServletConfig.class);

        when(request.getParameter("username")).thenReturn("me");
        when(request.getParameter("password")).thenReturn("secret");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        BanqueServlet banqueServlet = new BanqueServlet();
        banqueServlet.init(config);
        banqueServlet.doPost(request, response);

        verify(request, atLeast(1)).getParameter("username");
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("My expected string"));
    }
}