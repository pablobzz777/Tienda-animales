package proyecto.dominio;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<AnimalDomestico> listaAnimalesDisponibles = new ArrayList<AnimalDomestico>();
    private List<AnimalDomestico> listaAnimalesVendidos = new ArrayList<AnimalDomestico>();
    
    public void agregarAnimal(AnimalDomestico compra){
        this.listaAnimalesDisponibles.add(compra);
    }
    public Boolean venderAnimal(AnimalDomestico animal){
        if(this.listaAnimalesDisponibles.remove(animal)){
            this.listaAnimalesVendidos.add(animal);
            return true;
        }
        return false;
    }
    public List<AnimalDomestico> buscarAnimalesPorTipo(Class tipo){
      List<AnimalDomestico> listaBusqueda = new ArrayList<AnimalDomestico>();
      for(AnimalDomestico animal: this.listaAnimalesDisponibles){
          if(animal.getClass().equals(tipo)){
              listaBusqueda.add(animal);
          }
      }
      return listaBusqueda;
  }
    public float calcularUtilidad (){
        float utilidad=0;
        for(AnimalDomestico animal: this.listaAnimalesVendidos){
            utilidad=utilidad+animal.calcularUtilidad();
        }
        return utilidad;
    }
    
    public int numeroAnimalesDisponibles(){
        return listaAnimalesDisponibles.size();
    }
    
    public AnimalDomestico getAnimalDisponible(int index){
        return listaAnimalesDisponibles.get(index);
    }
    
    public void listarAnimalesDisponibles(){
        if(this.listaAnimalesDisponibles.isEmpty()){
            System.out.println("No hay animales disponibles");
        }
        else{
            for(AnimalDomestico animal: this.listaAnimalesDisponibles ){
                System.out.println((this.listaAnimalesDisponibles.indexOf(animal) +1 ) + "- " + animal.toString());
            }
        }
    }
    
    public void listarAnimalesVendidos(){
        if(this.listaAnimalesVendidos.isEmpty()){
            System.out.println("No se han vendido animales");
        }
        else{
            for(AnimalDomestico animal: this.listaAnimalesVendidos ){
                System.out.println(animal.toString());
            }
        }
    }
    
    public Boolean hayAnimalesDisponibles (){
        return !this.listaAnimalesDisponibles.isEmpty();
    }
    
}
