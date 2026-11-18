package bo.tesis.seguridad;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;

/** Servicio administrado por CDI. */
@ApplicationScoped
public class EstadoService {

    public Map<String, String> obtenerEstado() {
        return Map.of(
                "servicio", "api-seguridad",
                "estado", "OPERATIVO",
                "proyecto", "Prototipo ISO/IEC 27034"
        );
    }
}
