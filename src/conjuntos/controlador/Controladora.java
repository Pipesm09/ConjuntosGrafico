package conjuntos.controlador;

import conjuntos.logica.*;

public class Controladora {

    private ConjuntoInterface universalActual;

    // Atributos para el Conjunto A (Vector y Lista)
    private ConjuntoEnVector conjuntoAVector;
    private ConjuntoEnLista conjuntoALista;

    // Atributos para el Conjunto B (Vector y Lista)
    private ConjuntoEnVector conjuntoBVector;
    private ConjuntoEnLista conjuntoBLista;

    // Método para generar el Universo
    public ConjuntoInterface generarUniverso(int tamano, boolean esVector) throws Exception {
        this.universalActual = GeneradorUniverso.generar(tamano, esVector);
        return this.universalActual;
    }

    // Getters y Setters para el Universo
    public ConjuntoInterface getUniversalActual() {
        return universalActual;
    }

    public void setUniversalActual(ConjuntoInterface universalActual) {
        this.universalActual = universalActual;
    }

    // Getters y Setters para Conjunto A
    public ConjuntoEnVector getConjuntoAVector() {
        return conjuntoAVector;
    }

    public void setConjuntoAVector(ConjuntoEnVector conjuntoAVector) {
        this.conjuntoAVector = conjuntoAVector;
    }

    public ConjuntoEnLista getConjuntoALista() {
        return conjuntoALista;
    }

    public void setConjuntoALista(ConjuntoEnLista conjuntoALista) {
        this.conjuntoALista = conjuntoALista;
    }

    // Getters y Setters para Conjunto B
    public ConjuntoEnVector getConjuntoBVector() {
        return conjuntoBVector;
    }

    public void setConjuntoBVector(ConjuntoEnVector conjuntoBVector) {
        this.conjuntoBVector = conjuntoBVector;
    }

    public ConjuntoEnLista getConjuntoBLista() {
        return conjuntoBLista;
    }

    public void setConjuntoBLista(ConjuntoEnLista conjuntoBLista) {
        this.conjuntoBLista = conjuntoBLista;
    }
}
