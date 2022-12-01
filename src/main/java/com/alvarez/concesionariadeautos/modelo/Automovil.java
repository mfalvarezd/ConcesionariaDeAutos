/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


//automovil
public class Automovil extends Vehiculo{
    private int numAsientos;
    private boolean esConvertible;
    private boolean camaraRetro;

    /**
     *
     * @param numAsientos
     * @param esConvertible
     * @param camaraRetro
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tipoMotor
     * @param precio
     * @param estado
     * @param kilometraje
     * @param concesionaria
     */
    public Automovil(int numAsientos, boolean esConvertible, boolean camaraRetro, String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor,double precio, EstadoVehiculo estado, double kilometraje, String concesionaria) {
        super(marca, modelo, anioFabricacion, tipoMotor, 4, precio, estado, kilometraje, concesionaria);
        this.numAsientos = numAsientos;
        this.esConvertible = esConvertible;
        this.camaraRetro = camaraRetro;
    }



    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public boolean isEsConvertible() {
        return esConvertible;
    }

    public void setEsConvertible(boolean esConvertible) {
        this.esConvertible = esConvertible;
    }

    public boolean isCamaraRetro() {
        return camaraRetro;
    }

    public void setCamaraRetro(boolean camaraRetro) {
        this.camaraRetro = camaraRetro;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", numAsientos=" + numAsientos + ", esConvertible=" + esConvertible + ", camaraRetro=" + camaraRetro + '}'; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Numero de asientos: " + numAsientos);
        if(esConvertible){
            System.out.println("El auto SI es convertible");
        }else{
            System.out.println("El auto NO es convertible");
        }
        if(camaraRetro){
            System.out.println("El auto Si tiene Camara de Retro");
        }else{
            System.out.println("El auto No tiene Camara de Retro");
        }
    }


    

    


    
    
    
    
}
