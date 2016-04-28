package proyecto.dominio;
public class Pez extends AnimalDomestico {

    private RazaPez raza;
    
    public Pez(float peso, int edad, RazaPez raza) {
        super(peso, edad);
        this.raza = raza;
        
    }

    @Override
    public float calcularPrecio() {
        if(raza.equals(Pez.RazaPez.LORICARIDO)){
            if(edad<=2){
                return 50000;
            }else{
                return 60000;
            }
        }
        if(raza.equals(Pez.RazaPez.KILIS)){
            if(edad<=2){
                return 35000;
            }else{
                return 55000;
            }
        }
        if(raza.equals(Pez.RazaPez.LABERINTIDO)){
            if(edad<=2){
                return 45000;
            }else{
                return 58000;
            }
        }
        if(raza.equals(Pez.RazaPez.CORYDORAS)){
            if(edad<=2){
                return 40000;
            }else{
                return 50000;
            }
        }
        return 0;
    }

    @Override
    public float calcularUtilidad() {
       return calcularPrecio()*0.15f;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", raza: " + this.raza;
    }

    @Override
    public String getNombreClase() {
        return "Pez";
    }
    
    

    public enum RazaPez{ LORICARIDO, KILIS, LABERINTIDO,CORYDORAS }
}


