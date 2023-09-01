/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;

import java.awt.TextArea;

/**
 *
 * @author aleja
 */
public class clsAdministrador {
    private String Identificacion;
    private String Nombre;
    private String Puesto;
    private String Contrasenna;
    private String AnnoIngreso;
    private char Habilitado; //H-Habilitado, D-Deshabilitado

    public clsAdministrador(String Identificacion, String Nombre, String Puesto, String Contrasenna, String AnnoIngreso, char Habilitado) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
        this.Contrasenna = Contrasenna;
        this.AnnoIngreso = AnnoIngreso;
        this.Habilitado = Habilitado; //H-Habilitado, D-Desabilitado
    }

    public clsAdministrador() {
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPuesto() {
        return Puesto;
    }

    public String getContrasenna() {
        return Contrasenna;
    }

    public String getAnnoIngreso() {
        return AnnoIngreso;
    }

    public char getHabilitado() {
        return Habilitado;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public void setContrasenna(String Contrasenna) {
        this.Contrasenna = Contrasenna;
    }

    public void setAnnoIngreso(String AnnoIngreso) {
        this.AnnoIngreso = AnnoIngreso;
    }

    public void setHabilitado(char Habilitado) {
        this.Habilitado = Habilitado;
    }

    @Override
    public String toString() {
        return Identificacion + "\t" + Nombre + "\t" + Puesto + "\t" + Contrasenna + "\t" + AnnoIngreso;
    }
    
    public clsAdministrador[] generarlistaAdministrador(){
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("Digite la cantidad de administradores que desea almacenar");
        clsAdministrador administradores[] = new clsAdministrador[tamano];
        return administradores;
    }
    
    public int agregarCliente(clsAdministrador administradores[], int posAdministrador){
        clsHelper clsH = new clsHelper();
        String Identificacion = clsH.recibeString("Digite la identifacion:");
        String Nombre = clsH.recibeString("Digite el nombre completo:");
        String Puesto = clsH.recibeString("Digite el puesto:");
        String Contrasenna = clsH.recibeString("Digite la contraseña:");
        String AnnoIngreso = clsH.recibeString("Digite el año de ingreso:");
        char Habilitado = 'H';
        administradores[posAdministrador]= new clsAdministrador(Identificacion, Nombre, Puesto, Contrasenna, AnnoIngreso, Habilitado);
        posAdministrador++;
        return posAdministrador;
    }
    
    public int obtenerPosAdministrador(clsAdministrador administradores[], int posAdministrador, String accion) {
        clsHelper clsH = new clsHelper();
        String identificacionBuscar = clsH.recibeString("Digite la identificacion del administrador que desea"+accion+":");
        int posAdministradorBuscado = -1;
        for (int i = 0; i < posAdministrador; i++) {
            if (identificacionBuscar.equalsIgnoreCase(administradores[i].getIdentificacion())) {
                posAdministradorBuscado = i;
                break;
            }
        }
        return posAdministradorBuscado;
    }

    public clsAdministrador[] modificarAdministrador(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosAdministrador(administradores, posAdministrador, "modificar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron administradores con el nombre indicado, intente nuevamente");
        } else {
            char opcion = ' ';
            do {
                opcion = clsH.recibeChar("Seleccione el tipo de dato que desea modificar: "
                        + "\n A. Nombre"
                        + "\n B. Puesto"
                        + "\n C. Contrasenna"
                        + "\n D. Año de Ingreso"
                        + "\n S. Salir");

                switch (opcion) {
                    case 'A':
                        administradores[pos].setNombre(clsH.recibeString("Digite el nuevo nombre completo del administrador:"));
                        break;
                    case 'B':
                        administradores[pos].setPuesto(clsH.recibeString("Digite el nuevo puesto del administrador:"));
                        break;
                    case 'C':
                        administradores[pos].setContrasenna(clsH.recibeString("Digite la nueva contrasenna del Administrador"));
                        break;
                    case 'D':
                        administradores[pos].setAnnoIngreso(clsH.recibeString("Digite el nuevo anno de ingreso del Administrador"));
                        break;
                    case 'S':
                        clsH.imprimeMensaje("Los datos se han modificado exitosamente");
                        break;
                    default:
                        clsH.imprimeMensaje("La opcion no es valida");
                }

            } while (opcion != 'S');
        }
        return administradores;
    }

    
    
     public int revisarIdentificacion (clsAdministrador administradores[], int posAdministrador, String Identificacion, int existe){
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posAdministrador; i++) {
            if (Identificacion.equalsIgnoreCase(administradores[i].getIdentificacion())) {
                existe++;
                break;
            }
        } 
        if (existe>0){
            clsH.imprimeMensaje("Este numero de identificacion ya existe");
        }
        return existe;
    }
    
    public int agregarAdministrador(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        do{
            Identificacion = clsH.recibeString("Digite la identifacion:");
        }while(revisarIdentificacion(administradores, posAdministrador, Identificacion,0) != 0);
        
        Nombre = clsH.recibeString("Digite el nombre completo:");
        Puesto = clsH.recibeString("Digite el puesto:");
        Contrasenna = clsH.recibeString("Digite la contraseña:");
        AnnoIngreso = clsH.recibeString("Digite el año de ingreso:");
        do{
            Habilitado = clsH.recibeChar("Digite si el administrador esta S - habilitado o N - desabilitado");
        }while(Habilitado != 'S' && Habilitado != 'N');
        administradores[posAdministrador] = new clsAdministrador(Identificacion, Nombre, Puesto, Contrasenna, AnnoIngreso, Habilitado);
        posAdministrador++;
        return posAdministrador;
    }
    
    
    
    public void deshabilitarAdministrador(clsAdministrador administradores[],int posAdministrador){
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosAdministrador(administradores, posAdministrador, "habilitar o deshabilitar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron administradores con la identificacion indicada, intente nuevamente");
        } else {
            if (administradores[pos].getHabilitado() == 'S'){
                administradores[pos].setHabilitado('N');
                clsH.imprimeMensaje("El administrador ha sido deshabilitado de forma correcta");
            }else{
                administradores[pos].setHabilitado('S');
                clsH.imprimeMensaje("El administrador ha sido habilitado de forma correcta");
            }
        }  
    }    
    
    
    
     public int buscarAdministrador(clsAdministrador administradores[], int posAdministrador, String identificacion, String contrasenna){
        int posAdministradorBuscado = -1;
        for (int i = 0; i < posAdministrador; i++) {
            if (identificacion.equalsIgnoreCase(administradores[i].getIdentificacion()) && contrasenna.equalsIgnoreCase(administradores[i].getContrasenna())) {
                posAdministradorBuscado = i;
                break;
            }
        }
        return posAdministradorBuscado;
    }
     
     public void extraccionAdministrador(int dinero_a_extraer){
        clsHelper clsH = new clsHelper();
        int [] denominaciones = {20000, 10000, 5000, 2000, 1000};
        int [] cantidades = new int[denominaciones.length];
        
        
        String imprimir = "La transaccion se le dara de la siguiente manera:\nCantidad \t Denominacion \n";
        for (int i = 0; i < denominaciones.length; i++) {
            int cantidad = dinero_a_extraer / denominaciones[i];
            cantidades[i] = cantidad;
            dinero_a_extraer %= denominaciones[i];
            if(cantidad >= 1){
                imprimir += cantidades[i] + " \t " + denominaciones[i]+ " colones \n";
        
            }
        }
        clsH.imprimeMensaje(imprimir);
    }
     
      public void desglosar(int dineroMaquina){
        clsHelper clsH = new clsHelper();
        int [] denominaciones = {20000, 10000, 5000, 2000, 1000};
        int [] cantidades = new int[denominaciones.length];
        
        int monto = 0;
        String imprimir = "Cantidad \t Denominacion \n";
        for (int i = 0; i < denominaciones.length; i++) {
            monto = dineroMaquina;
            int cantidad = monto / denominaciones[i];
            cantidades[i] = cantidad;
            monto %= denominaciones[i];
            imprimir += cantidades[i] + " \t " + denominaciones[i]+ " colones \n";
        }
        clsH.imprimeMensaje(imprimir);
    }
        
}
