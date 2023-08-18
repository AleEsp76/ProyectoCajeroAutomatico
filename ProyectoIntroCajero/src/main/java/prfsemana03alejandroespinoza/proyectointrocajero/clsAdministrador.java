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
        return Identificacion + "\t" + Nombre + "\t" + Puesto + "\t" + Contrasenna + "\t" + AnnoIngreso + "\t" + Habilitado;
    }

    public clsAdministrador[] generarlistaAdministrador() {
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("Digite la cantidad de administradores que desea almacenar");
        clsAdministrador administradores[] = new clsAdministrador[tamano];
        return administradores;
    }

    public int agregarAdministrador(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        String Identificacion = clsH.recibeString("Digite la identifacion:");
        String Nombre = clsH.recibeString("Digite el nombre completo:");
        String Puesto = clsH.recibeString("Digite el puesto:");
        String Contrasenna = clsH.recibeString("Digite la contraseña:");
        String AnnoIngreso = clsH.recibeString("Digite el año de ingreso:");
        char Habilitado = 'S';
        administradores[posAdministrador] = new clsAdministrador(Identificacion, Nombre, Puesto, Contrasenna, AnnoIngreso, Habilitado);
        posAdministrador++;
        return posAdministrador;
    }

    public int obtenerPosAdministrador(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibeString("Digite el nombre del administrador que desea modificar:");
        int posAdministradorBuscado = -1;
        for (int i = 0; i < posAdministrador; i++) {
            if (nombreBuscar.equalsIgnoreCase(administradores[i].getNombre())) {
                posAdministradorBuscado = i;
                break;
            }
        }
        return posAdministradorBuscado;
    }

    public clsAdministrador[] modificarAdministrador(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosAdministrador(administradores, posAdministrador);
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron administradores con el nombre indicado, intente nuevamente");
        } else {
            char opcion = 'S';
            do {
                opcion = clsH.recibeChar("Seleccione el tipo de dato que desea modificar: "
                        + "\n A. Nombre"
                        + "\n B. Puesto"
                        + "\n C. Contrasenna"
                        + "\n D. Anno de Ingreso"
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

    public clsAdministrador[] cambiarEstadoHabilitadoDeshabilitado(clsAdministrador administradores[], int posAdministrador) {
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosAdministrador(administradores, posAdministrador);
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron administradores con el nombre indicado, intente nuevamente");
        } else {
            char nuevoEstado;

            if (administradores[pos].getHabilitado() == 'S') {
                nuevoEstado = 'N';
                clsH.imprimeMensaje("El administrador ha sido deshabilitado");
            } else {
                nuevoEstado = 'S';
                clsH.imprimeMensaje("El administrador ha sido habilitado");
            }

            administradores[pos].setHabilitado(nuevoEstado);
            
        }
        return administradores;
    }

    public void listarAdministradores(clsAdministrador administradores[], int posAdministrador) {
        String impresion = "Identificacion\tNombre\tPuesto\tContraseña\tAño de Ingreso\tHabilitado\n";
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posAdministrador; i++) {
            impresion += "\n" + administradores[i].toString() + "\n";
        }
        clsH.imprimeMensaje(new TextArea(impresion));
    }

}
