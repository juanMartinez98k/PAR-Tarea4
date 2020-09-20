package py.una.pol.par.parprdmcs.repository;

import java.util.Collection;
import py.una.pol.par.commons.repository.Repository;

/**
 *
 * @author Juan
 * @param <Product>
 * @param <Integer>
 */
public interface ProductRepository<Product, Integer> extends Repository<Product, Integer> {

    /**
     * @param descripcion
     * @return
     */
    boolean containsDesc(String descripcion);

    /**
     *
     * @param id
     * @return
     */
    public Product findById(int id);
    
    /**
     *
     * @param id
     * @return
     */
    boolean containsId(int id);

    /**
     *
     * @param descripcion
     * @return
     */
    public Product findByDesc(String descripcion);
    
    /**
     * Metodo para buscar productos por categoria
     * @param id_categoria
     * @return 
     */
    public Collection<Product> findbyCategoria(Integer id_categoria);
}
