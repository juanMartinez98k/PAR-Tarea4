package py.una.pol.par.parprdmcs.service;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.commons.service.BaseService;
import py.una.pol.par.parprdmcs.model.entity.Product;
import py.una.pol.par.parprdmcs.repository.ProductRepository;


/**
 *
 * @author Juan
 */
public class ProductServiceImpl extends BaseService<Product,Integer> implements ProductService {

    private final ProductRepository<Product, Integer> productRepository;

    /**
     *
     * @param productRepository
     */
    //@Autowired
    public ProductServiceImpl(ProductRepository<Product, Integer> productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) throws Exception {
        if (productRepository.containsId(product.getId())) {
            throw new Exception(String.format("Ya existe un producto con el id %d.", product.getId()));
        }
        
        if (productRepository.containsDesc(product.getName())) {
            throw new Exception(String.format("Ya existe un producto con el nombre %s.", product.getName()));
        }
        
        if (product.getName() == null || "".equals(product.getName())) {
            throw new Exception("El nombre del producto no puede ser nulo o cadena vacia.");
        }
        super.add(product);
    }

    /**
     *
     * @param id_categoria
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Product> findByCategoria(Integer id_categoria) throws Exception {
        return productRepository.findbyCategoria(id_categoria);
    }

    /**
     *
     * @param product
     * @throws Exception
     */
    @Override
    public void update(Product product) throws Exception {
        productRepository.update(product);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        productRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return productRepository.get(id);
    }

}
