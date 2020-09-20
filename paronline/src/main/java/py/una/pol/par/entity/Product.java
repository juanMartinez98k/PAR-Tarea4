package py.una.pol.par.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author Juan
 */
public class Product extends BaseEntity<Integer> {
    
    private String descripcion;
    private Categoria categoria;
    private float precioUnit;
    private int cantidad;
    
    public Product() {
        super(0,"");
    }
    
    public Product(Integer id, String nombre) {
        super(id, nombre);
    }

    public Product(Integer id, String nombre, String descripcion, Integer id_categoria,
                     String desc_categoria, float precioUnit, int cantidad) {
        super(id, nombre);
        this.descripcion = descripcion;
        this.categoria.setId(id_categoria);
        this.categoria.setName(desc_categoria);
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(float precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Overridden toString() method that return String presentation of the Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.getId()).append(", nombre: ").append(this.getName())
        .append(", descripcion: ").append(descripcion).append(", categoria: ").append(categoria)
        .append(", precio unitario: ").append(precioUnit).append(", cantidad: ").append(cantidad).append("}").toString();
    }
}