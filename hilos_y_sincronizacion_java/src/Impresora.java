import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Impresora {
    private List<Empleado> empleados;
    private static final int maxUsuarios = 1;
    private static final Semaphore semaforo = new Semaphore(maxUsuarios);

    public Impresora() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void imprimir(Empleado empleado) {
        try {
            //El empleado pide acceso para imprimir
            semaforo.acquire();
            System.out.println(empleado.getNombre() +  " está imprimiendo " + empleado.getDocumento() + ".");
            //Simula el tiempo de espera para imprimir el documento
            Thread.sleep(5000);
            System.out.println(empleado.getNombre() + " terminó de imprimir su documento.\n");
            //Elimina al empleado de la lista luego de imprimir su documento
            empleados.remove(empleado);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        } finally {
            //Libera la impresora para que otro empleado la use
            semaforo.release();
        }
    }

    public void gestionarImpresiones() {
        Thread[] hilos = new Thread[empleados.size()];

        //La impresora recibe todas las solicitudes de los empleados
        for (int i = 0; i < empleados.size(); i++) {
            final Empleado empleado = empleados.get(i);
            hilos[i] = new Thread(() -> imprimir(empleado));
            hilos[i].start();
        }

        //Cada empleado pide su cupo para imprimir
        for (Thread hilo: hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Terminan los pedidos
        System.out.println("Todos los empleados ya imprimieron sus documentos.\n");
    }
}