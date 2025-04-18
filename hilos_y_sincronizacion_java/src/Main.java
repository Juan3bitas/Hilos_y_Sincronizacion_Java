public class Main {
    public static void main(String [] args) {
        //Creación de la impresora y los usuarios que la van a usar
        Impresora impresora = new Impresora();

        Empleado empleado1 = new Empleado("Angie Bonilla", "Tralalero_tralala.png");
        Empleado empleado2 = new Empleado("Celeste Buitrago","Albaricoque.docx");
        Empleado empleado3 = new Empleado("Juan Diego", "Acta_de_matrimonio.pdf");
        Empleado empleado4 = new Empleado("Angie Grajales", "Allosaurus.png");
        Empleado empleado5 = new Empleado("David Gómez", "Brawlhalla_stats.png");
        Empleado empleado6 = new Empleado("Juan Sebastián", "Principe_gris_zote.pdf");

        //Se agregan los usuarios que van a imprimir sus documentos a la lista de la impresora

        impresora.agregarEmpleado(empleado1);
        impresora.agregarEmpleado(empleado3);
        impresora.agregarEmpleado(empleado4);

        //Se gestionan las peticiones de los empleados
        impresora.gestionarImpresiones();

        impresora.agregarEmpleado(empleado5);
        impresora.agregarEmpleado(empleado6);
        impresora.agregarEmpleado(empleado2);

        impresora.gestionarImpresiones();
    }
}