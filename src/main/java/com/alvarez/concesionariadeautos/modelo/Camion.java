/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public class Camion extends Vehiculo{
    private double capacidadCarga;
    private int numEjes;

    public Camion(double capacidadCarga,String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria) {
        super(marca, modelo, anioFabricacion, tipoMotor, numLlantas, precio, estado, kilometraje, concesionaria);
        this.capacidadCarga = capacidadCarga;
        this.numEjes = numLlantas/2;
    }



    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", capacidadCarga=" + capacidadCarga + ", numEjes=" + numEjes + '}'; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Capacidad carga: "+capacidadCarga);
        System.out.println("Numero de Ejes: "+numEjes);
    }




    
}
