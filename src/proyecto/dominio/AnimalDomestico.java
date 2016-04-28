package proyecto.dominio;
public abstract class AnimalDomestico {
    protected float peso;
    protected int edad;
    
    public AnimalDomestico(float peso, int edad){
        this.peso=peso;
        this.edad=edad;
    }
        
    public abstract float calcularPrecio ();
    public abstract float calcularUtilidad ();
    public abstract String getNombreClase();
    
    @Override
    public String toString(){
        return this.getNombreClase() + ": Peso: " + this.peso + ", Edad: " + this.edad + ", Precio: " + this.calcularPrecio();
    }
    
}
