package conjuntos.logica;

public class ConjuntoEnVector implements ConjuntoInterface {

    private int[] datos;
    private int tamano;

    public ConjuntoEnVector() {
        this.datos = new int[100]; // Capacidad máxima basada en el límite
        this.tamano = 0;
    }

    @Override
    public int getTamano() {
        return tamano;
    }

    @Override
    public boolean contiene(int elemento) {
        for (int i = 0; i < tamano; i++) {
            if (datos[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregar(int elemento) {
        if (!contiene(elemento) && tamano < datos.length) {
            datos[tamano] = elemento;
            tamano++;
        }
    }

    @Override
    public ConjuntoInterface union(ConjuntoInterface otro) {
        ConjuntoEnVector resultado = new ConjuntoEnVector();
        for (int i = 0; i < this.tamano; i++) {
            resultado.agregar(this.datos[i]);
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
        ConjuntoEnVector resultado = new ConjuntoEnVector();
        for (int i = 0; i < this.tamano; i++) {
            if (otro.contiene(this.datos[i])) {
                resultado.agregar(this.datos[i]);
            }
        }
        return resultado;
    }

    @Override
    public ConjuntoInterface diferencia(ConjuntoInterface otro) {
        ConjuntoEnVector resultado = new ConjuntoEnVector();
        for (int i = 0; i < this.tamano; i++) {
            if (!otro.contiene(this.datos[i])) {
                resultado.agregar(this.datos[i]);
            }
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
        for (int i = 0; i < this.tamano; i++) {
            if (!otro.contiene(this.datos[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean esIgual(ConjuntoInterface otro) {
        return this.esSubconjunto(otro) && otro.esSubconjunto(this);
    }

    @Override
    public boolean esDisjunto(ConjuntoInterface otro) {
        for (int i = 0; i < this.tamano; i++) {
            if (otro.contiene(this.datos[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (tamano == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < tamano; i++) {
            sb.append(datos[i]);
            if (i < tamano - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
