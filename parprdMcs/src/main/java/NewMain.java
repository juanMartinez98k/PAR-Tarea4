import java.util.ArrayList;
import py.una.pol.par.parprdmcs.model.entity.Categoria;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.InMemProductRepository;

/**
 *
 * @author Juan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InMemProductRepository imprd = new InMemProductRepository();
        Product p = new Product(1,"Notebook");
        p.setDescripcion("Notebook HP T-Series");
        p.setCategoria(new Categoria(5,"Informatica"));
        p.setPrecioUnit(4000000);
        p.setCantidad(40);
        imprd.add(p);
        
        Product p2 = new Product(2,"Parlante");
        p2.setDescripcion("Parlante JBL");
        p2.setCategoria(new Categoria(3,"Perifericos"));
        p2.setPrecioUnit(200000);
        p2.setCantidad(26);
        imprd.add(p2);
        
        Product p3 = new Product(3,"Mouse");
        p3.setDescripcion("Mouse SATE Link");
        p3.setCategoria(new Categoria(3,"Perifericos"));
        p3.setPrecioUnit(30000);
        p3.setCantidad(33);
        imprd.add(p3);
        
        System.out.println(imprd.contains(1));
        System.out.println(imprd.containsId(5));
        System.out.println(imprd.containsDesc("Notebook HP T-Series"));
        System.out.println(imprd.containsDesc("Mouse Link"));
        
        System.out.println("\nPor Categoria:");
        ArrayList<Product> prod_categoria = (ArrayList<Product>) imprd.findbyCategoria(3);
        for (Product product : prod_categoria) {
            System.out.println("Producto: " + product);
        }
        
        System.out.println("\nTodos los productos:");
        ArrayList<Product> productos = (ArrayList<Product>) imprd.getAll();
        for (Product product : productos) {
            System.out.println("Producto: " + product);
        }
        
    }
    
}
