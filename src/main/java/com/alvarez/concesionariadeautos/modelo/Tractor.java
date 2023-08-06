/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class Tractor extends Vehiculo{

    
    private boolean esAgricola;
    private TipoTransmision  tipoTransmision;

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        if(esAgricola){
            System.out.println("El tractor SI es de uso Agricola");
        }else{
            System.out.println("El tractor NO es de uso Agricola");
        }
        System.out.println("Tipo de transmision: "+tipoTransmision);
    }

    public boolean isEsAgricola() {
        return esAgricola;
    }

    public void setEsAgricola(boolean esAgricola) {
        this.esAgricola = esAgricola;
    }

    public TipoTransmision getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(TipoTransmision tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }



    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+ ", esAgricola=" + esAgricola + ", tipoTransmision=" + tipoTransmision + '}'; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    
}
