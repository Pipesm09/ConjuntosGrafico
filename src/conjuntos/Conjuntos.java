package conjuntos;

import conjuntos.igu.VentanaPrincipal;

public class Conjuntos {

    public static void main(String[] args) {
        // 1. Instanciar la primera pantalla (VentanaPrincipal)
        VentanaPrincipal principal = new VentanaPrincipal();

        // 2. Hacerla visible en pantalla
        principal.setVisible(true);

        // 3. Centrar la ventana en la pantalla
        principal.setLocationRelativeTo(null);
    }
}
