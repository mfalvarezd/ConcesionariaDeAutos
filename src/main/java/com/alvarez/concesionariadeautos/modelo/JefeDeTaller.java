/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Moises Alvarez
 */
public class JefeDeTaller extends Usuario{
    private ArrayList<String> certificacionesTecnicas ;
    private ArrayList<Vehiculo> vehiculosPorEntregar;
    private ArrayList<Vehiculo> vehiculosEnMantenimiento;

    public JefeDeTaller(ArrayList<String> certificacionesTecnicas, String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.certificacionesTecnicas = certificacionesTecnicas;
        vehiculosPorEntregar = new ArrayList<>();
        vehiculosEnMantenimiento = new ArrayList<>();
    }

    public ArrayList<String> getCertificacionesTecnicas() {
        return certificacionesTecnicas;
    }

    public void setCertificacionesTecnicas(ArrayList<String> certificacionesTecnicas) {
        this.certificacionesTecnicas = certificacionesTecnicas;
    }

    public ArrayList<Vehiculo> getVehiculosPorEntregar() {
        return vehiculosPorEntregar;
    }

    public void setVehiculosPorEntregar(ArrayList<Vehiculo> vehiculosPorEntregar) {
        this.vehiculosPorEntregar = vehiculosPorEntregar;
    }

    public ArrayList<Vehiculo> getVehiculosEnMantenimiento() {
        return vehiculosEnMantenimiento;
    }

    public void setVehiculosEnMantenimiento(ArrayList<Vehiculo> vehiculosEnMantenimiento) {
        this.vehiculosEnMantenimiento = vehiculosEnMantenimiento;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", certificacionesTecnicas=" + certificacionesTecnicas + ", vehiculosPorEntregar=" + vehiculosPorEntregar + ", vehiculosEnMantenimiento=" + vehiculosEnMantenimiento + '}';
    }
    public void entregarVehiculo(Cliente usuario, Vehiculo vehiculo,Solicitud solicitud){
        for(Vehiculo v: vehiculosPorEntregar){ 
            if(v.equals(vehiculo)){
                usuario.addMensaje(new MensajeConfirmacion(usuario, this,"Se le comunica que ya puede acercarse a retirar su vehiculo: "+v.mostrarInformacion(),solicitud));
                
            }
       
        }
        this.solicitudes.remove(solicitud);
    }
    
    public void aprobarMantenimiento(Cliente usuario, Vehiculo vehiculo,Solicitud solicitud){
        vehiculo.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
        usuario.addMensaje(new MensajeConfirmacion(usuario,this,"Su vehiculo ha sido admitido en el taller para su mantenimiento",solicitud));
        vehiculosEnMantenimiento.add(vehiculo);
        this.solicitudes.remove(solicitud);
        
        
    }
    public void rechazarMantenimiento(Cliente usuario, String motivo,Solicitud solicitud){
        
        usuario.addMensaje(new MensajeConfirmacion(usuario, this,motivo,solicitud));
        solicitudes.remove(solicitud);
    }
    public void calcularCosto(Vehiculo vehiculo,TipoMantenimiento tipoMantenimiento){
        Scanner sc = new Scanner(System.in);
        if(tipoMantenimiento.equals(TipoMantenimiento.PREVENTIVO)){
            System.out.println("El mantenimiento preventivo tiene un costo de: $"+(0.10* vehiculo.getKilometraje()));
        }else{
            System.out.println("Ingrese un valor a cobrar: ");
            double costo = sc.nextDouble();
            System.out.println("El mantenimiento de emergencia tiene un costo de: $"+costo);
            sc.close();
        }
    }
    public void cambiarEstadoDelMantenimiento(Vehiculo vehiculo,EstadoMantenimiento estadoMantenimiento){
        for(Vehiculo v: vehiculosEnMantenimiento){
            if( v.equals(vehiculo)){
                v.setEstadoMantenimiento(estadoMantenimiento);
            }
        }
        
    }
    
    //hola
    
}
