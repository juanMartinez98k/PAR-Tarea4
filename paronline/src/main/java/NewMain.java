
import java.util.ArrayList;
import py.una.pol.par.client.ProductoModelo;
import py.una.pol.par.entity.Categoria;
import py.una.pol.par.entity.Product;

/**
 *
 * @author juan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductoModelo pm = new ProductoModelo();
        ArrayList<Product> productos = pm.getProducts();
        System.out.println(productos);
        
        Product p = pm.getProductById(1);
        System.out.println(p);
        
        Product p1 = new Product(1,"Notebook");
        p1.setDescripcion("Notebook HP T-Series");
        p1.setCategoria(new Categoria(5,"Informatica"));
        p1.setPrecioUnit(4000000);
        p1.setCantidad(40);
        
        pm.addProduct(p1);
        Product uAdded = pm.getProductById(p1.getId());
        System.out.println(uAdded);
    }
    
}
