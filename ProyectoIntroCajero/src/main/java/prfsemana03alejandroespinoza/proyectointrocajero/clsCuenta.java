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
    private char activa; //A-activa , I -Inaticva
    private char TipoCuenta; //A-Ahorro, C-Corriente
    private String NumeroCuenta;
    private String NuneroTarjeta;
    private String CVV;
    private String FechaNacimiento;
    float Monto;
    char Moneda;//C-Colones, D-Dolares

    public clsCuenta() {
    }

    public clsCuenta(char TipoCuenta, String NumeroCuenta, String NuneroTarjeta, String CVV, String FechaNacimiento, float Monto, char Moneda, char activa) {
        this.TipoCuenta = TipoCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.NuneroTarjeta = NuneroTarjeta;
        this.CVV = CVV;
        this.FechaNacimiento = FechaNacimiento;
        this.Monto = Monto;
        this.Moneda = Moneda;
        this.activa = activa;
    }

    public char getTipoCuenta() {
        return TipoCuenta;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public char getActiva() {
        return activa;
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

    public void setActiva(char activa) {
        this.activa = activa;
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
        
         do{
            activa = clsH.recibeChar("Digite si la cuenta esta A - Activa o I - Inativa");
        }while(Moneda != 'S' && Moneda != 'N');
        
        cuentas[posCuenta] = new clsCuenta(TipoCuenta, NumeroCuenta, NumeroTarjeta, CVV, FechaNacimiento, Monto,Moneda,activa);
        posCuenta++;
        return posCuenta;
    }

    public int obtenerPosCuenta(clsCuenta cuentas[], int posCuenta, String accion) {
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibeString("Digite el numero de la  cuenta que desea"+accion+":");
        int posAdministradorBuscado = -1;
        for (int i = 0; i < posCuenta; i++) {
            if (nombreBuscar.equalsIgnoreCase(cuentas[i].getNumeroCuenta())) {
                posAdministradorBuscado = i;
                break;
            }
        }
        return posAdministradorBuscado;
    }

    public clsCuenta[] modificarCuenta(clsCuenta cuentas[], int posCuenta) {
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosCuenta(cuentas, posCuenta, "modificar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron administradores con el numero de cuenta indicado, intente nuevamente");
        } else {
            char opcion = ' ';
            do {
                opcion = clsH.recibeChar("Seleccione el tipo de dato que desea modificar: "
                        + "\n A. NumeroCuenta"
                        + "\n B. FechaNacimiento"
                        + "\n C. NumeroTarjeta"
                        + "\n D. Moneda"
                        + "\n E. CVV"
                        + "\n F. Tipo Cuenta"
                        + "\n G. Activa,Inativa"
                        + "\n S. Salir");
                switch (opcion) {
                    case 'A':
                        cuentas[pos].setNumeroCuenta(clsH.recibeString("Digite el nuevo numero de cuenta:"));
                        break;
                    case 'B':
                        cuentas[pos].setFechaNacimiento(clsH.recibeString("Digite la nueva fecha de nacimeinto:"));
                        break;
                    case 'C':
                        cuentas[pos].setNuneroTarjeta(clsH.recibeString("Digite el nuevo numero de tarjeta"));
                        break;
                    case 'D':
                        do{
                            cuentas[pos].setMoneda(clsH.recibeChar("Digite el tipo de moneda de la cuenta: C-Colones D-Dolares"));
                        }while(cuentas[pos].getMoneda() != 'C' && cuentas[pos].getMoneda() != 'D');
                        break;
                    case 'E':
                        cuentas[pos].setCVV(clsH.recibeString("Digite el nuevo CVV"));
                        break;
                    case 'F':
                        do{
                            cuentas[pos].setTipoCuenta(clsH.recibeChar("Digite el tipo de cuenta nuevo: A-Ahorro C-Corriente"));
                        }while(cuentas[pos].getTipoCuenta() != 'A' && cuentas[pos].getTipoCuenta() != 'C');
                        
                    case 'G':
                        do{
                            cuentas[pos].setActiva(clsH.recibeChar("Digite si la cuenta esta activa o inactiva"));
                        }while(cuentas[pos].getActiva()!= 'A' && cuentas[pos].getActiva()!= 'I');
                        break;
                    case 'S':
                        clsH.imprimeMensaje("Los datos se han modificado exitosamente");
                        break;
                    default:
                        clsH.imprimeMensaje("La opcion no es valida");
                }

            } while (opcion != 'S');
        }
        return cuentas;
    }

    public int eliminarCuenta(clsCuenta cuentas[],int posCuenta){
        clsHelper clsH = new clsHelper();
        //Hola que tal 
        int pos = this.obtenerPosCuenta(cuentas, posCuenta, "eliminar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron vehiculos con la placa indicada, intente nuevamente");
        } else {
            for (int i = pos; i < posCuenta-1; i++){
                cuentas[i] = cuentas[i+1];
            }
            posCuenta--;
            cuentas[posCuenta] = null;
            clsH.imprimeMensaje("El vehiculo ha sido eliminado de forma correcta");
        }            
        return posCuenta;
    }
        
    public void listarCuentas(clsCuenta cuentas[], int posCuenta) {
        String impresion = "TipoCuenta\tNumeroCuenta\tNumeroTarjeta\tCVV\tFechaNacimiento\tMonto\tMoneda\n";
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posCuenta; i++) {
            impresion += "\n" + cuentas[i].toString() + "\n";
        }
        clsH.imprimeMensaje(new TextArea(impresion));
    }
    
    public void Tranferecnia(clsCuenta cuentas[], int posCuenta){
    
        
    
    
    
    }
    
    
    
}
