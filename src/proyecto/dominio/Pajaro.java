package proyecto.dominio;

public class Pajaro extends AnimalDomestico {

    public Pajaro(float peso, int edad) {
        super(peso, edad);
    }

    @Override
    public float calcularPrecio() {

        if (edad <= 1) {
            if (peso <= 10) {
                return 5000;
            } else {
                return 5000 + (int) ((peso - 10) / 5) * (100);
            }
        }
        if (edad > 1 && edad <= 3) {
            if (peso <= 15) {
                return 12000;
            } else {
                return 12000 + (int) ((peso - 15) / 5) * (100);
            }
        }
        if (edad > 3 && edad < 6) {
            if (peso <= 18) {
                return 18000;
            } else {
                return 20000;
            }
        }
        if (edad >= 6) {
            return 25000;
        }

        return 0;
    }

    @Override
    public float calcularUtilidad() {
        return calcularPrecio() * 0.15f;
    }

    @Override
    public String getNombreClase() {
        return "Pájaro";
    }

}
