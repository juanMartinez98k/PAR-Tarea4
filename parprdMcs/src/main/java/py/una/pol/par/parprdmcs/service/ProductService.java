package py.una.pol.par.parprdmcs.service;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.parprdmcs.model.entity.Product;

/**
 *
 * @author Juan
 */
public interface ProductService {

    /**
     *
     * @param product
     * @throws Exception
     */
    public void add(Product product) throws Exception;

    /**
     *
     * @param product
     * @throws Exception
     */
    public void update(Product product) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param id_categoria 
     * @return
     * @throws Exception
     */
    public Collection<Product> findByCategoria(Integer id_categoria) throws Exception;

}
