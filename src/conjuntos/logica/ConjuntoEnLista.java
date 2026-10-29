package conjuntos.logica;

public class ConjuntoEnLista implements ConjuntoInterface {
    private Nodo cabeza;
    private int tamano;

    public ConjuntoEnLista() {
        this.cabeza = null;
        this.tamano = 0;
    }

    @Override
    public int getTamano() {
        return tamano;
    }

    @Override
    public boolean contiene(int elemento) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == elemento) {
                return true;
            }
            actual = actual.getLiga(); // Usando liga
        }
        return false;
    }

    @Override
    public void agregar(int elemento) {
        if (!contiene(elemento)) {
            Nodo nuevo = new Nodo(elemento);
            nuevo.setLiga(cabeza); // Usando liga
            cabeza = nuevo;
            tamano++;
        }
    }

    @Override
    public ConjuntoInterface union(ConjuntoInterface otro) {
        ConjuntoEnLista resultado = new ConjuntoEnLista();
        Nodo actual = cabeza;
        while (actual != null) {
            resultado.agregar(actual.getDato());
            actual = actual.getLiga();
        }
        for (int i = 10; i <= 150; i++) {
            if (otro.contiene(i)) {
                resultado.agregar(i);
            }
        }
        return resultado;
    }

    @Override
    public ConjuntoInterface interseccion(ConjuntoInterface otro) {
        ConjuntoEnLista resultado = new ConjuntoEnLista();
        Nodo actual = cabeza;
        while (actual != null) {
            if (otro.contiene(actual.getDato())) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getLiga();
        }
        return resultado;
    }

    @Override
    public ConjuntoInterface diferencia(ConjuntoInterface otro) {
        ConjuntoEnLista resultado = new ConjuntoEnLista();
        Nodo actual = cabeza;
        while (actual != null) {
            if (!otro.contiene(actual.getDato())) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getLiga();
        }
        return resultado;
    }

    @Override
    public ConjuntoInterface diferenciaSimetrica(ConjuntoInterface otro) {
        ConjuntoInterface u = this.union(otro);
        ConjuntoInterface i = this.interseccion(otro);
        return u.diferencia(i);
    }

    @Override
    public ConjuntoInterface complemento(ConjuntoInterface universal) {
        return universal.diferencia(this);
    }

    @Override
    public boolean esSubconjunto(ConjuntoInterface otro) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (!otro.contiene(actual.getDato())) {
                return false;
            }
            actual = actual.getLiga();
        }
        return true;
    }

    @Override
    public boolean esIgual(ConjuntoInterface otro) {
        return this.esSubconjunto(otro) && otro.esSubconjunto(this);
    }

    @Override
    public boolean esDisjunto(ConjuntoInterface otro) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (otro.contiene(actual.getDato())) {
                return false;
            }
            actual = actual.getLiga();
        }
        return true;
    }

    @Override
    public String toString() {
        if (cabeza == null) return "{}";
        StringBuilder sb = new StringBuilder("{");
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getLiga() != null) sb.append(", ");
            actual = actual.getLiga();
        }
        sb.append("}");
        return sb.toString();
    }
}