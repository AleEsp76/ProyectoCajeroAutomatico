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
    
    public void listarAdministradores(clsAdministrador administradores[], int posAdministrador){
        String impresion = "Identificacion\tNombre\tPuesto\tContraseña\tAño de Ingreso\n";
        clsHelper clsH = new clsHelper();
        for (int i = 0; i<posAdministrador; i++){
            impresion += "\n"+administradores[i].toString()+"\n";
        }
            clsH.imprimeMensaje(new TextArea(impresion));
    }
        
}
