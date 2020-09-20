package py.una.pol.par.parprdmcs.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.InMemProductRepository;
import py.una.pol.par.parprdmcs.service.ProductServiceImpl;

/**
 *
 * @author Juan
 */
@Path("/prdmcs")
public class ProductRestService {

    private final ProductServiceImpl productService = new ProductServiceImpl(new InMemProductRepository());
    
    @GET
    @Path("/products")
    @Produces("application/json")
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = (ArrayList) productService.getAll();
        return products;
    }

    @GET
    @Path("/products/{id}")
    @Produces("application/json")
    public Product getProductById(@PathParam("id") Integer id) {
        Product entity = null;
        try {
            entity = (Product) productService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/products")
    @Consumes("application/json")
    @Produces("application/json")
    public Product addProduct(Product entity) {
        try {
            productService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/products")
    @Consumes("application/json")
    public void updateProduct(Product entity) {
        try {
            productService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/products/{id}")
    public void removeProduct(@PathParam("id") Integer id) {
        try {
            productService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
