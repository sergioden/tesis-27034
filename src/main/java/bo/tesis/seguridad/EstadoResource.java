package bo.tesis.seguridad;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

/** Endpoint inicial de la API REST para validar el prototipo. */
@Path("/api/v1/estado")
public class EstadoResource {

    @Inject
    EstadoService estadoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> obtenerEstado() {
        return estadoService.obtenerEstado();
    }
}
