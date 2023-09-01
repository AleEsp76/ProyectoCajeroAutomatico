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
    
    public void MenuAdministrador(){
        //Llamadas de clses
        clsHelper clsH = new clsHelper();

        //Opciones
        char opcion = ' ';
        
        //Transacciones 
        int dinero_a_introducir = 0;
        int dinero_a_extraer = 0;
        boolean permitido = false;
        
        do{
            opcion = clsH.recibeChar("Seleccione una de las siguientes opciones:\n"
                    + "A. Generar lista administradores\n"
                    + "B. Agregar Administrador\n"
                    + "C. Modificar Administrador\n"
                    + "D. Habilitar/Deshabilitar Administrador\n"
                    + "E. Listar Administradores\n"
                    + "F  Administrar Clientes\n"
                    + "G. Extraccion o Ingreso de dinero\n" 
                    + "H. Reportes\n"
                    + "S. Sair");   
            switch (opcion) {
                case 'A':
                    if (listaAdministradores) {
                        char nuevaLista = ' ';
                        do {
                            nuevaLista = clsH.recibeChar("¿Desea generar una nueva lista? \n S - Si \n N - No");
                        } while (nuevaLista != 'S' && nuevaLista != 'N');
                        if (nuevaLista == 'S') {
                            administradores = clsAdmin.generarlistaAdministrador();
                            posAdministrador = 0;
                            listaAdministradores = true;
                        }
                    } else {
                        clsH.imprimeMensaje("Se genera una lista de administradores nueva");
                        administradores = clsAdmin.generarlistaAdministrador();
                        clsH.imprimeMensaje("Lista de administradores generada");
                        listaAdministradores = true;
                    }
                    break;
                case 'B':
                    clsH.imprimeMensaje("Se agrega un administrador");
                    if (listaAdministradores) {
                        if (posAdministrador < administradores.length) {
                            posAdministrador = clsAdmin.agregarAdministrador(administradores, posAdministrador);
                            clsH.imprimeMensaje("El administrador ha sido agregado exitosamente");
                        } else {
                            clsH.imprimeMensaje("La lista de administradores se ha llenado");
                        }
                    } else {
                        clsH.imprimeMensaje("Lista de administradores aun no ha sido generada generada");
                    }
                    break;
                case 'C':
                    if (posAdministrador == 0) {
                    clsH.imprimeMensaje("No existen administradores, agregue uno primero");
                    } else {
                    clsH.imprimeMensaje("Se modifica un administrador");
                    administradores = clsAdmin.modificarAdministrador(administradores, posAdministrador);
                    }
                    break;
                case 'D':
                    if (posAdministrador == 0) {
                        clsH.imprimeMensaje("No existen administradores, agregue uno primero");
                    } else {
                        clsAdmin.deshabilitarAdministrador(administradores, posAdministrador);
                    //administradores = clsAdmin.cambiarEstadoHabilitadoDeshabilitado(administradores, posAdministrador);
                    }
                    break;
                case 'E':
                    clsH.imprimeMensaje("Se listan los administradores");
                    if (listaAdministradores) {
                        if (posAdministrador == 0) {
                            clsH.imprimeMensaje("No hay clientes para mostrar en la lista");
                        } else {
                            clsAdmin.listarAdministradores(administradores, posAdministrador);
                        }
                    } else {
                        clsH.imprimeMensaje("Aun no se ha generado una lista");
                    }
                    break;
                case 'F':
                    this.MenuAdministrarClientes();
                    break;
                case 'G':
                    char opcion_ingreso_extraccion = ' ';
                    do{
                        opcion_ingreso_extraccion = clsH.recibeChar("Digite una de las siguientes opciones:\n"
                                + "A)Dinero actual en colones\n"
                                + "B)Dinero actual en denominaciones\n"
                                + "C)Extraer dinero\n"
                                + "D)Ingresar dinero\n"
                                + "S)Salir");
                        switch(opcion_ingreso_extraccion){
                        case 'A':
                            clsH.imprimeMensaje("El dinero actual en colones es de "+dineroMaquina+" colones");
                        break;
                        case 'B':
                            clsAdmin.desglosar(dineroMaquina);
                        break;
                        
                        case 'C':
                            permitido = false;

                                dinero_a_extraer = clsH.recibeInt("Digite la cantidad de dinero que desea extraer");
                                if (dinero_a_extraer > dineroMaquina){
                                    clsH.imprimeMensaje("La cantidad marcada supera los fondos disponibles por favor vuelva a ingresar una cantidad");
                                }else if (dinero_a_extraer < 1000){
                                    clsH.imprimeMensaje("La denominacion más baja es de 1000 colones");
                                }else{
                                    permitido  = true;
                                }
                            if (permitido){
                                dineroMaquina -= dinero_a_extraer;
                                transacciones_administradores++;
                                transacciones_generales++;
                                cantidad_extraida_administradores += dinero_a_extraer;
                                clsAdmin.extraccionAdministrador(dinero_a_extraer);
                                clsH.imprimeMensaje("Transaccion realizada con exito");
                            }       
                        break;
                        
                        case 'D':
                            do{
                                dinero_a_introducir = clsH.recibeInt("Digite la cantidad de dinero que desea introducir:");
                            }while(dinero_a_extraer < 1000);
                            dineroMaquina += dinero_a_introducir;
                            transacciones_administradores++;
                            transacciones_generales++;
                            cantidad_ingresada_administradores += dinero_a_introducir;
                            clsH.imprimeMensaje("Transaccion realizada con exito");
                        break;
                        
                        case 'S':
                        break;
                        default:
                            clsH.imprimeMensaje("Opcion invalida");
                        break;
                        }   
                    }while(opcion_ingreso_extraccion != 'S');
                    break;
                    
                case 'H':
                    char opcion_reporte =' ';
                    do{
                        opcion_reporte = clsH.recibeChar("Digite una de las siguientes opciones:\n"
                                + "A)Totalizado por fecha\n"
                                + "B)Detallado por rango de fechas\n"
                                + "S)Salir");
                        switch(opcion_reporte){
                            case 'A':
                                //Imprime reporte totalizado
                                break;
                            case 'B':
                                //Imprime reporte detallado
                                break;
                            case 'S':
                                //Salir
                                break;
                            default:
                                clsH.imprimeMensaje("Opcion invalida");
                                break;
                        }
                        }while (opcion_reporte !='S');
                    break;
                case 'S':
                    break;
                default:
                    clsH.imprimeMensaje("La opcion no es valida");
                    break;
            }
            
        }while(opcion != 'S');
    }
}
