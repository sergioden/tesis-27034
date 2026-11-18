
package bo.tesis.seguridad;

import hipstershop.Demo;
import hipstershop.ProductCatalogService;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/v1/productos")
@Produces(MediaType.APPLICATION_JSON)
public class ProductoResource {

    @GrpcClient("catalog")
    ProductCatalogService catalogo;

    public record ProductoDto(
            String id,
            String nombre,
            String descripcion
    ) {}

    @GET
    public Uni<List<ProductoDto>> listarProductos() {

        return catalogo
                .listProducts(Demo.Empty.getDefaultInstance())
                .onItem()
                .transform(respuesta ->
                        respuesta.getProductsList()
                                .stream()
                                .map(producto -> new ProductoDto(
                                        producto.getId(),
                                        producto.getName(),
                                        producto.getDescription()
                                ))
                                .toList()
                );
    }
}
