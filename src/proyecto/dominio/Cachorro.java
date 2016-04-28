package proyecto.dominio;
public class Cachorro extends AnimalDomestico {

    public Cachorro(float peso, int edad) {
        super(peso, edad);
    }

    @Override
    public float calcularPrecio() {

        if (edad<=4){
            return 20000; 
        }   
        if (edad>4 && edad<=16){
            return 30000;   
        }    
        if (edad>16 && edad<52){
            return 50000;
        }
        if (edad>=52){
            return 100000 + (int)((edad-52)/8)*(15000);
        } 
        
    return 0;

    }

    @Override
    public float calcularUtilidad() {
        return calcularPrecio()*0.25f;
    }
    
    @Override
    public String getNombreClase() {
        return "Cachorro";
    }
        
}
