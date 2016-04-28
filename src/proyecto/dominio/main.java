package proyecto.dominio;

import java.util.Scanner;
import javax.xml.bind.annotation.XmlElement;

public class main {

    private static final Inventario inventario = new Inventario();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opc;
        Boolean salir = false;
        while (!salir) {
            System.out.println("Menú tienda");
            System.out.println("1. Compra animal");
            System.out.println("2. Venta animal");
            System.out.println("3. Calcular utilidad");
            System.out.println("4. Animales disponibles");
            System.out.println("5. Animales vendidos");
            System.out.println("6. Salir");
            System.out.println("Digita la Opción Deseada");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    agregarAnimal();
                    break;
                case 2:
                    venderAnimal();
                    break;
                case 3:
                    System.out.println("La ultilidad actual es: " + inventario.calcularUtilidad());
                    break;
                case 4:
                    inventario.listarAnimalesDisponibles();
                    break;
                case 5:
                    inventario.listarAnimalesVendidos();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;

            }
        }
    }

    private static void crearCachorro() {
        System.out.println("Ingrese el peso en gramos:");
        float peso = teclado.nextFloat();
        System.out.println("Ingrese la edad en semanas:");
        int edad = teclado.nextInt();
        inventario.agregarAnimal(new Cachorro(peso, edad));
    }

    private static void crearGato() {
        System.out.println("Ingrese el peso en gramos:");
        float peso = teclado.nextFloat();
        System.out.println("Ingrese la edad en semanas:");
        int edad = teclado.nextInt();
        inventario.agregarAnimal(new Gato(peso, edad));
    }

    private static void crearPajaro() {
        System.out.println("Ingrese el peso en gramos:");
        float peso = teclado.nextFloat();
        System.out.println("Ingrese la edad en semanas:");
        int edad = teclado.nextInt();
        inventario.agregarAnimal(new Pajaro(peso, edad));
    }

    private static void crearPez() {
        System.out.println("Ingrese el peso en gramos:");
        float peso = teclado.nextFloat();
        System.out.println("Ingrese la edad en semanas:");
        int edad = teclado.nextInt();
        Pez.RazaPez raza = darRazaPez();
        inventario.agregarAnimal(new Pez(peso, edad, raza));
    }

    private static void agregarAnimal() {
        System.out.println("Ingrese el tipo de animal");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        System.out.println("3. Pajaro");
        System.out.println("4. Pez");
        System.out.println("Digita la Opción Deseada");
        int opc = teclado.nextInt();
        switch (opc) {
            case 1:
                crearCachorro();
                break;
            case 2:
                crearGato();
                break;
            case 3:
                crearPajaro();
                break;
            case 4:
                crearPez();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private static Pez.RazaPez darRazaPez() {
        Pez.RazaPez raza = null;
        while (raza == null) {
            System.out.println("Elija la raza de pez que va a comprar:");
            System.out.println("1. Loricárido");
            System.out.println("2. Killis");
            System.out.println("3. Laberíntido");
            System.out.println("4. Corydoras");
            int opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    raza = Pez.RazaPez.LORICARIDO;
                    break;
                case 2:
                    raza = Pez.RazaPez.KILIS;
                    break;
                case 3:
                    raza = Pez.RazaPez.LABERINTIDO;
                    break;
                case 4:
                    raza = Pez.RazaPez.CORYDORAS;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        return raza;

    }

    private static void venderAnimal() {
        if (inventario.hayAnimalesDisponibles()) {
            inventario.listarAnimalesDisponibles();
            System.out.println("¿Qué animal desea vender?");
            int numeroVenta = teclado.nextInt();
            if (numeroVenta > 0 && numeroVenta <= inventario.numeroAnimalesDisponibles()) {
                AnimalDomestico animalVenta = inventario.getAnimalDisponible(numeroVenta - 1);
                inventario.venderAnimal(animalVenta);
                System.out.println("Animal vendido");
            } else {
                System.out.println("Número inválido");
            }
            
        } else {
            System.out.println("No hay animales disponibles");
        }

    }
}
