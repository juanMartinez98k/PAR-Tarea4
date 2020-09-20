package py.una.pol.par.parprdmcs.repository;

import java.util.ArrayList;
import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.parprdmcs.model.entity.Product;

/**
 *
 * @author Juan
 */
public class InMemProductRepository implements ProductRepository<Product, Integer>{
    
    private ArrayList<Product> productos = new ArrayList<>();
    
    @Override
    public boolean containsId(int id_producto) {
        return this.findById(id_producto) != null;
    }

    @Override
    public Product findById(int id_producto) {
        Product retValue = null;
        for (Product producto : productos) {
            if (producto.getId() ==  id_producto) {
                retValue = producto;
                break;
            }
        }
        return retValue;
    }

    @Override
    public boolean containsDesc(String descripcion) {
        return this.findByDesc(descripcion) != null;
    }

    @Override
    public Product findByDesc(String nombre) {
        Product retValue = null;
        for (Product producto : productos) {
            if (producto.getDescripcion().equalsIgnoreCase(nombre)) {
                retValue = producto;
                break;
            }
        }
        return retValue;
    }

    @Override
    public void add(Product entity) {
        productos.add(entity);
    }

    @Override
    public void remove(Integer id) {
        for (Product producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
            }
            break;
        }
    }

    @Override
    public void update(Product entity) {
        for (Product product : productos) {
            if (product.getId() == entity.getId()) {
                product = entity;
                break;
            }
        }
    }

    @Override
    public boolean contains(Integer id) {
        boolean retValue = false;
        for (Product producto : productos) {
            if (producto.getId() == id) {
                retValue = true;
                break;
            }
        }
        return retValue;
    }

    @Override
    public Entity get(Integer id) {
        Product retValue = null;
        for (Product producto : productos) {
            if (producto.getId() == id) {
                retValue = producto;
                break;
            }
        }
        return retValue;
    }

    @Override
    public Collection<Product> getAll() {
        return productos;
    }

    @Override
    public Collection<Product> findbyCategoria(Integer id_categoria) {
        Collection<Product> retValue = new ArrayList<>();
        for (Product producto : productos) {
            if (producto.getCategoria().getId() == id_categoria) {
                retValue.add(producto);
            }
        }
        return retValue;
    }
    
}
