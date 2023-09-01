/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prfsemana03alejandroespinoza.proyectointrocajero;

/**
 *
 * @author aleja
 */
public class Main {

    public static clsCuentas[] cuentas;
    public static void main(String[] args) {
        System.out.println("Bienvenido!.");
        cuentas=new clsCuentas[2];
        cuentas[0]=new clsCuentas('A', "123456789", "987654321", "1234", "28/08/2023",0, 'C', 'A');
        clsVerificacion verificacion = new clsVerificacion();
        verificacion.ingresarDatos();
    }
}
