/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public class Camion extends Vehiculo{
    private double capacidadCarga;
    private int numEjes;




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

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }
    
    
    

    
}
