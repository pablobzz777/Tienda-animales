package proyecto.dominio;
public class Gato extends AnimalDomestico {

    public Gato(float peso, int edad) {
        super(peso, edad);
    }

    @Override
    public float calcularPrecio() {

        if (edad<=4){
            return 10000; 
        }   
        if (edad>4 && edad<=24){
            return 20000;   
        }    
        if (edad>24 && edad<52){
            return 40000;
        }
        if (edad>=52){
            return 75000 + (int)((edad-52)/12)*(10000);
        } 
        
    return 0;

    }

    @Override
    public float calcularUtilidad() {
        return calcularPrecio()*0.30f;
    }
    
    @Override
    public String getNombreClase() {
        return "Gato";
    }
    
}
