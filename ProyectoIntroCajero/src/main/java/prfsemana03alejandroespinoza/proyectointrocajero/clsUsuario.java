/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;

/**
 *
 * @author aleja
 */
public class clsUsuario {
    private String Identificacion;
    private String Nombre;
    private char Sexo; //M-Masculino, F-Femenino, N-No Binario
    private String FechaNacimiento;
    private String Residencia;
    private String Correo;
    private String NumeroTelefono;
    
    clsCuenta listaCuentas[];
    int NumeroCuentas;

    public clsUsuario(String Identificacion, String Nombre, char Sexo, String FechaNacimiento, String Residencia, String Correo, String NumeroTelefono) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.Residencia = Residencia;
        this.Correo = Correo;
        this.NumeroTelefono = NumeroTelefono;
        listaCuentas = new clsCuenta[5]; 
         NumeroCuentas = 0;
    }

    public clsUsuario() {
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getSexo() {
        return Sexo;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getResidencia() {
        return Residencia;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public clsCuenta[] getListaCuentas() {
        return listaCuentas;
    }

    public int getNumeroCuentas() {
        return NumeroCuentas;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public void setResidencia(String Residencia) {
        this.Residencia = Residencia;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setNumeroTelefono(String NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public void setListaCuentas(clsCuenta[] listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void setNumeroCuentas(int NumeroCuentas) {
        this.NumeroCuentas = NumeroCuentas;
    }

    @Override
    public String toString() {
        return Identificacion + "\t" + Nombre + "\t" + Sexo + "\t" + FechaNacimiento + "\t" + Residencia + "\t" + Correo + "\t" + NumeroTelefono;
    }
    
    public clsUsuario[] generarListaClientes(){
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("¿Cuantos clientes usaran su banco?");
        clsUsuario clientes[]= new clsUsuario [tamano];
        return clientes;
        
    }
    
    public int agregarcliente(clsUsuario clientes[], int poscCliente){
         clsHelper clsH = new clsHelper();       
         String Identificacion = clsH.recibeString("Digite la cédula del cliente: ");
         String Nombre = clsH.recibeString("Digite el nombre del cliente: ");
         char Sexo =clsH.recibeChar("Ingrese el sexo del cliente segun la leyenda mostrada"
                 + "\n M. Masculino"
                 + "\n F. Femenino"
                 + "\n N. No binario \n"); 
         String FechaNacimiento = clsH.recibeString("Digite la fecha de nacimiento del cliente: \n Formato DD-MM-AA ");
         String Residencia= clsH.recibeString("Digite la direccion del cliente: ");
         String Correo= clsH.recibeString("Digite el correo electronico del cliente: ");
         String NumeroTelefono= clsH.recibeString("Digite el número de teléfono del cliente: ");
         clientes[poscCliente] = new clsUsuario(Identificacion,Nombre,Sexo,FechaNacimiento,Residencia, Correo,NumeroTelefono);
         poscCliente++;
         return poscCliente;
         }
    
    public void listarclientes(clsUsuario clientes[], int poscCliente){
        clsHelper clsH = new clsHelper();
        String impresion = "Identificacion   \tNombre   \tSexo   \tFechaNacimiento   \tResidencia   \tCorreo\tNumeroTelefono\n";
        for(int i= 0;  i < poscCliente; i++){
            impresion += clientes[i].toString()+ "\n";        
            }
        clsH.imprimeMensaje(impresion);
    }
    
    public int buscarposccliente(clsUsuario clientes[], int poscCliente){
        clsHelper clsH = new clsHelper();
        int poscusuario = -1;
        String buscarnombre = clsH.recibeString("Ingrese el nombre del cliente");
        for(int i=0; i< poscCliente; i++){
            if(buscarnombre.equalsIgnoreCase(clientes[i].getNombre())){
               poscusuario = i;
               break;
            }
        }
        return poscusuario;
    }
    
    public void modificarCliente(clsUsuario clientes[], int poscClientes){
        clsHelper clsH = new clsHelper();
         int poscusuario = this.buscarposccliente(clientes, poscClientes);
         if (poscusuario ==-1){
             clsH.imprimeMensaje("No hay clientes registrados con los terminos utilizados");
         }else{
            char mod = 'S';
            do{
                mod= clsH.recibeChar("Elija el valor a modificar"
                        + "\n A.Identificacion\n"
                        + "B. Nombre\n"
                        + "C. Sexo\n"
                        + "D. Fecha de Nacimiento\n"
                        + "E. Residencia\n"
                        + "F. Correo\n"
                        + "G. Numero de Telefono\n"
                        + "R. Regresar");
                        switch (mod){
                            case 'A':
                                clientes[poscusuario].setIdentificacion(clsH.recibeString("Ingrese el número de cédula del cliente"));
                                break;
                            case 'B':
                                clientes[poscusuario].setNombre(clsH.recibeString("Ingrese el número de cédula del cliente"));
                                break;
                            case 'C':
                                clientes[poscusuario].setSexo(clsH.recibeChar("Ingrese el sexo del cliente segun la leyenda mostrada"
                                                                                + "\n M. Masculino"
                                                                                + "\n F.Femenino"
                                                                                + "\n N. No binario \n"));
                                break;
                            case 'D':
                                clientes[poscusuario].setFechaNacimiento(clsH.recibeString("Digite la fecha de nacimiento del cliente: \n Formato DD-MM-AA "));
                                break;
                            case 'E':
                                clientes[poscusuario].setResidencia(clsH.recibeString("Ingrese la drección del cliente"));
                                break;
                            case 'F':
                                clientes[poscusuario].setCorreo(clsH.recibeString("Ingrese el correo electronico del cliente"));
                                break;
                            case 'G':
                                clientes[poscusuario].setNumeroTelefono("Ingrese el numero número de telefono del cliente");
                                break;
                            case 'R': 
                                mod = 'R';
                                break;   
                            default:
                                clsH.imprimeMensaje("Opción invalida");                                
                        }
            }while(mod != 'R');
            clsH.imprimeMensaje("Información modificada de manera exitosa");
         }
        
    }
    
    public int eliminarCliente(clsUsuario clientes[], int poscCliente){
        clsHelper clsH =new clsHelper();
        int poscusuario = this.buscarposccliente(clientes, poscCliente);
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
    
    public void buscarcliente(clsUsuario clientes[], int posCliente){
        clsHelper clsH = new clsHelper();
        int poscusuario = this.buscarposccliente(clientes, posCliente);
        if(poscusuario == -1){
        clsH.imprimeMensaje("No se encontraron coincidencias");
        }else{
            clsH.imprimeMensaje("Los datos del cliente son: \n"
            +"Identificación: "+clientes[poscusuario].getIdentificacion()+"\n"
            +"Nombre: "+ clientes[poscusuario].getNombre()
            +"Sexo: "+clientes[poscusuario].getSexo()+"\n"
            +"Fecha de nacimiento: "+clientes[poscusuario].getFechaNacimiento()+"\n"
            +"Residencia: "+clientes[poscusuario].getResidencia()+"\n"
            +"Correo: "+clientes[poscusuario].getCorreo()+"\n"
            +"Teléfono: "+clientes[poscusuario].getNumeroTelefono()+"\n");           
            }
        }    
}
