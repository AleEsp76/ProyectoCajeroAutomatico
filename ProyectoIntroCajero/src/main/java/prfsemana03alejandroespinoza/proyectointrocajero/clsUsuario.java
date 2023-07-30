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
    
    
    
}
