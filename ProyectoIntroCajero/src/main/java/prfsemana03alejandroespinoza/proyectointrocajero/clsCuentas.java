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
public class clsCuentas {
    char TipoCuenta = ' ';//A-Ahorros C-Corriente
    String NumeroCuenta = " ";
    String NumeroTarjeta = " ";
    String CVV = " ";
    String FechaVencimiento = " ";
    float Monto = 0;
    char Moneda = ' '; //C - Colones, D - Dolares
    String Pin = "";
    char Activa = ' '; //A - Acvtiva, I- Inactiva

    public clsCuentas() {
    }
    
    public clsCuentas(char TipoCuenta, String NumeroCuenta, String NumeroTarjeta, String CVV, String FechaVencimiento, float Monto, char Moneda, String Pin, char Activa) {
        this.TipoCuenta = TipoCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.NumeroTarjeta = NumeroTarjeta;
        this.CVV = CVV;
        this.FechaVencimiento = FechaVencimiento;
        this.Monto = Monto;
        this.Moneda = Moneda;
        this.Pin = Pin;
        this.Activa  = Activa;
    }
    public char getTipoCuenta() {
        return TipoCuenta;
    }
    

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public String getCVV() {
        return CVV;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public float getMonto() {
        return Monto;
    }

    public char getMoneda() {
        return Moneda;
    }

    public String getPin() {
        return Pin;
    }

    public char getActiva() {
        return Activa;
    }

    
    public void setTipoCuenta(char TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public void setNumeroTarjeta(String NumeroTarjeta) {
        this.NumeroTarjeta = NumeroTarjeta;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public void setMoneda(char Moneda) {
        this.Moneda = Moneda;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public void setActiva(char Activa) {
        this.Activa = Activa;
    }

    
    @Override
    public String toString() {
        return TipoCuenta + "\t" + NumeroCuenta + "\t" + NumeroTarjeta + "\t" + CVV + "\t" + FechaVencimiento + "\t" + Monto + "\t" + Moneda + "\t" + Pin + "\t" + Activa;
    }
    
    public clsCuentas[] generarlistaCuenta() {
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("Digite la cantidad de cuentas que desea almacenar");
        clsCuentas cuentas[] = new clsCuentas[tamano];
        return cuentas;
    }
    
    public int revisarNumeroCuenta (clsCuentas cuentas[], int posCuenta, String NumeroCuenta, int existe){
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posCuenta; i++) {
            if (NumeroCuenta.equalsIgnoreCase(cuentas[i].getNumeroCuenta())) {
                existe++;
                break;
            }
        } 
        if (existe>0){
            clsH.imprimeMensaje("Este numero de cuenta ya existe");
        }
        return existe;
    }
    
    public int revisarNumeroTarjeta (clsCuentas cuentas[], int posCuenta, String NumeroTarjeta, int existe){
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posCuenta; i++) {
            if (NumeroTarjeta.equalsIgnoreCase(cuentas[i].getNumeroTarjeta())) {
                existe++;
                break;
            }
        } 
        if (existe>0){
            clsH.imprimeMensaje("Este numero de tarjeta ya existe");
        }
        return existe;
    }
    
    
    public int agregarCuenta(clsCuentas cuentas[], int posCuenta) {
        clsHelper clsH = new clsHelper();
        do{
            NumeroCuenta = clsH.recibeString("Digite el numero de cuenta:");
        }while(revisarNumeroCuenta(cuentas, posCuenta, NumeroCuenta, 0) != 0);
        
        do{
            NumeroTarjeta = clsH.recibeString("Digite el numero de la tarjeta:");
        }while(revisarNumeroTarjeta(cuentas, posCuenta, NumeroTarjeta, 0) != 0);
        
        CVV = clsH.recibeString("Digite el CVV de la tarjeta:");
        
        FechaVencimiento = clsH.recibeString("Digite la fecha de vencimiento de la tarjeta:");
        
        Monto = clsH.recibeFloat("Digite el monto:");
        
        do{
            Moneda = clsH.recibeChar("Digite la moneda (C- Colones \n D- Dolares)");
        }while(Moneda != 'C' && Moneda != 'D');
        
        do{
            TipoCuenta = clsH.recibeChar("Digite el tipo de cuenta (C- Corriente \n A- Ahorros)");
        }while(TipoCuenta != 'C' && TipoCuenta != 'A');
        
         do {
            Activa = clsH.recibeChar("Digite si la cuenta está activa (A) o inactiva (I)");
        } while (Activa != 'A' && Activa != 'I');
        
         Pin = clsH.recibeString("Digite el pin de la tarjeta: "); 
        cuentas[posCuenta] = new clsCuentas(TipoCuenta, NumeroCuenta, NumeroTarjeta, CVV, FechaVencimiento, Monto, Moneda, Pin, Activa);
        posCuenta++;
        return posCuenta;
    }
    
    public int obtenerPosCuenta(clsCuentas cuentas[], int posCuenta, String accion) {
        clsHelper clsH = new clsHelper();
        String numeroCuentaBuscar = clsH.recibeString("Digite el numero de la cuenta que desea"+accion+":");
        int posCuentaBuscada = -1;
        for (int i = 0; i < posCuenta; i++) {
            if (numeroCuentaBuscar.equalsIgnoreCase(cuentas[i].getNumeroCuenta())) {
                posCuentaBuscada = i;
                break;
            }
        }
        return posCuentaBuscada;
    }
    
    public clsCuentas[] modificarCuenta(clsCuentas cuentas[], int posCuenta) {
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosCuenta(cuentas, posCuenta, "modificar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron clientes con el numero de cuenta indicado, intente nuevamente");
        } else {
            char opcion = ' ';
            do {
                opcion = clsH.recibeChar("Seleccione el tipo de dato que desea modificar: "
                        + "\n A. NumeroCuenta"
                        + "\n B. Fecha Vencimiento"
                        + "\n C. NumeroTarjeta"
                        + "\n D. Moneda"
                        + "\n E. CVV"
                        + "\n F. Tipo Cuenta"
                        + "\n G. Activa/Inactiva"
                        + "\n H. Pin"
                        + "\n S. Salir");
                switch (opcion) {
                    case 'A':
                        cuentas[pos].setNumeroCuenta(clsH.recibeString("Digite el nuevo número de cuenta:"));
                        break;
                        
                    case 'B':
                        cuentas[pos].setFechaVencimiento(clsH.recibeString("Digite la nueva fecha de vencimiento:"));
                        break;
                        
                    case 'C':
                        cuentas[pos].setNumeroTarjeta(clsH.recibeString("Digite el nuevo número de tarjeta"));
                        break;
                        
                    case 'D':
                        do{
                            cuentas[pos].setMoneda(clsH.recibeChar("Digite el nuevo tipo de moneda de la cuenta: C-Colones D-Dolares: "));
                        }while(cuentas[pos].getMoneda() != 'C' && cuentas[pos].getMoneda() != 'D');
                        break;
                        
                    case 'E':
                        cuentas[pos].setCVV(clsH.recibeString("Digite el nuevo CVV: "));
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
    
    public int eliminarCuenta(clsCuentas cuentas[],int posCuenta){
        clsHelper clsH = new clsHelper();
        
        int pos = this.obtenerPosCuenta(cuentas, posCuenta, "eliminar");
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron cuentas con el numero indicado, intente nuevamente");
        } else {
            for (int i = pos; i < posCuenta-1; i++){
                cuentas[i] = cuentas[i+1];
            }
            posCuenta--;
            cuentas[posCuenta] = null;
            clsH.imprimeMensaje("La cuenta ha sido eliminada de forma correcta");
        }            
        return posCuenta;
    }
    
    public void listarCuentas(clsCuentas cuentas[], int posCuenta) {
        String impresion = "TipoCuenta \t NumeroCuenta \t NumeroTarjeta \t CVV \t FechaVencimiento \t Monto \t Moneda \t Pin \t Activa \n";
        clsHelper clsH = new clsHelper();
        for (int i = 0; i < posCuenta; i++) {
            impresion += "\n" + cuentas[i].toString() + "\n";
        }
        clsH.imprimeMensaje(new TextArea(impresion));
    }
    
    public void buscarCuenta(clsCuentas cuentas[], int posCuenta){
        String impresion = "TipoCuenta\tNumeroCuenta\tNumeroTarjeta\tCVV\tFechaVencimiento\tMonto\tMoneda\tPin\tActiva\n";
        clsHelper clsH = new clsHelper();
        int pos = this.obtenerPosCuenta(cuentas, posCuenta, "buscar");
        impresion += cuentas[pos].toString();
        clsH.imprimeMensaje(new TextArea(impresion));
    }
    
    public int buscarExistenciaCuenta(clsCliente clientes[], int posCliente, String numTarjeta, String pin){
        int posTarjetaBuscada = -1;
        for (int i = 0; i < posCliente; i++){
            for (int j = 0; j < clientes[i].getCantidadCuentas(); j++){
                if (numTarjeta.equalsIgnoreCase(clientes[i].getListaCuentas()[j].getNumeroTarjeta()) && pin.equalsIgnoreCase(clientes[i].getListaCuentas()[j].getPin())){
               posTarjetaBuscada = i;
           } 
        }
      }
     return posTarjetaBuscada;
    }
    
    public int buscarPosCuenta(clsCliente clientes[], int posCliente, String numTarjeta){
        int posTarjetaBuscada = -1;
        for (int i = 0; i < posCliente; i++){
            for (int j = 0; j < clientes[i].getCantidadCuentas(); j++){
                if (numTarjeta.equalsIgnoreCase(clientes[i].getListaCuentas()[j].getNumeroTarjeta())){
               posTarjetaBuscada = i;
           } 
        }
      }
     return posTarjetaBuscada;
    }
    
    
    public void voucher(String accion, int monto){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje("Se realizo un/una "+accion+"por el monto de:"+monto+" colones");
    }
    
    public int Tranferencia(clsCliente cliente, clsCliente clientes[], int posClienteAtransferir, int cantidadtransferir, int dineroMaquina){
        clsHelper clsH = new clsHelper();
        String cuentaOrigen = clsH.recibeString("Digite el numero de cuenta de la que desea depositar dinero");
        int posTransfiere = -1;
        for (int i = 0; i < cliente.getListaCuentas().length; i++) {
            if (cliente.getListaCuentas()[i] != null) {
                if (cliente.getListaCuentas()[i].NumeroCuenta.equalsIgnoreCase(cuentaOrigen)) {
                    posTransfiere = i;
                }
            }
            
        }if (posTransfiere == -1) {
            clsH.imprimeMensaje("No se encontraron cuentas coincidentes");
        } else if (cliente.getListaCuentas()[posTransfiere].getActiva() == 'I') {
            clsH.imprimeMensaje("Su cuenta se encuentra inactiva y no se puede transferir");
        } else {
            
            String cuentaDestino = clsH.recibeString("Digite el numero de cuenta a la que desea depositar dinero");
            int posATransferir = -1;
            for (int i = 0; i < clientes[posClienteAtransferir].getListaCuentas().length; i++) {
                if (cliente.getListaCuentas()[i] != null) {
                    if (cliente.getListaCuentas()[i].NumeroCuenta.equalsIgnoreCase(cuentaDestino)) {
                        posATransferir = i;
                    }
                }
            }if (posATransferir == -1) {
                clsH.imprimeMensaje("No se encontraron cuentas coincidentes");
                
            } else if (clientes[posClienteAtransferir].getListaCuentas()[posATransferir].getActiva() == 'I') {
                clsH.imprimeMensaje("La cuenta se encuentra inactiva y no se puede transferir");
            } else if (clientes[posClienteAtransferir].getListaCuentas()[posATransferir].getMoneda() != cliente.getListaCuentas()[posTransfiere].getMoneda()) {
                    clsH.imprimeMensaje("Las cuentas tienen monedas diferentes, no puede tranferir");
            }else{
                
                cliente.getListaCuentas()[posTransfiere].setMonto(cliente.getListaCuentas()[posTransfiere].getMonto()- cantidadtransferir);    
                clientes[posClienteAtransferir].getListaCuentas()[posATransferir].setMonto(clientes[posClienteAtransferir].getListaCuentas()[posATransferir].getMonto()+cantidadtransferir);
                    clsH.imprimeMensaje("Transferencia realizada con éxito.\n");         
                        }
            }
            voucher("Transferencia ", cantidadtransferir);
            return dineroMaquina;
        }  
    
    public int Deposito(int dineroMaquina, clsCliente cliente, int cantidad_ingresar) {
        clsHelper clsH = new clsHelper();
        String numCuenta = clsH.recibeString("Digite el numero de cuenta de la que desea depositar dinero");
        int pos = -1;
        for (int i = 0; i < cliente.getListaCuentas().length; i++) {
            if (cliente.getListaCuentas()[i] != null) {
                if (cliente.getListaCuentas()[i].NumeroCuenta.equalsIgnoreCase(numCuenta)) {
                    pos = i;
                }
            }
        }
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron cuentas coincidentes");
        } else {
            
            int monto = cantidad_ingresar;
            cliente.getListaCuentas()[pos].Monto += monto;
            dineroMaquina -= monto;
            clsH.imprimeMensaje("Deposito realizado correctamente");
            voucher("Extraccion clsH.imprimeMensaje(new TextArea(impresion));", monto);
        }
        return dineroMaquina;
    }
    
    public int extraccion(int dineroMaquina, clsCliente cliente, int cantidad_extraer) {
        clsHelper clsH = new clsHelper();
        String numCuenta = clsH.recibeString("Digite el numero de cuenta de la que desea extraer dinero");
        int pos = -1;
        for (int i = 0; i < cliente.getListaCuentas().length; i++) {
            if (cliente.getListaCuentas()[i] != null) {
                if (cliente.getListaCuentas()[i].NumeroCuenta.equalsIgnoreCase(numCuenta)) {
                    pos = i;
                }
            }
        }
        if (pos == -1) {
            clsH.imprimeMensaje("No se encontraron cuentas coincidentes");
        } else {
            int monto = cantidad_extraer;
            cliente.getListaCuentas()[pos].Monto -= monto;
            dineroMaquina += monto;
            clsH.imprimeMensaje("Extraccion realizada correctamente");
            voucher("Deposito ", monto);
        }
        return dineroMaquina;
    }
    
    
   
}
