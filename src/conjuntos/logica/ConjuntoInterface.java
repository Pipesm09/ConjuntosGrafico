package conjuntos.logica;

public interface ConjuntoInterface {

    // --- Métodos de gestión de elementos ---
    int getTamano();

    boolean contiene(int elemento);

    void agregar(int elemento);

    // --- Las 9 Operaciones Matemáticas de Conjuntos ---
    ConjuntoInterface union(ConjuntoInterface otro);

    ConjuntoInterface interseccion(ConjuntoInterface otro);

    ConjuntoInterface diferencia(ConjuntoInterface otro);

    ConjuntoInterface diferenciaSimetrica(ConjuntoInterface otro);

    ConjuntoInterface complemento(ConjuntoInterface universal);

    boolean esSubconjunto(ConjuntoInterface otro);

    boolean esIgual(ConjuntoInterface otro);

    boolean esDisjunto(ConjuntoInterface otro);
}
