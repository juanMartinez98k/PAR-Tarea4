package py.una.pol.par.parprdmcs.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Juan
 */
public class ProductApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public ProductApp() {
        singletons.add(new ProductRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
