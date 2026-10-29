package conjuntos.logica;

import java.util.Random;

public class GeneradorUniverso {

    public static ConjuntoInterface generar(int tamano, boolean esVector) throws Exception {
        // Validamos el rango solicitado (entre 10 y 100)
        if (tamano < 10 || tamano > 100) {
            throw new Exception("El tamaño del Universo debe estar entre 10 y 100.");
        }

        ConjuntoInterface universal = esVector ? new ConjuntoEnVector() : new ConjuntoEnLista();
        Random rand = new Random();

        // Para hasta 90 usa números de 2 dígitos (10-99).
        // Si pide más de 90, amplía el rango a 150 para garantizar números únicos.
        int limiteRango = (tamano <= 90) ? 90 : 141;

        while (universal.getTamano() < tamano) {
            int num = rand.nextInt(limiteRango) + 10;
            universal.agregar(num); // El método agregar descarta duplicados
        }

        return universal;
    }
}