/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;

/**
 *
 * @author aleja
 */
public class clsMenu {

    public void MenuAdministrador() {
        clsHelper clsH = new clsHelper();
        clsAdministrador clsAdmin = new clsAdministrador();
        clsAdministrador administradores[] = new clsAdministrador[0];
        int posAdministrador = 0;
        boolean listaAdministradores = false;
        char opcion = 'S';

        do {
            opcion = clsH.recibeChar("Seleccione una de las siguientes opciones:\n"
                    + "A. Generar lista administradores\n"
                    + "B. Agregar Administrador\n"
                    + "C. Modificar Administrador\n"
                    + "D. Eliminar Administrador\n"
                    + "E. Listar Administradores\n"
                    + "F  Administrar Clientes\n"
                    + "S. Sair");
            switch (opcion) {
                case 'A':
                    if (listaAdministradores) {
                        char nuevaLista = 'N';
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
                    posAdministrador = clsAdmin.eliminarAdministrador(administradores, posAdministrador);
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
                case 'S':
                    break;
                default:
                    clsH.imprimeMensaje("La opcion no es valida");
                    break;
            }
        } while (opcion != 'S');

    }

    public void MenuAdministrarClientes() {
        clsHelper clsH = new clsHelper();
        clsUsuario clsCl = new clsUsuario();
        clsUsuario clientes[] = new clsUsuario[0];
        int poscCliente = 0;
        boolean listacliente = false;
        char opcion = 'R';
        do {
            opcion = clsH.recibeChar("Seleccione una de las siguientes opciones:\n"
                    + "A. Generar lista clientes\n"
                    + "B. Agregar Clientes\n"
                    + "C. Modificar Cliente\n"
                    + "D. Elimintar Cliente\n"
                    + "E. Listar Clientes\n"
                    + "F  Administrar Cuentas\n"
                    + "R. Regresar a Administrador");
            switch (opcion) {
                case 'A':
                    clsH.imprimeMensaje("Se genera una lista de clientes nueva");
                    clientes = clsCl.generarListaClientes();
                    listacliente = true;
                    break;
                case 'B':
                    if (listacliente){
                        poscCliente = clsCl.agregarcliente(clientes, poscCliente);
                    }
                    break;
                case 'C':                   
                    clsH.imprimeMensaje("Se modifica un cliente");
                    if (poscCliente == 0) {
                    clsH.imprimeMensaje("No hay clientes añadidos, por favor agregue uno primero");
                    } else {
                        clsCl.modificarCliente(clientes, poscCliente);
                    }
                    break;
                case 'D':
                    clsH.imprimeMensaje("Se eliminara un cliente");
                    clsCl.eliminarCliente(clientes, poscCliente);
                    break;
                case 'E':
                    clsH.imprimeMensaje("Se listan los clientes en la base de datos");
                    clsCl.listarclientes(clientes, poscCliente);
                    break;
                case 'F':
                    int poscusuario = clsCl.buscarposccliente(clientes, poscCliente);
                    if (poscusuario == -1){
                        clsH.imprimeMensaje("No se encontraron coincidencias");
                    }else{
                        //clientes[poscusuario]= this.MenuAdministrarCuentas(infoCuentas[]);
                        }
                    //this.MenuAdministrarCuentas();
                    break;
                case 'R':
                    break;
                default:
                    clsH.imprimeMensaje("La opcion no es valida");
                    break;
            }
        } while (opcion != 'R');
    }

    public void MenuAdministrarCuentas() {
        clsHelper clsH = new clsHelper();
        char opcion = 'R';
        clsCuenta clsC = new clsCuenta();
        clsCuenta cuentas[] = new clsCuenta[0];
        int posCuenta = 0;
        boolean listaCuenta = false;
        do {
            opcion = clsH.recibeChar("Seleccione una de las siguientes opciones:\n"
                    + "A. Generar lista cuentas\n"
                    + "B. Agregar Cuenta\n"
                    + "C. Modificar Cuenta\n"
                    + "D. Elimintar Cuenta\n"
                    + "E. Listar Cuentas\n"
                    + "R. Regresar a Clientes");
            switch (opcion) {
                case 'A':
                    if (listaCuenta) {
                        char nuevaLista = 'N';
                        do {
                            nuevaLista = clsH.recibeChar("¿Desea generar una nueva lista? \n S - Si \n N - No");
                        } while (nuevaLista != 'S' && nuevaLista != 'N');
                        if (nuevaLista == 'S') {
                            cuentas = clsC.generarlistaCuenta();
                            posCuenta = 0;
                            listaCuenta = true;
                        }
                    } else {
                        clsH.imprimeMensaje("Se genera una lista de administradores nueva");
                        cuentas = clsC.generarlistaCuenta();
                        clsH.imprimeMensaje("Lista de administradores generada");
                        listaCuenta = true;
                    }
                    break;
                case 'B':
                    if (listaCuenta) {
                        if (posCuenta < cuentas.length) {
                            posCuenta = clsC.agregarCuenta(cuentas, posCuenta);
                            clsH.imprimeMensaje("El administrador ha sido agregado exitosamente");
                        } else {
                            clsH.imprimeMensaje("La lista de administradores se ha llenado");
                        }
                    } else {
                        clsH.imprimeMensaje("Lista de administradores aun no ha sido generada generada");
                    }
                    break;
                case 'C':
                    if (posCuenta == 0) {
                    clsH.imprimeMensaje("No existen administradores, agregue uno primero");
                    } else {
                    clsH.imprimeMensaje("Se modifica un administrador");
                    cuentas = clsC.modificarCuenta(cuentas, posCuenta);
                    }
                    break;
                case 'D':
                    if (posCuenta == 0) {
                    clsH.imprimeMensaje("No existen administradores, agregue uno primero");
                    } else {
                    posCuenta = clsC.eliminarCuenta(cuentas, posCuenta);
                    //administradores = clsAdmin.cambiarEstadoHabilitadoDeshabilitado(administradores, posAdministrador);
                    }
                    break;
                case 'E':
                    if (listaCuenta) {
                        if (posCuenta == 0) {
                            clsH.imprimeMensaje("No hay clientes para mostrar en la lista");
                        } else {
                            clsC.listarCuentas(cuentas, posCuenta);
                        }
                    } else {
                        clsH.imprimeMensaje("Aun no se ha generado una lista");
                    }
                    break;
                case 'R':
                    break;
                default:
                    clsH.imprimeMensaje("La opcion no es valida");
                    break;
            }
        } while (opcion != 'R');

    }

    public void MenuCliente() {
        clsHelper clsH = new clsHelper();
        char opcion = 'S';
        do {
             opcion = clsH.recibeChar("Seleccione una de las siguientes opciones:\n"
                    + "A. Revisar Estado de Cuentas\n"
                    + "B. Hacer retiro de dinero\n"
                    + "C. Hacer deposito de dinero\n"
                    + "S. Sair");
            switch (opcion) {
                case 'A':
                    clsH.imprimeMensaje("Se le daran los resultados de la cuenta");
                    break;
                case 'B':
                    clsH.imprimeMensaje("Se procedera a hacer el retiro");
                    break;
                case 'C':
                    clsCuenta cuenta=new clsCuenta();
                    cuenta.Deposito(Main.cuentas);
                    break;
                case 'S':
                    clsH.imprimeMensaje("Gracias por visitar el cajero");
                default:
                    clsH.imprimeMensaje("La opcion no es valida");
                    break;
            }
        } while (opcion != 'S');

    }
}
