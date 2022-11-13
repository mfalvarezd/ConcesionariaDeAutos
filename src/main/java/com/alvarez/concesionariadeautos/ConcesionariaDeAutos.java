/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.alvarez.concesionariadeautos;

import com.alvarez.concesionariadeautos.modelo.*;
import java.util.ArrayList;
import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author Moises Alvarez
 */
public class ConcesionariaDeAutos {

    static ArrayList<Usuario> usuarios = cargarUsuarios();
    static ArrayList<Vehiculo> vehiculos = cargarVehiculos();
    static Usuario usuarioLogeado;
    static Vehiculo vehiculoInteresado;

    public static void main(String[] args) {

        boolean salir = false;
        int opciones;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            System.out.println("Bienvenido al Sistema");
            System.out.println("Menu");
            System.out.println("1) Iniciar Sesion");
            System.out.println("2) Salir del sistema");
            System.out.println("Ingrese su opcion: (Ingrese solo opciones del 1 al 2)");
            opciones = sc.nextInt();

            switch (opciones) {
                case 1:
                    iniciarSesion();// el metodo iniciar sesion nos devuelve un usuario, el usuario que logea se guarda en la variable usuarioLogeado
                    String tipoUsuario = getTipoUsuario(usuarioLogeado);// con esto validamos que tipo de usuario es el que logea para mostrar su respectivo menu
                    switch (tipoUsuario) {
                        case "Cliente":
                            System.out.println("Credenciales correctas");
                            System.out.println("--------------------------------------");
                            System.out.println("\tBienvenido Cliente");
                            System.out.println("--------------------------------------");

                            menuCliente();

                            break;
                        case "Supervisor":
                            System.out.println("Credenciales correctas");
                            System.out.println("--------------------------------------");
                            System.out.println("\tBienvenido Supervisor");
                            System.out.println("--------------------------------------");
                            break;
                        case "Vendedor":
                            System.out.println("Credenciales correctas");
                            System.out.println("--------------------------------------");
                            System.out.println("\tBienvenido Vendedor");
                            System.out.println("--------------------------------------");
                            menuVendedor();
                            break;
                        case "JefeDeTaller":
                            System.out.println("Credenciales correctas");
                            System.out.println("--------------------------------------");
                            System.out.println("\tBienvenido JefeDeTaller");
                            System.out.println("--------------------------------------");
                            break;

                    }
                    break;
                case 2:
                    salir = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Ingrese solo opciones del 1 al 2");
                    break;

            }
        }

    }

    public static void iniciarSesion() {

        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tINGRESO AL SISTEMA");
        System.out.println("--------------------------------------");
        System.out.print("Usuario:");
        String user = input.next();
        System.out.print("Contraseña:");
        String password = input.next();
        while (!validarUsuario(user, password)) {
            System.out.println("User o Password incorrectas");
            System.out.println("Intentelo nuevamente");
            System.out.print("Ingresa el nombre de usuario: ");
            user = input.next();
            System.out.print("Ingresa la contrasena: ");
            password = input.next();

        }

    }

    public static boolean validarUsuario(String user, String password) {

        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(user) && usuario.getPassword().equals(password)) {
                usuarioLogeado = usuario;

                return true;
            }

        }
        return false;
    }

    public static String getTipoUsuario(Usuario usuario) {
        String tipoUsuario = "";

        if (usuario instanceof Cliente) {
            tipoUsuario = "Cliente";
        } else if (usuario instanceof Vendedor) {
            tipoUsuario = "Vendedor";
        } else if (usuario instanceof Supervisor) {
            tipoUsuario = "Supervisor";

        } else if (usuario instanceof JefeDeTaller) {
            tipoUsuario = "JefeDeTaller";
        }

        return tipoUsuario;
    }

    public static void menuCliente() {
        Cliente clienteLogeado = (Cliente) usuarioLogeado;
        boolean salir = false;
        int opciones;
        Scanner opcionesCliente = new Scanner(System.in);

        System.out.println("Usuario: " + clienteLogeado.getNombres() + " " + clienteLogeado.getApellidos());
        if (clienteLogeado.getMensajes().size() > 0) {
            clienteLogeado.leerMensajes();

        } else {
            if (clienteLogeado.getVehiculos().isEmpty()) {

                while (!salir) {
                    System.out.println("\tOpciones");
                    System.out.println("1) Cotizar auto del Stock de vehiculos");
                    System.out.println("2) Revisar Solicitudes pendientes");
                    System.out.println("3) Revisar Mensajes");
                    System.out.println("4) Salir");
                    System.out.println("Ingrese una de las opciones: solo opciones del 1 al 3");
                    opciones = opcionesCliente.nextInt();
                    switch (opciones) {
                        case 1:

                            if (!disponibilidadAutos()) {
                                System.out.println("No tenemos autos disponibles o en stock, vuelva pronto!");
                            } else {
                                int cont = 1;

                                for (Vehiculo vehiculo : stockDeVehiculosAcliente()) {
                                    System.out.println(cont + ") " + vehiculo.mostrarInformacionCliente());
                                    cont++;
                                }
                                System.out.println("0) Cancelar");
                                System.out.println("Ingrese la opcion del auto que desea cotizar: (Ingrese solo opciones del 0 al " + stockDeVehiculosAcliente().size());

                                int opcionVehiculo = opcionesCliente.nextInt();
                                if (opcionVehiculo == 0) {
                                    break;
                                }
                                vehiculoInteresado = stockDeVehiculosAcliente().get(opcionVehiculo - 1);
                                if (clienteLogeado.verificarSolicitud(vehiculoInteresado) == true) {
                                    System.out.println("Ya ha cotizado este vehiculo anteriormente, elija  otro vehiculo");
                                } else {
                                    Solicitud solicitud = clienteLogeado.cotizarVehiculo(vehiculoInteresado);
                                    Vendedor vendedorAleatorio = getVendedorAleatorio();
                                    vendedorAleatorio.addSolicitud(solicitud);//En esta linea le agregamos a un vendedor aleatorio la  cotizacion que genero el 
                                    clienteLogeado.addSolicitud(solicitud);// Le agregamos la solicitud que genero el Cliente a su lista de solicitudes para que pueda verificar el estado de sus solicitudes
                                    System.out.println("Su solicitud ha sido enviada, recibira un mensaje cuando sea contestada");
                                    System.out.println("El vendedor aleatorio: " + vendedorAleatorio.getUsuario());
                                }

                            }
                            break;
                        case 2:
                            System.out.println("Tiene " + clienteLogeado.getSolicitudes().size() + " solicitud(es)");
                            int cont = 1;
                            for (Solicitud solicitud : clienteLogeado.getSolicitudes()) {
                                System.out.println(cont + ") " + solicitud.mostrarInformacion());
                            }
                            break;
                        case 3:

                            if (clienteLogeado.getMensajes().size() > 0) {

                                clienteLogeado.leerMensajes();
                            } else {
                                System.out.println("No tiene mensajes nuevos");
                            }
                            break;

                        case 4:
                            salir = true;
                            break;
                    }
                }

            } else {

            }

        }

    }

    public static void menuVendedor() {
        Vendedor vendedorLogeado = (Vendedor) usuarioLogeado;
        boolean salir = false;
        int opciones;
        Scanner opcionesVendedor = new Scanner(System.in);

        System.out.println("Usuario: " + vendedorLogeado.getNombres() + " " + vendedorLogeado.getApellidos());

        while (!salir) {
            System.out.println("\tOpciones:");
            System.out.println("1) Consultar Vehiculos");
            System.out.println("2) Consultar Solicitudes de Cotizacion");
            System.out.println("3) Salir");
            opciones = opcionesVendedor.nextInt();
            switch (opciones) {
                case 1:
                    int cont = 1;
                    for (Vehiculo vehiculo : vehiculos) {
                        System.out.println(cont + ") " + vehiculo.mostrarInformacion());
                        cont++;

                    }
                    break;
                case 2:
                    if(vendedorLogeado.getSolicitudes().size()==0){
                        System.out.println("No tiene nuevas solicitudes de Cotizacion");
                        break;                   
                    }

                    for (Solicitud solicitud : vendedorLogeado.getSolicitudes()) {
                        System.out.println(solicitud.mostrarInformacion());

                    }
                    System.out.println("1) Aprobar Solicitud");
                    System.out.println("2) Rechazar Solicitud");
                    System.out.println("3) Cancelar");
                    System.out.println("Seleccione una opcion:");
                    opciones = opcionesVendedor.nextInt();
                    switch (opciones) {
                        case 1:
                            cont = 1;
                            for (Solicitud s : vendedorLogeado.getSolicitudes()) {
                                System.out.println(cont + ") " + s.mostrarInformacion());
                                cont++;
                            }
                            System.out.println("Seleccione la opcion que desea Aprobar");
                            int opcionAprobada = opcionesVendedor.nextInt();
                            Solicitud solicitud = vendedorLogeado.getSolicitudes().get(opcionAprobada-1);
                            solicitud.setEstado(EstadoSolicitud.APROBADA);
                            vendedorLogeado.enviarCotizacion((Cliente) solicitud.getUsuario(), solicitud.getVehiculo());
                            System.out.println("Cotizacion Enviada");
                            break;
                        case 2:
                            cont = 1;
                            for (Solicitud s : vendedorLogeado.getSolicitudes()) {
                                System.out.println(cont + ") " + s.mostrarInformacion());
                                cont++;
                            }
                            System.out.println("Seleccione la opcion que desea Aprobar");
                            int opcionRechazada = opcionesVendedor.nextInt();
                            Solicitud solicitudRechazada = vendedorLogeado.getSolicitudes().get(opcionRechazada-1);
                            solicitudRechazada.setEstado(EstadoSolicitud.RECHAZADA);
                            System.out.println("Ingrese motivo de rechazo a la solicitud: ");
                            Scanner motivoEntrada = new Scanner(System.in);
                            String motivo = motivoEntrada.next();
                            vendedorLogeado.rechazarCotizacion((Cliente) solicitudRechazada.getUsuario(), motivo);
                            System.out.println("Cotizacion Rechazada");
                            vendedorLogeado.eliminarSolicitud(solicitudRechazada);
                            motivoEntrada.close();

                            break;
                        case 3:
                            break;
                            
                    }
                case 3:
                    salir= true;

                    break;
            }
        }

    }

    public static Vendedor getVendedorAleatorio() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Vendedor) {
                vendedores.add((Vendedor) usuario);

            }
        }
        int posAleatoria = getNumeroEntre(0, vendedores.size());

        return vendedores.get(posAleatoria);
    }

    public static ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Vendedor("89254", "Luis Fernando", "Quezada Dominguez", "lquezada", "123"));
        listaUsuarios.add(new Vendedor("44598", "Marcos Pedro", "Sanchez Herrera", "msanchez", "123"));
        listaUsuarios.add(new Vendedor("44468", "Carlos Julio", "Hernandez Zamora", "chernandez", "123"));
        listaUsuarios.add(new Cliente("0943675982", "Jefa de Ventas", 1800, "Karla Andrea", "Rivera Vera", "krivera", "123"));
        listaUsuarios.add(new Cliente("0981679527", "Supervisor de Sistemas", 2500, "Winston Humberto", "Leon Gutierrez", "wleon", "123"));
        ArrayList<String> certificacionesAcademicas = new ArrayList<>();
        certificacionesAcademicas.add("Certificación en Gestión Estratégica de Ventas ");
        certificacionesAcademicas.add("Certificacion en Marketing Digital");
        listaUsuarios.add(new Supervisor(certificacionesAcademicas, "Melanie Danna", "Alarcon Veliz", "malarcon", "123"));
        ArrayList<String> certificacionesTecnicas = new ArrayList<>();
        certificacionesTecnicas.add("Certificacion en Jefe de Taller Mecanico");
        certificacionesTecnicas.add("Certificacion en Mecanica Automotriz");
        listaUsuarios.add(new Supervisor(certificacionesTecnicas, "Alvaro Gregorio", "Arboleda Benitez", "Aarboleda", "123"));
        return listaUsuarios;
    }

    public static ArrayList<Vehiculo> cargarVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Automovil(4, false, true, "Chevrolet", "Aveo", 2021, TipoMotor.DIESEL, 21000, EstadoVehiculo.DISPONIBLE, 0, "AutoLasa"));
        vehiculos.add(new Automovil(5, false, true, "Nissan", "Aveo", 2020, TipoMotor.DIESEL, 18500, EstadoVehiculo.DISPONIBLE, 0, "AutoLasa"));
        vehiculos.add(new Tractor(false, TipoTransmision.HIDRAULICA, "Caterpillar", "Oruga", 2019, TipoMotor.DIESEL, 10900.00, EstadoVehiculo.DISPONIBLE, 0.00, "AutoLasa"));
        vehiculos.add(new Motocicleta(MotoCategoria.DEPORTIVA, "Honda", "CRM-250", 2022, TipoMotor.GASOLINA, 4000.00, EstadoVehiculo.DISPONIBLE, 500.00, "AutoLasa"));
        vehiculos.add(new Motocicleta(MotoCategoria.TODOTERRENO, "Yamaha", "DT-200", 2020, TipoMotor.GASOLINA, 2500.00, EstadoVehiculo.DISPONIBLE, 100.00, "AutoLasa"));
        vehiculos.add(new Camion(12000.00, 3, "Chevrolet", "Frigorifico", 2017, TipoMotor.GASOLINA, 6, 25000.00, EstadoVehiculo.DISPONIBLE, 0.00, "AutoLasa"));
        vehiculos.add(new Motocicleta(MotoCategoria.SCOOTER, "Kawasaki", "CRF450X", 2018, TipoMotor.GASOLINA, 4500.00, EstadoVehiculo.DISPONIBLE, 0.00, "AutoLasa"));
        vehiculos.add(new Camion(20000.00, 4, "Hyundai", "Plataforma", 2020, TipoMotor.GASOLINA, 8, 30000.00, EstadoVehiculo.DISPONIBLE, 0.00, "AutoLasa"));
        vehiculos.add(new Tractor(true, TipoTransmision.MECANICA, "Fendt", "Neumaticos", 2021, TipoMotor.DIESEL, 15000.00, EstadoVehiculo.DISPONIBLE, 0.00, "Case IH"));
        return vehiculos;
    }

    public static ArrayList<Vehiculo> stockDeVehiculosAcliente() {
        ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            if (!(v.getEstado().equals(EstadoVehiculo.SOLICITADO))) {
                vehiculosDisponibles.add(v);
            }

        }
        return vehiculosDisponibles;

    }

    public static boolean disponibilidadAutos() {
        return !stockDeVehiculosAcliente().isEmpty();

    }

    public static int getNumeroEntre(int inicio, int fin) {
        Random r = new Random();
        int n = r.nextInt(fin - inicio) + inicio;
        return n;
    }

}
