/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;
/**
 *
 * @author aleja
 */
public class clsVerificacion {
    //Variables Dummy para Testeo
    String nombreAdminitradorD = "Ale";
    String contraseñaAdministradorD = "123";
    String nombreClienteD = "Jenny";
    String contraseñaClienteD = "456";
    int intentos = 3;
    boolean permitir = false;
    
    public void ingresarDatos(){
        //Variables
        clsMenu redireccionMenu = new clsMenu();
        clsHelper clsH = new clsHelper();
        String usuario;
        String contrasenna;
        //Verificacion
        while (permitir == false && intentos !=0) {
            usuario = clsH.recibeString("Digite su usuario");
            contrasenna = clsH.recibeString("Digite su contraseña");
            //JOptionPane.showMessageDialog(null, "Usuario "+user+" Contrasenna: "+pass);
            if (usuario.equals(nombreAdminitradorD) && contrasenna.equals(contraseñaAdministradorD)){
                permitir = true;
                clsH.imprimeMensaje("Eres administrador");
                redireccionMenu.MenuAdministrador();
            } else if (contrasenna.equals(contraseñaClienteD) && usuario.equals(nombreClienteD)){
                permitir = true;
                clsH.imprimeMensaje("Eres cliente");
                redireccionMenu.MenuCliente();
            } else {
                intentos--;
                clsH.imprimeMensaje("Contraseña o usuario incorrecto, "
                        + "por favor vuelva a intentear, le quedan "+intentos+" intentos");
            }
        }
        if(permitir == false){
            clsH.imprimeMensaje("Debido al numero de intentos su cuenta ha sido bloqueada, "
                    + "por favor contacte a un administrador para que esta sea desbloqueada nuevamente");
        }
    }     
}
