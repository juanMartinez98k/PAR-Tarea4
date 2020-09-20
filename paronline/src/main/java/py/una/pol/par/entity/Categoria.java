
package py.una.pol.par.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author Juan
 */
public class Categoria extends BaseEntity<Integer>{
    
    public Categoria(Integer id_categoria, String descripcion){
        super(id_categoria,descripcion);
    }
    
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.getId()).append(", nombre: ")
                                   .append(this.getName()).append("}").toString();
    }
}