/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prfsemana03alejandroespinoza.proyectointrocajero;

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
    
    
}
