package modernsupermarket;

/**
 *
 * @author Daniel Marcos Lorrio
 * @version 1 01/12/2015
 */
public class ModernSuperMarket {

    // Numero de cajas
    public static int cajas;
    // Numero de clientes
    public static int clientes;
    // Contador de clientes que han acabado
    public static int clientesAtendidos = 0;
    // Variable que almacenara la recaudacion del supermercado
    public static int recaudacion = 0;
    // Array de booleans para los estados de las cajas
    public static boolean estadoCaja[];

    /**
     * Metodo main que lanzara el programa
     *
     * @param args No se usa
     */
    public static void main(String[] args) {
        // Calculamos el numero de clientes
        clientes = Metodos.calcularClientes();

        // Calculamos el numero de cajas
        cajas = Metodos.calcularCajas();

        // Inicializamos los estados de las cajas
        estadoCaja = new boolean[cajas];
        Metodos.inicializarCajas();

        // Generamos la ventana
        new Ventana(cajas);

        // Inicializamos la clase Caja
        Caja c = new Caja();

        // Mostramos los valores de cajas y clientes
        System.out.println("Han entrado " + clientes + " clientes.\n"
                + "Hay " + cajas + " cajas operativas.");

        // Creamos y lanzamos los clientes
        for (int i = 0; i < clientes; i++) {
            new Cliente(i, c).start();
        }
    }
}
