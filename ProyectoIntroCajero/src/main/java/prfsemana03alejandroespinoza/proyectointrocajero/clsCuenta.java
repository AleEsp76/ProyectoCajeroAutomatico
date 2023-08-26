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
public class clsCuenta {
    private char TipoCuenta; //A-Ahorro, C-Corriente
    private String NumeroCuenta;
    private String NuneroTarjeta;
    private String CVV;
    private String FechaNacimiento;
    float Monto;
    char Moneda;//C-Colones, D-Dolares

    public clsCuenta() {
    }

    public clsCuenta(char TipoCuenta, String NumeroCuenta, String NuneroTarjeta, String CVV, String FechaNacimiento, float Monto, char Moneda) {
        this.TipoCuenta = TipoCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.NuneroTarjeta = NuneroTarjeta;
        this.CVV = CVV;
        this.FechaNacimiento = FechaNacimiento;
        this.Monto = Monto;
        this.Moneda = Moneda;
    }

    public char getTipoCuenta() {
        return TipoCuenta;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public String getNuneroTarjeta() {
        return NuneroTarjeta;
    }

    public String getCVV() {
        return CVV;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public float getMonto() {
        return Monto;
    }

    public char getMoneda() {
        return Moneda;
    }

    public void setTipoCuenta(char TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public void setNuneroTarjeta(String NuneroTarjeta) {
        this.NuneroTarjeta = NuneroTarjeta;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public void setMoneda(char Moneda) {
        this.Moneda = Moneda;
    }

    @Override
    public String toString() {
        return  TipoCuenta + "\t" + NumeroCuenta + "\t" + NuneroTarjeta + "\t" + CVV + "\t" + FechaNacimiento + "\t" + Monto + "\t" + Moneda;
    }
    
    public clsCuenta[] generarlistaCuenta() {
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("Digite la cantidad de administradores que desea almacenar");
        clsCuenta cuentas[] = new clsCuenta[tamano];
        return cuentas;
    }

    public int agregarCuenta(clsCuenta cuentas[], int posCuenta) {
        clsHelper clsH = new clsHelper();
        String NumeroCuenta = clsH.recibeString("Digite la identifacion:");
        String NumeroTarjeta = clsH.recibeString("Digite el nombre completo:");
        String CVV = clsH.recibeString("Digite el puesto:");
        String FechaNacimiento = clsH.recibeString("Digite la contraseña:");
        float Monto = clsH.recibeFloat("Digite el año de ingreso:");
        char Moneda = ' ';
        do{
            Moneda = clsH.recibeChar("Digite si el administrador esta S - habilitado o N - desabilitado");
        }while(Moneda != 'S' && Moneda != 'N');
        char TipoCuenta = ' ';
        do{
            TipoCuenta = clsH.recibeChar("Digite si el administrador esta S - habilitado o N - desabilitado");
        }while(TipoCuenta != 'S' && TipoCuenta != 'N');
        cuentas[posCuenta] = new clsCuenta(TipoCuenta, NumeroCuenta, NumeroTarjeta, CVV, FechaNacimiento, Monto,Moneda);
        posCuenta++;
        return posCuenta;
    }

    public int obtenerPosAdministrador(clsAdministrador administradores[], int posAdministrador, String accion) {
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibeString("Digite el nombre del administrador que desea"+accion+":");
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

    public int eliminarAdministrador(clsAdministrador administradores[],int posAdministrador){
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosAdministrador(administradores, posAdministrador, "eliminar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron vehiculos con la placa indicada, intente nuevamente");
        } else {
            for (int i = pos; i < posAdministrador-1; i++){
                administradores[i] = administradores[i+1];
            }
            posAdministrador--;
            administradores[posAdministrador] = null;
            clsH.imprimeMensaje("El vehiculo ha sido eliminado de forma correcta");
        }            
        return posAdministrador;
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
