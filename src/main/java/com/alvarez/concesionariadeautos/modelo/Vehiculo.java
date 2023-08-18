/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private int anioFabricacion;
    private TipoMotor tipoMotor;
    private int numLlantas;
    private double precio;
    private EstadoVehiculo estado;
    private EstadoMantenimiento estadoMantenimiento;
    private double kilometraje;
    private String concesionaria;
    private Cliente propietario;

    public Vehiculo(String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.tipoMotor = tipoMotor;
        this.numLlantas = numLlantas;
        this.precio = precio;
        this.estado = estado;
        this.estadoMantenimiento = null;
        this.kilometraje = kilometraje;
        this.concesionaria = concesionaria;
        this.propietario = null;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        if (kilometraje >= 0) {
            this.kilometraje = kilometraje;
        } else {
            throw new IllegalArgumentException("El kilometraje no puede ser negativo");
        }
    }

    public EstadoMantenimiento getEstadoMantenimiento() {
        return estadoMantenimiento;
    }

    public void setEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento) {
        this.estadoMantenimiento = estadoMantenimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion >= 1900) {
            this.anioFabricacion = anioFabricacion;
        } else {
            throw new IllegalArgumentException("Año de fabricación inválido");
        }
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public String getConcesionaria() {
        return concesionaria;
    }

    public void setConcesionaria(String concesionaria) {
        this.concesionaria = concesionaria;
    }

    public int getNumLlantas() {
        return numLlantas;
    }

    public void setNumLlantas(int numLlantas) {
        if (numLlantas >= 0) {
            this.numLlantas = numLlantas;
        } else {
            throw new IllegalArgumentException("Número de llantas inválido");
        }
    }

    public String getInformacionParaCliente() {
        return this.marca + " " + this.modelo;
    }

    public String mostrarInformacion() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + ", tipoMotor=" + tipoMotor + ", numLlantas=" + numLlantas + ", precio=" + precio + ", estado=" + estado + ", kilometraje=" + kilometraje + ", concesionaria=" + concesionaria;
    }

    public String mostrarInformacionCliente() {
        return "Vehiculo{ " + "marca=" + marca + ", modelo=" + modelo;
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año de fabricacion: " + anioFabricacion);
        System.out.println("Tipo de motor: " + tipoMotor);
        System.out.println("Numero de llantas: " + numLlantas);
        System.out.println("Precio: " + precio + "$");
        System.out.println("Kilometraje: " + kilometraje + "km");
    }
}