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
public class clsCliente {
    String Identificacion = "";
    char Sexo =' ';//M-masculino, F-feminino
    String FechaNacimiento = "";
    float IngresoAprox = 0;
    String NombreCompleto = "";
    String LugarResidencia = "";
    String Correo = "";
    String NumeroTelefono = "";
    String Contrasenna = "";
    
    private clsCuenta listaCuentas[];
    private int cantidadCuentas;
    
    public clsCliente() {
    }
    
    public clsCliente(String Identificacion, String NombreCompleto, char Sexo, String FechaNacimiento, float IngresoAprox, String LugarResidencia, String Correo, String NumeroTelefono, String Contrasenna){
        this.Identificacion = Identificacion;
        this.NombreCompleto = NombreCompleto;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.IngresoAprox = IngresoAprox;
        this.LugarResidencia = LugarResidencia;
        this.Correo = Correo;
        this.NumeroTelefono = NumeroTelefono;
        this.Contrasenna = Contrasenna;
        this.cantidadCuentas = -1;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public char getSexo() {
        return Sexo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public float getIngresoAprox() {
        return IngresoAprox;
    }

    public String getLugarResidencia() {
        return LugarResidencia;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContrasenna() {
        return Contrasenna;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public clsCuenta[] getListaCuentas() {
        return listaCuentas;
    }

    public int getCantidadCuentas() {
        return cantidadCuentas;
    }
    
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public void setIngresoAprox(float IngresoAprox) {
        this.IngresoAprox = IngresoAprox;
    }

    public void setLugarResidencia(String LugarResidencia) {
        this.LugarResidencia = LugarResidencia;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setNumeroTelefono(String NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public void setContrasenna(String Contrasenna) {
        this.Contrasenna = Contrasenna;
    }

    public void setListaCuentas(clsCuenta[] listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void setCantidadCuentas(int cantidadCuentas) {
        this.cantidadCuentas = cantidadCuentas;
    }
    

    @Override
    public String toString() {
        return "\t" + Identificacion + "\t" + NombreCompleto + "\t" + Sexo + "\t" + FechaNacimiento + "\t" + IngresoAprox + "\t" + LugarResidencia + "\t" + Correo + "\t" + NumeroTelefono;
    }
    
    public clsCliente[] generarListaClientes(){
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("¿Cuantos clientes usaran su banco?");
        clsCliente clientes[]= new clsCliente [tamano];
        return clientes;
        
    }
    
    public int revisarIdentificacion (clsCliente clientes[], int posCliente, String Identificacion, int existe){
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posCliente; i++) {
            if (Identificacion.equalsIgnoreCase(clientes[i].getIdentificacion())) {
                existe++;
                break;
            }
        } 
        if (existe>0){
            clsH.imprimeMensaje("Este numero de identificacion ya existe");
        }
        return existe;
    }
    
    
    public int agregarcliente(clsCliente clientes[], int poscCliente){
         clsHelper clsH = new clsHelper();
         do{
            Identificacion = clsH.recibeString("Digite la cédula del cliente: ");
         }while(revisarIdentificacion(clientes, poscCliente, Identificacion,0) != 0);
         
         NombreCompleto = clsH.recibeString("Digite el nombre del cliente: ");
         Sexo = ' ';
         
         do {
            Sexo =clsH.recibeChar("Ingrese el sexo del cliente segun la leyenda mostrada"
                 + "\n M. Masculino"
                 + "\n F. Femenino"
                 + "\n N. No binario \n"); 
         }while(Sexo != 'M' && Sexo != 'F' && Sexo != 'N');
         
         FechaNacimiento = clsH.recibeString("Digite la fecha de nacimiento del cliente: \n Formato DD-MM-AA ");
         LugarResidencia= clsH.recibeString("Digite la direccion del cliente: ");
         Correo= clsH.recibeString("Digite el correo electronico del cliente: ");
         NumeroTelefono= clsH.recibeString("Digite el número de teléfono del cliente: ");
         IngresoAprox = clsH.recibeFloat("Digite su ingreso aproximado: ");
         Contrasenna = clsH.recibeString("Diite la contraseña deseada: ");
         
         clientes[poscCliente] = new clsCliente(Identificacion,NombreCompleto,Sexo,FechaNacimiento,IngresoAprox  ,LugarResidencia, Correo, NumeroTelefono, Contrasenna);
         poscCliente++;
         return poscCliente;
    }
    
    public void listarclientes(clsCliente clientes[], int poscCliente){
        clsHelper clsH = new clsHelper();
        String impresion = "Identificacion   \tNombre   \tSexo   \tFechaNacimiento  \tIngresoAprox   \tResidencia   \tCorreo    \tNumeroTelefono    \n";
        for(int i= 0;  i < poscCliente; i++){
            impresion += clientes[i].toString()+ "\n";        
            }
        clsH.imprimeMensaje(new TextArea(impresion));
    }
    
    
    public int buscarposccliente(clsCliente clientes[], int poscCliente, String accion){
        clsHelper clsH = new clsHelper();
        int poscusuario = -1;
        String buscarIdentificacion = clsH.recibeString("Ingrese la identificacion del cliente que desea "+accion);
        for(int i=0; i< poscCliente; i++){
            if(buscarIdentificacion.equalsIgnoreCase(clientes[i].getIdentificacion())){
               poscusuario = i;
               break;
            }
        }
        return poscusuario;
    }
    
    public void modificarCliente(clsCliente clientes[], int poscClientes){
        clsHelper clsH = new clsHelper();
         int poscusuario = this.buscarposccliente(clientes, poscClientes, "modificar");
         if (poscusuario ==-1){
             clsH.imprimeMensaje("No hay clientes registrados con los terminos utilizados");
         }else{
            char mod = ' ';
            do{
                mod= clsH.recibeChar("Elija el valor a modificar"
                        + "\n A.Identificacion\n"
                        + "B. Nombre\n"
                        + "C. Sexo\n"
                        + "D. Fecha de Nacimiento\n"
                        + "E. Residencia\n"
                        + "F. Correo\n"
                        + "G. Numero de Telefono\n"
                        + "H. Ingreso Aproximado\n"
                        + "I. Contraseña\n"
                        + "R. Regresar");
                        switch (mod){
                            case 'A':
                                do{
                                    clientes[poscusuario].setIdentificacion(clsH.recibeString("Ingrese el número de cédula del cliente"));
                                }while(revisarIdentificacion(clientes, poscClientes, clientes[poscusuario].getIdentificacion(),0) != 0);
                                break;
                            case 'B':
                                clientes[poscusuario].setNombreCompleto(clsH.recibeString("Ingrese el nombre del cliente"));
                                break;
                            case 'C':
                                do{
                                    clientes[poscusuario].setSexo(clsH.recibeChar("Ingrese el sexo del cliente segun la leyenda mostrada"
                                                                                + "\n M. Masculino"
                                                                                + "\n F.Femenino"
                                                                                + "\n N. No binario \n"));
                                
                                }while(clientes[poscusuario].getSexo() != 'M' && clientes[poscusuario].getSexo() != 'F' && clientes[poscusuario].getSexo() != 'N');
                                break;
                            case 'D':
                                clientes[poscusuario].setFechaNacimiento(clsH.recibeString("Digite la fecha de nacimiento del cliente: \n Formato DD-MM-AA "));
                                break;
                            case 'E':
                                clientes[poscusuario].setLugarResidencia(clsH.recibeString("Ingrese la dirección del cliente"));
                                break;
                            case 'F':
                                clientes[poscusuario].setCorreo(clsH.recibeString("Ingrese el correo electronico del cliente"));
                                break;
                            case 'G':
                                clientes[poscusuario].setNumeroTelefono(clsH.recibeString("Ingrese el numero número de telefono del cliente"));
                                break;
                            case 'H':
                                clientes[poscusuario].setIngresoAprox(clsH.recibeFloat("Ingrese el ingreso aproximado: "));
                                break;
                            case 'I':
                                clientes[poscusuario].setContrasenna(clsH.recibeString("Digite la nueva contraseña: "));
                            case 'R':
                                clsH.imprimeMensaje("Los datos han sido modificados correctamente");
                                break;   
                            default:
                                clsH.imprimeMensaje("Opción invalida");                                
                        }
            }while(mod != 'R');
            clsH.imprimeMensaje("Información modificada de manera exitosa");
         }
    }
    
    public int eliminarCliente(clsCliente clientes[], int poscCliente){
        clsHelper clsH =new clsHelper();
        int poscusuario = this.buscarposccliente(clientes, poscCliente, "eliminar");
        if(poscusuario == -1){
            clsH.imprimeMensaje("No se encontraron coincidencias.");
        }else{
            for (int i=poscusuario; i< poscCliente -1; i++){
                clientes[i]=clientes[i+1];
            }
            poscCliente-=1;
            clientes[poscCliente]=null;
            clsH.imprimeMensaje("El cliente ha sido eliminado.");
        }
        return poscCliente;
    }
    
    
    public void buscarcliente(clsCliente clientes[], int posCliente){
        clsHelper clsH = new clsHelper();
        int poscusuario = this.buscarposccliente(clientes, posCliente, "buscar");
        if(poscusuario == -1){
            clsH.imprimeMensaje("No se encontraron coincidencias");
        }else{
            clsH.imprimeMensaje("Los datos del cliente son: \n"
            +"Identificación: "+clientes[poscusuario].getIdentificacion()+"\n"
            +"Nombre: "+ clientes[poscusuario].getNombreCompleto()+"\n"
            +"Sexo: "+clientes[poscusuario].getSexo()+"\n"
            +"Fecha de nacimiento: "+clientes[poscusuario].getFechaNacimiento()+"\n"
            +"Residencia: "+clientes[poscusuario].getLugarResidencia()+"\n"
            +"Correo: "+clientes[poscusuario].getCorreo()+"\n"
            +"Teléfono: "+clientes[poscusuario].getNumeroTelefono()+"\n");           
            }
        }
    
    
    public int buscarExistenciaCliente(clsCliente clientes[], int posCliente, String identificacion, String contrasenna){
        int posClienteBuscado = -1;
        for (int i = 0; i < posCliente; i++) {
            if (identificacion.equalsIgnoreCase(clientes[i].getIdentificacion()) && contrasenna.equalsIgnoreCase(clientes[i].getContrasenna())) {
                posClienteBuscado = i;
                break;
            }
        }
        return posClienteBuscado;
    }
}
