/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;

/**
 *
 * @author aleja
 */
import java.awt.TextArea;
import java.util.Date;

public class clsInicio {
    //General
    int dineroMaquina = 100000;
    int transacciones_generales = 0;
    
    //Para transacciones de administradores
    
    int transacciones_administradores =0;
    int cantidad_ingresada_administradores = 0;
    int cantidad_extraida_administradores = 0;
    
    //Para transacciones de clientes
    int transacciones_clientes = 0;
    int cantidad_ingresada_clientes = 0;
    int cantidad_extraida_clientes = 0;
    
    //Listas Administrador
    clsAdministrador clsAdmin = new clsAdministrador();
    clsAdministrador administradores[] = new clsAdministrador[0];
    
    //Variables de listas Administrador
    int posAdministrador = 0;
    boolean listaAdministradores = false;
    

    //Listas Clientes
    clsCliente clsCl = new clsCliente();
    clsCliente clientes[] = new clsCliente[0];
    
    //Variables Listas Clientes
    int poscCliente = 0;
    boolean listacliente = false;
     

    
    public void Verificar(){
        /*Variables dummy*/
        String nombreAdminitradorD = "Ale";
        String contraseñaAdministradorD = "123";
        String nombreClienteD = "Jenny";
        String contraseñaClienteD = "456";
        String tarjetaClienteD = "123456789";
        String pinClienteD  = "1234";
        
        /*Varibles comunes y llamadas a clases*/
        int intentos_Ingreso =3;
        boolean permitir = false;
        clsAdministrador clsA = new clsAdministrador();
        clsHelper clsH = new clsHelper();
        String usuario = "";
        String contrasenna = "";
        String tarjeta = "";
        String pin = "";
        
        char opcion = ' ';//U-Usuario A-Administrador S-Salir
        
        
        /*Se  inicia la verificacion*/        
        do{
            permitir = false;
            opcion = clsH.recibeChar("Ingresa como:\n"
                    + "A) Administrador\n"
                    + "U) Usuario\n"
                    + "S) Salir\n");
            switch(opcion){
                case 'A':
                    while (permitir  == false && intentos_Ingreso != 0){
                        usuario = clsH.recibeString("Digite su identificacion: ");
                        contrasenna = clsH.recibeString("Digite su contraseña: ");
                        if (usuario.equals(nombreAdminitradorD) && contrasenna.equals(contraseñaAdministradorD)){
                            permitir = true;
                            this.MenuAdministrador();
                            intentos_Ingreso =3;
                        }else if(clsA.buscarAdministrador(administradores, posAdministrador, usuario, contrasenna) != -1){
                            permitir = true;
                            this.MenuAdministrador();
                            intentos_Ingreso =3;
                        
                        }else{
                            intentos_Ingreso--;
                            clsH.imprimeMensaje("Contraseña o usuario incorrecto, por favor vuelva a intentear, le quedan "+intentos_Ingreso+" intentos");
                        }
                    }
                break;
                
                
                case 'U':
                    char opcion_ingreso = ' '; 
                    while (permitir  == false && intentos_Ingreso != 0){
                        
                        do{
                            opcion_ingreso = clsH.recibeChar("Digite la manera en la que desea entrar: \n"
                                    + "A) Usuario y contraseña\n"
                                    + "B) Tarjeta y pin\n");
                        }while( opcion_ingreso != 'A' && opcion_ingreso != 'B');
                        
                        if(opcion_ingreso == 'A'){
                            usuario = clsH.recibeString("Digite su identificacion");
                            contrasenna = clsH.recibeString("Digite su contraseña");
                            if (usuario.equals(nombreClienteD) && contrasenna.equals(contraseñaClienteD)){
                                permitir = true;
                                //this.MenuCliente();
                                intentos_Ingreso =3;
                            }else if(clsCl.buscarExistenciaCliente(clientes, poscCliente, usuario, contrasenna) != -1){
                                int pos = clsCl.buscarExistenciaCliente(clientes, poscCliente, usuario, contrasenna);
                                permitir = true;
                                clientes[pos] = this.MenuCliente(clientes[pos]);
                                intentos_Ingreso =3;
                                
                            }else{    
                                intentos_Ingreso--;
                                clsH.imprimeMensaje("Contraseña o usuario incorrecto, por favor vuelva a intentear, le quedan "+intentos_Ingreso+" intentos");
                            }
                            
                        }else{
                            clsCuentas clsC = new clsCuentas();
                            tarjeta = clsH.recibeString("Digite su numero de tarjeta");
                            pin = clsH.recibeString("Digite su pin");
                            if (tarjeta.equals(tarjetaClienteD) && pin.equals(pinClienteD)){
                                permitir = true;
                                //this.MenuCliente();
                                intentos_Ingreso =3;
                            }else if (clsC.buscarExistenciaCuenta(clientes, poscCliente, tarjeta, pin) != -1){
                                permitir = true;
                                int pos = clsC.buscarExistenciaCuenta(clientes, poscCliente, tarjeta, pin);
                                clientes[pos] = this.MenuCliente(clientes[pos]);
                                intentos_Ingreso =3;
                            }else{
                                intentos_Ingreso--;
                                clsH.imprimeMensaje("Numero de tarjeta o pin incorrecto, por favor vuelva a intentear, le quedan "+intentos_Ingreso+" intentos");
                            }
                        }
                    }
                    break;
                    
                case 'S':
                    clsH.imprimeMensaje("Gracias por preferir nuestros servicios");
                break;
                
                default:
                    clsH.imprimeMensaje("Opcion invalida");
                break;
            }
        }while(opcion != 'S' && intentos_Ingreso !=0);
        
        if(permitir == false && intentos_Ingreso == 0){
            clsH.imprimeMensaje("Debido al numero de intentos su cuenta ha sido bloqueada, "
                    + "por favor contacte a un administrador para que esta sea desbloqueada nuevamente");
        }
    }

}
