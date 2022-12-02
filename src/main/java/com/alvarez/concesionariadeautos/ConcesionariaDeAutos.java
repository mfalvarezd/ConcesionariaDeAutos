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
 * @author Kevin Maga
 * @author Washington Parra
 */
public class ConcesionariaDeAutos {

    static ArrayList<Usuario> usuarios = cargarUsuarios();//Aqui se cargan todos los usuarios que existen en el sistema
    static ArrayList<Vehiculo> vehiculos = cargarVehiculos();//Lista con el inventario de vehiculos de la concesionaria
    static Usuario usuarioLogeado;//usuario que logea al iniciar sesion al sistema

    static Supervisor supervisor = getSupervisor();//Supervisor encargado de manejar las ventas de la concesionaria
    static JefeDeTaller jefeDeTaller = getJefeDeTaller();//Jefe de taller encargado de manejar el taller
    static final String CONCESIONARIA = "AutoLasa";//Nombre de la condesionaria

    public ConcesionariaDeAutos() {

    }

    public static void main(String[] args) {

        boolean salir = false;
        int opciones;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            System.out.println("Bienvenido al Sistema de la concesionaria " + CONCESIONARIA);
            System.out.println("\tMenu");
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
                            menuSupervisor();
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
                            menuJefeDeTaller();
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

    public static void menuJefeDeTaller() {
        JefeDeTaller jefeLogeado = (JefeDeTaller) usuarioLogeado;
        boolean salir = false;
        int opciones;
        Scanner opcionesJefe = new Scanner(System.in);
        System.out.println("Usuario: " + jefeLogeado.getNombres() + " " + jefeLogeado.getApellidos());
        while (!salir) {

            System.out.println("\tOpciones");
            System.out.println("1) Entregar Vehiculos");
            System.out.println("2) Administrar vehiculos en el Taller");

            System.out.println("3) Salir");
            System.out.println("Ingrese una de las opciones: solo opciones del 1 al 3");
            opciones = opcionesJefe.nextInt();
            switch (opciones) {
                case 1:
                    if (jefeLogeado.getVehiculosPorEntregar().size() > 0) {
                        for (int i = 0; i < jefeLogeado.getVehiculosPorEntregar().size(); i++) {
                            System.out.println((i + 1) + ") " + jefeLogeado.getVehiculosPorEntregar().get(i).getInformacionParaCliente() + " Listo para entrega");
                        }
                        System.out.println("Seleccione el vehiculo a entregar:");
                        System.out.println("Digite 0 para volver:");

                        int indxV = opcionesJefe.nextInt();// posicion del vehiculo en la lista
                        if (indxV == 0) {
                            System.out.println("Volviendo...");
                            break;
                        } else if (indxV > jefeLogeado.getVehiculosPorEntregar().size()) {
                            System.out.println("Esa opcion no existe, intente otra opcion ");
                            break;
                        }

                        Vehiculo vEntrega = jefeLogeado.getVehiculosPorEntregar().get(indxV - 1);//recuperamos el vehiculo que va hacer enviado para entrega
                        for (int i = 0; i < jefeLogeado.getSolicitudes().size(); i++) {
                            if (jefeLogeado.getSolicitudes().get(i).getVehiculo().equals(vEntrega)) {
                                jefeLogeado.entregarVehiculo(vEntrega.getPropietario(), vEntrega, jefeLogeado.getSolicitudes().get(i));//entregamos el vehiculo al cliente
                                jefeLogeado.getSolicitudes().remove(i);// eliminamos la solicitud del sistema ya que ya fue entregado
                            }
                        }

                        System.out.println("Vehiculo listo enviado para entrega...");

                        jefeLogeado.getVehiculosPorEntregar().remove(vEntrega);//eliminamos el vehiculo de la lista de vehiculos listo para entrega

                    } else {
                        System.out.println("No tiene vehiculos listo para entrega");// esto solo se ejecuta si el jefeDeTaller no tienen ningun vehiculo en su lista de vehiculos para entrega

                        System.out.println("Volviendo...");
                        break;

                    }
                    break;
                case 2:
                    if (jefeLogeado.getNsolicitudesMantenimiento() == 0) {// esto se ejectua si el jefeDeTaller no tiene ninguna solicitud

                        System.out.println("No tiene solicitudes nuevas en el taller");

                        System.out.println("Volviendo...");
                        break;

                    }

                    ArrayList<Mantenimiento> solicitudesDeMantenimiento = new ArrayList<>();
                    for (int i = 0; i < jefeLogeado.getSolicitudes().size(); i++) {
                        if (jefeLogeado.getSolicitudes().get(i) instanceof Mantenimiento) {
                            Mantenimiento m = (Mantenimiento) jefeLogeado.getSolicitudes().get(i);
                            if (m.getEstadoDeMantenimiento() == null && m.getVehiculo().getEstado() == null) {
                                solicitudesDeMantenimiento.add(m);

                            }

                        }

                    }

                    System.out.println("Seleccione 1 para agregar vehiculos a listos para entrega");
                    System.out.println("Seleccione 2 para admitir vehiculos al taller");
                    System.out.println("Seleccione 3 para cambiar el estado de Mantenimiento de un vehiculo");
                    System.out.println("Seleccione 4 para volver al menu anterior");

                    Scanner entrada = new Scanner(System.in);
                    int opM = entrada.nextInt();
                    switch (opM) {
                        case 1:
                            if (solicitudesDeMantenimiento.size() == 0) {
                                System.out.println("No tiene vehiculos disponibles para enviar para entrega");
                                break;
                            }

                            for (int i = 0; i < solicitudesDeMantenimiento.size(); i++) {
                                System.out.println((i + 1) + ") " + solicitudesDeMantenimiento.get(i).getVehiculo().mostrarInformacion() + " Estado: " + solicitudesDeMantenimiento.get(i).getEstado());
                            }

                            System.out.println("Seleccione el vehiculo a agregar a la lista de vehiculos para entrega");
                            System.out.println("Seleccione 0 si desea volver al menu anterior");
                            int indxV = entrada.nextInt();
                            if (indxV == 0) {
                                System.out.println("Volviendo....");
                                break;
                            } else if (indxV > solicitudesDeMantenimiento.size()) {
                                System.out.println("Esa opcion no existe, intente otra opcion:");
                                break;
                            }
                            Vehiculo vEntrega = solicitudesDeMantenimiento.get(indxV - 1).getVehiculo();
                            if (vEntrega.getEstadoMantenimiento() == null) {
                                System.out.println("El vehiculo aun no ha sido admitido al taller");
                                System.out.println("Volviendo...");
                                break;

                            } else if (vEntrega.getEstadoMantenimiento() != EstadoMantenimiento.DEALTA) {
                                System.out.println("El vehicula no ha sido dado de alta");
                                System.out.println("Intente otro vehiculo");
                            } else if (vEntrega.getEstado() == EstadoVehiculo.ENTREGADO) {
                                System.out.println("El vehicho ya ha sido agregado a la lista de vehiculos por entregar, intente otro vehiculo");
                                jefeLogeado.getSolicitudes().remove(solicitudesDeMantenimiento.get(indxV - 1));
                            } else {
                                System.out.println("Vehiculo agregado a la lista de vehiculos listos para entrega");
                                vEntrega.setEstado(EstadoVehiculo.ENTREGADO);
                                jefeLogeado.getVehiculosPorEntregar().add(vEntrega);

                                jefeLogeado.getVehiculosEnMantenimiento().remove(solicitudesDeMantenimiento.get(indxV - 1).getVehiculo());// Eliminamos el vehiculo de la lista de vehiculos En Mantenimiento porque ya fue entregado
                                solicitudesDeMantenimiento.remove(indxV - 1);

                                System.out.println("Volviendo...");

                                break;

                            }

                            break;
                        case 2:
                            ArrayList<Mantenimiento> solicitudesNoAdmitidas = new ArrayList<>();
                            for (Mantenimiento m : solicitudesDeMantenimiento) {
                                if (m.getEstadoDeMantenimiento() != EstadoMantenimiento.ADMITIDO) {
                                    solicitudesNoAdmitidas.add(m);
                                }
                            }
                            if (solicitudesNoAdmitidas.size() == 0) {
                                System.out.println("No tiene nuevas solicitudes");
                                System.out.println("Volviendo...");
                                break;
                            }
                            System.out.println("\tSolicitudes");
                            for (int i = 0; i < solicitudesNoAdmitidas.size(); i++) {
                                System.out.println((i + 1) + ") " + solicitudesNoAdmitidas.get(i).mostrarInformacion());

                            }
                            System.out.println("Seleccione 1 si desea admitir un vehiculo al taller");
                            System.out.println("Seleccione 2 si desea rechazar  solicitudes de Mantenimiento");
                            System.out.println("Seleccione 3 para volver al menu anterior:");

                            indxV = entrada.nextInt();

                            switch (indxV) {
                                case 1:

                                    for (int i = 0; i < solicitudesNoAdmitidas.size(); i++) {
                                        System.out.println((i + 1) + ") " + solicitudesNoAdmitidas.get(i).mostrarInformacion());

                                    }
                                    System.out.println("Seleccione el numero del vehiculo a admitir");
                                    System.out.println("Digite 0 para cancelar");
                                    indxV = entrada.nextInt();
                                    if (indxV == 0) {
                                        System.out.println("Saliendo....");
                                        break;
                                    } else if (indxV > solicitudesNoAdmitidas.size()) {
                                        System.out.println("Esa opcion no existe, intente otra opcion");
                                        break;
                                    }
                                    Vehiculo vAdmitir = solicitudesNoAdmitidas.get(indxV - 1).getVehiculo();
                                    if (vAdmitir.getConcesionaria().equals(CONCESIONARIA)) {
                                        if (vAdmitir.getEstadoMantenimiento() == null) {
                                            System.out.println("Vehiculo admitido al taller");
                                            vAdmitir.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
                                            jefeLogeado.aprobarMantenimiento((Cliente) solicitudesNoAdmitidas.get(indxV - 1).getUsuario(), vAdmitir, solicitudesNoAdmitidas.get(indxV - 1));

                                            System.out.println("Volviendo...");

                                            solicitudesNoAdmitidas.remove(indxV - 1);//eliminamos la solicitud de la lista de vehiculos que no han sido admitidos

                                            break;

                                        } else if (vAdmitir.getEstado() == EstadoVehiculo.ENTREGADO) {
                                            System.out.println("Este vehiculo ya ha sido agregado a la lista de entrega");
                                        } else {
                                            System.out.println("El vehicula ya ha sido admitido");
                                            System.out.println("Intente otro vehiculo");

                                        }

                                    } else {
                                        System.out.println("El vehiculo no puede ser admitido porque no pertenece a " + CONCESIONARIA);
                                        jefeLogeado.rechazarMantenimiento((Cliente) solicitudesNoAdmitidas.get(indxV - 1).getUsuario(), "El vehiculo no puede ser admitido porque no pertenece a " + CONCESIONARIA, solicitudesNoAdmitidas.get(indxV - 1));
                                        System.out.println("Volviendo...");
                                        break;
                                    }
                                    break;
                                case 2:
                                    for (int i = 0; i < solicitudesNoAdmitidas.size(); i++) {
                                        System.out.println((i + 1) + ") " + solicitudesNoAdmitidas.get(i).mostrarInformacion());

                                    }
                                    System.out.println("Seleccione el vehiculo a Rechazar");
                                    System.out.println("Digite 0 para volver:");
                                    indxV = entrada.nextInt();
                                    if (indxV == 0) {
                                        System.out.println("Saliendo....");
                                        break;
                                    } else if (indxV > solicitudesNoAdmitidas.size()) {
                                        System.out.println("Esa opcion no existe, intente otra opcion");
                                        break;
                                    }
                                    Scanner entradaT = new Scanner(System.in);
                                    System.out.println("Ingrese el motivo del rechazo:");
                                    String motivo = entradaT.nextLine();
                                    jefeLogeado.rechazarMantenimiento((Cliente) solicitudesNoAdmitidas.get(indxV - 1).getUsuario(), motivo, solicitudesNoAdmitidas.get(indxV - 1));
                                    System.out.println("Volviendo...");
                                    break;
                                case 3:
                                    System.out.println("Volviendo....");
                                    break;
                                default:
                                    System.out.println("Ingrese solo opciones del 1 al 3");
                                    break;

                            }

                            break;
                        case 3:
                            if (jefeLogeado.getVehiculosEnMantenimiento().size() == 0) {
                                System.out.println("No tiene vehiculos en mantenimiento actualmente");
                                System.out.println("Seleccione 0 para volver");
                                indxV = opcionesJefe.nextInt();
                                if (indxV == 0) {
                                    System.out.println("Volviendo...");
                                    break;
                                } else if (indxV > jefeLogeado.getVehiculosEnMantenimiento().size()) {
                                    System.out.println("Esa opcion no existe, intente otra opcion");
                                    break;
                                }
                            }
                            for (int i = 0; i < jefeLogeado.getVehiculosEnMantenimiento().size(); i++) {
                                System.out.println((i + 1) + ") " + jefeLogeado.getVehiculosEnMantenimiento().get(i).getInformacionParaCliente() + " ESTADO: " + jefeLogeado.getVehiculosEnMantenimiento().get(i).getEstadoMantenimiento());
                            }
                            System.out.println("Seleccione el numero del vehiculo que desea cambiar su estado de mantenimiento: ");
                            System.out.println("Seleccione 0 para volver");
                            indxV = opcionesJefe.nextInt();
                            if (indxV == 0) {
                                System.out.println("Volviendo...");
                                break;
                            } else if (indxV > 0) {
                                System.out.println("Seleccione el estado a cambiar:");
                                System.out.println("1) En Reparacion");
                                System.out.println("2) En Estapa de Prueba");
                                System.out.println("3) De Alta");
                                System.out.println("4) Volver");

                                opM = opcionesJefe.nextInt();
                                if (opM == 4) {
                                    System.out.println("Volviendo...");
                                    break;
                                } else if (opM == 1) {
                                    jefeLogeado.cambiarEstadoDelMantenimiento(jefeLogeado.getVehiculosEnMantenimiento().get(indxV - 1), EstadoMantenimiento.ENREPARACION);
                                    System.out.println("Cambio de estado completo, volviendo...");
                                    break;
                                } else if (opM == 2) {
                                    System.out.println("Cambio de estado completo, volviendo...");
                                    jefeLogeado.cambiarEstadoDelMantenimiento(jefeLogeado.getVehiculosEnMantenimiento().get(indxV - 1), EstadoMantenimiento.ETAPAPRUEBA);
                                    break;
                                } else if (opM == 3) {
                                    jefeLogeado.cambiarEstadoDelMantenimiento(jefeLogeado.getVehiculosEnMantenimiento().get(indxV - 1), EstadoMantenimiento.DEALTA);
                                    System.out.println("Cambio de estado completo, volviendo...");
                                    break;
                                } else {
                                    System.out.println("Esa opcion no existe, intente otra opcion...");
                                }
                            } else if (indxV > jefeLogeado.getVehiculosEnMantenimiento().size()) {
                                System.out.println("Esa opcion no existe, intente otra opcion");
                                break;

                            }
                            break;
                        default:
                            System.out.println("Ingrese solo opciones del 1 al 3");
                            break;

                    }

                    break;
                case 3:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese solo opciones del 1 al 3:");
                    break;
            }

        }
    }

    public static void menuSupervisor() {
        Supervisor supervisorLogeado = (Supervisor) usuarioLogeado;
        boolean salir = false;
        int opciones;
        Scanner opcionesSupervisor = new Scanner(System.in);

        System.out.println("Usuario: " + supervisorLogeado.getNombres() + " " + supervisorLogeado.getApellidos());
        while (!salir) {
            if (supervisorLogeado.getSolicitudes().size() > 0) {
                System.out.println("Tiene: " + supervisorLogeado.getSolicitudes().size() + " solicitud(es) de compra(s) nueva(s)");

            }
            System.out.println("\tOpciones");
            System.out.println("1) Revisar solicitudes de compra");
            System.out.println("2) Consultar numero de vehiculos vendidos por los vendedores");
            System.out.println("3) Ingresar nuevos vehiculos al stock");
            System.out.println("4) Salir");
            System.out.println("Ingrese una de las opciones: solo opciones del 1 al 4");
            opciones = opcionesSupervisor.nextInt();
            switch (opciones) {
                case 1:
                    if (supervisorLogeado.getSolicitudes().size() == 0) {
                        System.out.println("No tiene nuevas solicitudes de Compra");

                        System.out.println("Volviendo...");
                        break;

                    }

                    for (Solicitud solicitud : supervisorLogeado.getSolicitudes()) {
                        Compra compraSoli = (Compra) solicitud;
                        System.out.println(compraSoli.mostrarInformacionSupervisor());
                    }

                    System.out.println("Digite 1 si desea aprobar solicitudes de compra");
                    System.out.println("Digite 2 si desea rechazar solicitudes de compra");
                    System.out.println("Digite 0 si desea volver al menu");
                    System.out.println("Ingrese su opcion:");

                    int opcionCompra = opcionesSupervisor.nextInt();
                    switch (opcionCompra) {
                        case 1:

                            for (int i = 0; i < supervisorLogeado.getSolicitudes().size(); i++) {
                                Compra compraSoli = (Compra) supervisorLogeado.getSolicitudes().get(i);// recuperamos la compra de la lsita de solicitudes de supervisor
                                System.out.println((i + 1) + ")" + compraSoli.mostrarInformacionSupervisor());
                                System.out.println("Seleccione 1 para aceptar la solicitud de compra");
                                System.out.println("Seleccione 0 para volver");

                                int opcionM = opcionesSupervisor.nextInt();
                                if (opcionM == 0) {
                                    System.out.println("Volviendo al menu...");
                                    break;
                                } else if(opcionM==1){
                                    Cliente clienteComprador = (Cliente) compraSoli.getUsuario();

                                    Vendedor vendedorDelVehiculo = (Vendedor) compraSoli.getVendedor();
                                    Vehiculo vehiculoSolicitado = compraSoli.getVehiculo();
                                    vehiculoSolicitado.setPropietario(clienteComprador);

                                    supervisorLogeado.aprobarCompra(clienteComprador, vehiculoSolicitado, compraSoli);
                                    jefeDeTaller.addSolicitud(compraSoli);
                                    jefeDeTaller.getVehiculosPorEntregar().add(vehiculoSolicitado);
                                    supervisorLogeado.aggVentasAprobadas(vendedorDelVehiculo);//le sumamos +1 al numero de vehiculos que ha vendido el vendedor
                                    System.out.println("Solicitud contestada, eliminando solicitud del registro...");
                                    supervisorLogeado.getSolicitudes().remove(i);

                                }else{
                                    System.out.println("Esa opcion no existe, ingrese 1 o 0");
                                }

                            }
                            break;
                        case 2:

                            for (int i = 0; i < supervisorLogeado.getSolicitudes().size(); i++) {
                                Compra compraSoli = (Compra) supervisorLogeado.getSolicitudes().get(i);
                                System.out.println((i + 1) + ")" + compraSoli.mostrarInformacionSupervisor());
                                System.out.println("Seleccione 1 para rechazar la solicitud de compra");
                                System.out.println("Seleccione 0 para volver");

                                int opcionM = opcionesSupervisor.nextInt();
                                if (opcionM == 0) {
                                    System.out.println("Volviendo al menu...");
                                    break;
                                } else if(opcionM==1){
                                    Scanner entradaTexto = new Scanner(System.in);
                                    System.out.println("Ingrese el motivo:");

                                    String motivo = entradaTexto.nextLine();
                                    Cliente clienteComprador = (Cliente) compraSoli.getUsuario();
                                    Vendedor vendedorDelVehiculo = (Vendedor) compraSoli.getVendedor();
                                    Vehiculo vehiculoSolicitado = compraSoli.getVehiculo();
                                    supervisorLogeado.rechazarCompra(clienteComprador, motivo, vehiculoSolicitado, compraSoli);

                                    System.out.println("Solicitud contestada, eliminando solicitud del registro...");
                                    supervisorLogeado.getSolicitudes().remove(i);

                                }else{
                                    System.out.println("Esa opcion no existe ingrese 1 o 0");
                                }

                            }

                            break;
                        case 0:
                            System.out.println("Volviendo al menu...");
                            break;
                        default:
                            System.out.println("Ingrese solo opciones del 0 al 2:");
                            break;
                    }

                    break;
                case 2:
                    int i = 1;
                    
                    for (Usuario usuario : usuarios) {
                        if (usuario instanceof Vendedor) {
                            System.out.println(i + ") Vendedor:" + usuario.getNombres() + " " + usuario.getApellidos() + " id: " + ((Vendedor) usuario).getId() + " Numero de ventas concretadas:" + ((Vendedor) usuario).getVentasAprobadas());
                            i++;
                        }

                    }
                    System.out.println("Digite 0 para volver al menu");
                    Scanner sc = new Scanner(System.in);
                    int volver = sc.nextInt();
                    switch(volver){
                        case 0:
                            System.out.println("Volviendo...");
                            break;
                        default:
                            System.out.println("Esa opcion no existe");
                            break;
                              
                    }
                    break;
                case 3:
                    System.out.println("Ingreso de nuevos vehiculos al stock");

                    System.out.println("1) Automovil");
                    System.out.println("2) Camion");
                    System.out.println("3) Motocicleta");
                    System.out.println("4) Tractor");
                    System.out.println("5) Volver");
                    System.out.println("Ingrese el tipo de vehiculo que desea agregar:");
                    Scanner input = new Scanner(System.in);
                    int cOpcion = input.nextInt();
                    switch (cOpcion) {

                        case 1:
                            TipoMotor motor;
                            boolean convertible;
                            boolean camara;
                            System.out.println("Ingrese la marca del vehiculo:");
                            String marca = input.next();
                            System.out.println("Ingrese el modelo del vehiculo: ");
                            String modelo = input.next();
                            System.out.println("Ingrese el año de fabricacion: ");
                            int anioFabricacion = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese el tipo de Motor: (Diesel, Gasolina)");
                            System.out.println("1)Diesel");
                            System.out.println("2)Gasolina");
                            int motorOp = input.nextInt();
                            if (motorOp == 1) {
                                motor = TipoMotor.DIESEL;
                            } else {
                                motor = TipoMotor.GASOLINA;
                            }
                            System.out.println("Ingrese el precio del vehiculo:");
                            double precio = input.nextDouble();
                            input.nextLine();

                            System.out.println("Ingrese el kilometraje del vehiculo: ");
                            double km = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese el numero de asientos del vehiculo:");
                            int numAsientos = input.nextInt();
                            input.nextLine();
                            System.out.println("El auto es convertible, responda con un y/n para responder Si O No:");
                            String esConvertible = input.next();
                            if (esConvertible.toLowerCase().equals("y")) {
                                convertible = true;
                            } else {
                                convertible = false;
                            }
                            System.out.println("El auto tiene camara de retro, responda con un y/n para responder Si o NO:");
                            String wCamara = input.next();
                            if (wCamara.toLowerCase().equals("y")) {
                                camara = true;
                            } else {
                                camara = false;
                            }
                            System.out.println("Ingrese la concesionaria del vehiculo:");
                            String nombreConcesionaria = input.next();
                            Vehiculo vehiculo = new Automovil(numAsientos, convertible, camara, marca, modelo, anioFabricacion, motor, precio, EstadoVehiculo.DISPONIBLE, km, nombreConcesionaria);
                            if (!vehiculos.contains(vehiculo)) {
                                vehiculos.add(vehiculo);
                                System.out.println("Vehiculo agregado correctamente al stock");
                            } else {
                                System.out.println("Ese vehiculo ya existe en el stock de vehiculos");
                            }
                            break;
                        case 2:
                            TipoMotor motorC;

                            System.out.println("Ingrese la marca del vehiculo:");
                            marca = input.nextLine();
                            System.out.println("Ingrese el modelo del vehiculo: ");
                            modelo = input.nextLine();
                            System.out.println("Ingrese el año de fabricacion: ");
                            anioFabricacion = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese el tipo de Motor: (Diesel, Gasolina)");
                            System.out.println("1)Diesel");
                            System.out.println("2)Gasolina");
                            motorOp = input.nextInt();
                            if (motorOp == 1) {
                                motor = TipoMotor.DIESEL;
                            } else {
                                motor = TipoMotor.GASOLINA;
                            }
                            System.out.println("Ingrese el numero de llantas:");
                            int numLlantas = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese el precio del vehiculo:");
                            precio = input.nextDouble();
                            input.nextLine();

                            System.out.println("Ingrese el kilometraje del vehiculo: ");
                            km = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese la capacidad de carga en kg:");
                            double cargaM = input.nextDouble();
                            input.nextLine();

                            System.out.println("Ingrese la concesionaria del vehiculo:");
                            nombreConcesionaria = input.nextLine();
                            Camion camion = new Camion(cargaM, marca, modelo, anioFabricacion, motor, numLlantas, precio, EstadoVehiculo.DISPONIBLE, km, nombreConcesionaria);
                            if (!vehiculos.contains(camion)) {
                                vehiculos.add(camion);
                                System.out.println("Vehiculo agregado correctamente al stock");
                            } else {
                                System.out.println("Ese vehiculo ya existe en el stock de vehiculos");
                            }
                            break;
                        case 3:

                            System.out.println("Ingrese la marca del vehiculo:");
                            marca = input.next();
                            System.out.println("Ingrese el modelo del vehiculo:");
                            modelo = input.next();
                            System.out.println("Ingrese el año de fabricacion:");
                            anioFabricacion = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese el tipo de Motor: (Diesel, Gasolina)");
                            System.out.println("1)Diesel");
                            System.out.println("2)Gasolina");
                            motorOp = input.nextInt();
                            if (motorOp == 1) {
                                motor = TipoMotor.DIESEL;
                            } else {
                                motor = TipoMotor.GASOLINA;
                            }
                            System.out.println("Ingrese el precio del vehiculo:");
                            precio = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese el kilometraje del vehiculo:");
                            km = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese la categoria de la moto:");
                            System.out.println("1) Deportiva ");
                            System.out.println("2) Scooter");
                            System.out.println("3) Todo terreno");
                            int categoria = input.nextInt();
                            MotoCategoria motoC = null;
                            if (categoria == 1) {
                                motoC = MotoCategoria.DEPORTIVA;
                            } else if (categoria == 2) {
                                motoC = MotoCategoria.SCOOTER;
                            } else if (categoria == 3) {
                                motoC = MotoCategoria.TODOTERRENO;
                            }
                            input.nextLine();
                            System.out.println("Ingrese la concesionaria del vehiculo:");
                            nombreConcesionaria = input.nextLine();
                            Motocicleta motocicleta = new Motocicleta(motoC, marca, modelo, anioFabricacion, motor, precio, EstadoVehiculo.DISPONIBLE, km, nombreConcesionaria);
                            if (!vehiculos.contains(motocicleta)) {
                                vehiculos.add(motocicleta);
                                System.out.println("Vehiculo agregado correctamente al stock de vehiculos");
                            } else {
                                System.out.println("Este vehiculo ya se encuentra en el stock");
                            }
                            break;
                        case 4:
                            TipoTransmision transmision;
                            boolean esAgricola;
                            System.out.println("Ingrese la marca del vehiculo:");
                            marca = input.next();
                            System.out.println("Ingrese el modelo del vehiculo:");
                            modelo = input.next();
                            System.out.println("Ingrse el año de fabricacion:");
                            anioFabricacion = input.nextInt();
                            input.nextLine();

                            System.out.println("Ingrese el precio del vehiculo:");
                            precio = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese el kilometraje del vehiculo:");
                            km = input.nextDouble();
                            input.nextLine();
                            System.out.println("Ingrese el tipo de transmision del tractor:");
                            System.out.println("1) Hidraulica");
                            System.out.println("2) Mecanica");

                            int transOp = input.nextInt();

                            if (transOp == 1) {
                                transmision = TipoTransmision.HIDRAULICA;
                            } else {
                                transmision = TipoTransmision.MECANICA;
                            }
                            input.nextLine();
                            System.out.println("El tractor es de uso agricola, ingrese y/n para escribir Si o NO:");
                            String agricola = input.next();
                            if (agricola.toLowerCase().equals("y")) {
                                esAgricola = true;
                            } else {
                                esAgricola = false;
                            }
                            System.out.println("Ingrese la concesionaria del vehiculo:");
                            nombreConcesionaria = input.nextLine();
                            Tractor tractor = new Tractor(esAgricola, transmision, marca, modelo, anioFabricacion, precio, EstadoVehiculo.DISPONIBLE, km, nombreConcesionaria);
                            if (!vehiculos.contains(tractor)) {
                                vehiculos.add(tractor);
                                System.out.println("Vehiculo agregado correctamente al stock de vehiculos");
                            } else {
                                System.out.println("Este vehiculo ya se encuentra en el stock");
                            }

                            break;
                        case 5:
                            System.out.println("Volviendo...");
                            break;
                        default:
                            System.out.println("Seleccione solo opciones del 1 al 5");
                            break;
                         

                    }

                    break;
                case 4:
                    System.out.println("Cerrando sesion...");
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese solo opciones del 1 al 4");
                    break;
            }

        }
    }

    public static void menuCliente() {
        Cliente clienteLogeado = (Cliente) usuarioLogeado;
        boolean salir = false;
        int opciones;
        Scanner opcionesCliente = new Scanner(System.in);

        System.out.println("Usuario: " + clienteLogeado.getNombres() + " " + clienteLogeado.getApellidos());

        while (!salir) {
            if (clienteLogeado.getMensajes().size() > 0) {
                System.out.println("Tiene: " + clienteLogeado.getMensajes().size() + " mensaje nuevo(s)");

            }
            System.out.println("\tOpciones");
            System.out.println("1) Cotizar auto del Stock de vehiculos");
            System.out.println("2) Revisar Solicitudes pendientes");
            System.out.println("3) Revisar Mensajes");
            if (esClienteHabitual(clienteLogeado)) {

                System.out.println("4) Realizar Mantenimiento");
            }

            System.out.println("0) Salir");
            System.out.println("Ingrese una de las opciones (1-5):");
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
                        Vehiculo vehiculoInteresado = stockDeVehiculosAcliente().get(opcionVehiculo - 1);//vehiculo que el cliente quiere cotizar
                        if (clienteLogeado.verificarSolicitud(vehiculoInteresado) == true) {
                            System.out.println("Ya ha cotizado este vehiculo anteriormente, elija  otro vehiculo");
                        } else {
                            Cotizacion solicitudCotizacion = clienteLogeado.cotizarVehiculo(vehiculoInteresado);
                            Vendedor vendedorAleatorio = getVendedorAleatorio();
                            vendedorAleatorio.addSolicitud(solicitudCotizacion);//En esta linea le agregamos a un vendedor aleatorio la  cotizacion que genero el 
                            clienteLogeado.addSolicitud(solicitudCotizacion);// Le agregamos la solicitud que genero el Cliente a su lista de solicitudes para que pueda verificar el estado de sus solicitudes
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
                    System.out.println("Digite 0 para volver al menu");
                    int op = opcionesCliente.nextInt();
                    if (op == 0) {
                        System.out.println("Volviendo al menu...");
                        break;
                    }

                    break;
                case 3:

                    if (clienteLogeado.getMensajes().size() == 0) {
                        System.out.println("No tiene mensajes nuevos");
                        System.out.println("Digite 0 para volver al menu:");
                        op = opcionesCliente.nextInt();
                        if (op == 0) {
                            System.out.println("Volviendo al menu");
                            break;
                        }
                        break;
                    }
                    for (int i = 0; i < clienteLogeado.getMensajes().size(); i++) {

                        Mensaje mensaje = clienteLogeado.getMensajes().get(i);
                        Usuario emisor = mensaje.getEmisor();

                        if (mensaje.getEmisor() instanceof Vendedor && mensaje.getSolicitud().getEstado().equals(EstadoSolicitud.RECHAZADA)) {

                            MensajeCotizacion mensajeC = (MensajeCotizacion) clienteLogeado.getMensajes().get(i);//Mensaje de cotizacion que envia el vendedor con su respuesta
                            Vehiculo vehiculoCotizado = mensajeC.getVehiculo();
                            System.out.println("\nSu solicitud fue rechazada para el vehiculo: " + vehiculoCotizado.getInformacionParaCliente() + " porque:" + mensaje.getMensaje());
                            System.out.println("Eliminando mensaje...");

                            clienteLogeado.getMensajes().remove(mensaje);// eliminamos el mensaje del imbox del cliente para evitar mensajes acumulados
                            clienteLogeado.getSolicitudes().remove(mensaje.getSolicitud());// eliminamos la solicitud del cliente ya que ya fue rechazada
                            System.out.print("Digite 0 para volver al menu:");

                            Scanner entradaMensaje = new Scanner(System.in);
                            int opcionMensaje = entradaMensaje.nextInt();
                            if (opcionMensaje == 0) {
                                System.out.println("Volviendo al menu...");
                                break;
                            }

                        } else if (mensaje.getEmisor() instanceof Vendedor) {
                            MensajeCotizacion mensajeC = (MensajeCotizacion) clienteLogeado.getMensajes().get(i);// downcastin porque es un mensaje de tipo cotizacion
                            Vehiculo vehiculoCotizado = mensajeC.getVehiculo();
                            System.out.println(mensajeC.getMensaje());
                            Vendedor vendedorAsignado = (Vendedor) mensajeC.getEmisor();
                            vehiculoCotizado.mostrarDatos();
                            System.out.println("Digite 1 para solicitar la compra del vehiculo");
                            System.out.println("Digite 2 para rechazar la oferta del vehiculo");
                            System.out.println("Digite 0 para volver al menu");
                            System.out.println("Digite su opcion:");
                            Scanner entradaMensaje = new Scanner(System.in);
                            int opcionMensaje = entradaMensaje.nextInt();
                            switch (opcionMensaje) {
                                case 1:
                                    System.out.println("Se ha enviado la solicitud de compra");
                                    System.out.println("Le enviaremos un mensaje cuando su solicitud sea respondida");
                                    System.out.println("Eliminando mensaje...");
                                    Compra solicitudCompra = clienteLogeado.comprarVehiculo(vehiculoCotizado, vendedorAsignado);
                                    supervisor.addSolicitud(solicitudCompra);
                                    clienteLogeado.addSolicitud(solicitudCompra);
                                    clienteLogeado.getMensajes().remove(mensaje);//eliminamos el mensaje ya leido
                                    clienteLogeado.getSolicitudes().remove(mensaje.getSolicitud());//removemos la solicitud que ya fue contesta de la lista de solicitudes del usaurio
                                    break;
                                case 2:
                                    System.out.println("Ha rechazado la oferta");
                                    System.out.println("Vuelva pronto");
                                    System.out.println("Eliminando mensaje...");
                                    clienteLogeado.getMensajes().remove(mensaje);
                                    clienteLogeado.getSolicitudes().remove(mensaje.getSolicitud());
                                    break;
                                case 0:
                                    System.out.println("Volviendo al menu...");
                                    i = clienteLogeado.getMensajes().size();
                                    break;

                            }

                        } else if (mensaje.getEmisor() instanceof Supervisor) {
                            System.out.println(mensaje.getMensaje());// mostramos el mensaje que envia supervisor

                            System.out.println("Digite 0 para volver al menu");
                            Scanner sc = new Scanner(System.in);
                            int volver = sc.nextInt();
                            if (volver == 0) {
                                System.out.println("Mensaje leido, eliminando mensaje...");
                                System.out.println("Volviendo...");
                                clienteLogeado.getMensajes().remove(mensaje);
                                break;
                            }

                        } else if (mensaje.getEmisor() instanceof JefeDeTaller) {
                            System.out.println(mensaje.getMensaje());//Mostramos el mensaje
                            if (mensaje.getSolicitud() instanceof Mantenimiento) {
                                System.out.println("Digite 1 para aceptar");
                                System.out.println("Digite 0 para volver:");
                                mensaje.getSolicitud().getVehiculo().setEstado(null);
                                mensaje.getSolicitud().getVehiculo().setEstadoMantenimiento(null);
                                op = opcionesCliente.nextInt();
                                if (op == 0) {

                                    System.out.println("Volviendo...");

                                    break;

                                } else {
                                    System.out.println("Mensaje leido");
                                    System.out.println("Volviendo al menu...");
                                    clienteLogeado.getSolicitudes().remove(mensaje.getSolicitud());
                                    clienteLogeado.getMensajes().remove(mensaje);
                                    break;
                                }

                            } else if (mensaje instanceof MensajeConfirmacion) {
                                System.out.println("Digite 1 para recoger el vehiculo");
                                System.out.println("Digite 0 para volver al menu");
                                op = opcionesCliente.nextInt();
                                if (op == 0) {

                                    System.out.println("Volviendo...");

                                    break;

                                } else {
                                    System.out.println("Auto recogido, agregado a su lista de vehiculos");
                                    System.out.println("Mensaje leido eliminando mensaje...");
                                    System.out.println("Volviendo...");
                                    Vehiculo vCliente = mensaje.getSolicitud().getVehiculo();
                                    vCliente.setPropietario(clienteLogeado);
                                    vCliente.setEstado(null);
                                    vCliente.setEstadoMantenimiento(null);
                                    clienteLogeado.addVehiculo(vCliente);
                                    clienteLogeado.getMensajes().remove(mensaje);//eliminamos el mensaje ya leido
                                    clienteLogeado.getSolicitudes().remove(mensaje.getSolicitud());//eliminamos la solicitud de compra que ya fue resulta en su totalidad
                                    vehiculos.remove(vCliente); // eliminamos el vehiculo de la lista de vehiculos de la empresa
                                    break;
                                }

                            }

                        }

                    }
                    break;

                case 4:
                    if (clienteLogeado.getVehiculos().size() == 0) {

                        System.out.println("Usted no tiene ningun vehiculo al cual poder hacerle mantenimiento");
                        System.out.println("Seleccione 0 para volver:");
                        int opcionesM = opcionesCliente.nextInt();
                        if (opcionesM == 0) {
                            System.out.println("Volviendo...");
                            break;
                        }
                    }

                    System.out.println("Tipo de Mantenimiento");
                    System.out.println("1) Mantenimiento Preventivo");
                    System.out.println("2) Mantenimiento Emergente");
                    System.out.println("0) volver");
                    System.out.println("Seleccione una de las opciones :");
                    int opcionesMantenimiento = opcionesCliente.nextInt();
                    switch (opcionesMantenimiento) {
                        case 1:
                            System.out.println("\tVehiculos propios de " + clienteLogeado.getNombres() + " " + clienteLogeado.getApellidos());

                            for (int i = 0; i < clienteLogeado.getVehiculos().size(); i++) {
                                System.out.println((i + 1) + ") " + clienteLogeado.getVehiculos().get(i).getInformacionParaCliente());
                            }
                            System.out.println("Seleccione el auto que desea solicitar mantenimiento Preventivo");
                            System.out.println("Selecciione 0 para volver");
                            opcionesMantenimiento = opcionesCliente.nextInt();
                            if (opcionesMantenimiento == 0) {
                                System.out.println("Volviendo...");
                                break;
                            }
                            Vehiculo vehiculoParaMantenimiento = clienteLogeado.getVehiculos().get(opcionesMantenimiento - 1);//recuperamos el vehiculo que se hara mantenimiento de la lsita personal del cliente
                            Mantenimiento solicitudMantenimiento = clienteLogeado.mantenerAuto(vehiculoParaMantenimiento, TipoMantenimiento.PREVENTIVO);
                            if (clienteLogeado.verificarSolicitud(vehiculoParaMantenimiento)) {
                                System.out.println("Este vehiculo ya fue solicitado para Mantenimiento");
                                break;
                            }
                            jefeDeTaller.addSolicitud(solicitudMantenimiento);
                            clienteLogeado.addSolicitud(solicitudMantenimiento);
                            System.out.println("Su solicitud ha sido enviada, le enviaremos un mensaje cuando su solicitud sea respondida");

                            break;
                        case 2:
                            System.out.println("\tLista de vehiculos del cliente:");
                            for (int i = 0; i < clienteLogeado.getVehiculos().size(); i++) {
                                System.out.println((i + 1) + ") " + clienteLogeado.getVehiculos().get(i).getInformacionParaCliente());
                            }
                            System.out.println("Seleccione el auto que desea solicitar mantenimiento Emergente");
                            opcionesMantenimiento = opcionesCliente.nextInt();
                            Vehiculo vEmergente = clienteLogeado.getVehiculos().get(opcionesMantenimiento - 1);
                            if (clienteLogeado.verificarSolicitud(vEmergente)) {
                                System.out.println("Este vehiculo ya fue solicitado para Mantenimiento");
                                break;
                            }
                            Mantenimiento solicitudMantenimientoE = clienteLogeado.mantenerAuto(vEmergente, TipoMantenimiento.EMERGENTE);

                            jefeDeTaller.addSolicitud(solicitudMantenimientoE);
                            clienteLogeado.addSolicitud(solicitudMantenimientoE);
                            System.out.println("Su solicitud ha sido enviada, le enviaremos un mensaje cuando su solicitud sea respondida");

                            break;
                        case 0:
                            System.out.println("Volviendo al menu...");
                            break;

                    }
                    break;

                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo opciones del 0 al 4");
                    break;
            }
        }

    }

    public static boolean esClienteHabitual(Cliente cliente) {

        for (Vehiculo vehiculo : cliente.getVehiculos()) {
            if (vehiculo.getConcesionaria().equals(CONCESIONARIA)) {

                return true;

            }

        }
        return false;

    }

    public static void menuVendedor() {
        Vendedor vendedorLogeado = (Vendedor) usuarioLogeado;
        boolean logout = false;
        int opciones;
        Scanner opcionesVendedor = new Scanner(System.in);

        System.out.println("Usuario: " + vendedorLogeado.getNombres() + " " + vendedorLogeado.getApellidos());

        while (!logout) {
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
                    Scanner entradaVendedor = new Scanner(System.in);

                    System.out.println("Ingrese 0 para volver al menu:");
                    int opcionVendedor = entradaVendedor.nextInt();
                    if (opcionVendedor == 0) {
                        System.out.println("Volviendo al menu...");
                        break;
                    }

                case 2:
                    if (vendedorLogeado.getSolicitudes().size() == 0) {
                        System.out.println("No tiene nuevas solicitudes de Cotizacion");
                        System.out.println("Seleccione 0 para volver al menu");
                        int opcion = opcionesVendedor.nextInt();
                        if (opcion == 0) {
                            System.out.println("Volviendo...");
                            break;
                        }

                    }

                    for (Solicitud solicitud : vendedorLogeado.getSolicitudes()) {
                        System.out.println(solicitud.mostrarInformacion());

                    }
                    System.out.println("1) Aprobar Solicitud");
                    System.out.println("2) Rechazar Solicitud");
                    System.out.println("3) Cancelar");
                    System.out.println("Seleccione una opcion:");
                    int opcionesM = opcionesVendedor.nextInt();
                    switch (opcionesM) {
                        case 1:
                            cont = 1;
                            for (Solicitud s : vendedorLogeado.getSolicitudes()) {
                                System.out.println(cont + ") " + s.mostrarInformacion());
                                cont++;
                            }
                            System.out.println("0) Volver al menu solicitudes");
                            System.out.println("Seleccione la opcion que desea Aprobar");
                            int opcionAprobada = opcionesVendedor.nextInt();
                            if (opcionAprobada == 0) {
                                System.out.println("Volviendo...");
                                break;
                            }
                            Solicitud solicitud = vendedorLogeado.getSolicitudes().get(opcionAprobada - 1);
                            solicitud.setEstado(EstadoSolicitud.APROBADA);
                            vendedorLogeado.enviarCotizacion((Cliente) solicitud.getUsuario(), solicitud.getVehiculo(), solicitud);
                            System.out.println("Cotizacion Enviada");
                            System.out.println("Solicitud contestada, eliminando solicitud del sistema...");
                            vendedorLogeado.eliminarSolicitud(solicitud);
                            break;

                        case 2:
                            cont = 1;
                            for (Solicitud s : vendedorLogeado.getSolicitudes()) {
                                System.out.println(cont + ") " + s.mostrarInformacion());
                                cont++;
                            }
                            System.out.println("0) Volver al menu solicitudes");
                            System.out.println("Seleccione la opcion que desea Rechazar");
                            int opcionRechazada = opcionesVendedor.nextInt();
                            if (opcionRechazada == 0) {
                                System.out.println("Volviendo...");
                                break;
                            }
                            Solicitud solicitudRechazada = vendedorLogeado.getSolicitudes().get(opcionRechazada - 1);
                            Vehiculo vehiculoRechazado = solicitudRechazada.getVehiculo();

                            System.out.println("Ingrese motivo de rechazo a la solicitud: ");
                            Scanner motivoEntrada = new Scanner(System.in);
                            String motivo = motivoEntrada.nextLine();

                            vendedorLogeado.rechazarCotizacion((Cliente) solicitudRechazada.getUsuario(), motivo, solicitudRechazada, vehiculoRechazado);
                            System.out.println("Solicitud contestada, eliminando solicitud del sistema...");
                            vendedorLogeado.eliminarSolicitud(solicitudRechazada);

                            break;
                        case 3:
                            System.out.println("Volviendo al menu...");
                            break;

                    }
                    break;
                case 3:
                    logout = true;

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
        ArrayList<Vehiculo> vCliente = new ArrayList<>();
        vCliente.add(new Automovil(5, false, true, "Honda", "Civic", 2020, TipoMotor.DIESEL, 18500, EstadoVehiculo.DISPONIBLE, 2.5, CONCESIONARIA));
        listaUsuarios.add(new Cliente("0943156043", "Jefe de Sistemas", 4000, "Moises Fernando", "Alvarez Orellana", "malvarez", "123", vCliente));
        listaUsuarios.add(new Cliente("0943675982", "Jefa de Ventas", 1800, "Karla Andrea", "Rivera Vera", "krivera", "123"));
        listaUsuarios.add(new Cliente("0981679527", "Supervisor de Sistemas", 2500, "Winston Humberto", "Leon Gutierrez", "wleon", "123"));
        ArrayList<String> certificacionesAcademicas = new ArrayList<>();
        certificacionesAcademicas.add("Certificación en Gestión Estratégica de Ventas ");
        certificacionesAcademicas.add("Certificacion en Marketing Digital");
        listaUsuarios.add(new Supervisor(certificacionesAcademicas, "Melanie Danna", "Alarcon Veliz", "malarcon", "123"));
        ArrayList<String> certificacionesTecnicas = new ArrayList<>();
        certificacionesTecnicas.add("Certificacion en Jefe de Taller Mecanico");
        certificacionesTecnicas.add("Certificacion en Mecanica Automotriz");
        listaUsuarios.add(new JefeDeTaller(certificacionesTecnicas, "Alvaro Gregorio", "Arboleda Benitez", "garboleda", "123"));
        return listaUsuarios;
    }

    public static ArrayList<Vehiculo> cargarVehiculos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Automovil(4, false, true, "Chevrolet", "Aveo", 2021, TipoMotor.DIESEL, 21000, EstadoVehiculo.DISPONIBLE, 0, CONCESIONARIA));
        vehiculos.add(new Automovil(5, false, true, "Nissan", "xZ", 2020, TipoMotor.DIESEL, 18500, EstadoVehiculo.DISPONIBLE, 2.5, CONCESIONARIA));
        vehiculos.add(new Tractor(false, TipoTransmision.HIDRAULICA, "Caterpillar", "Oruga", 2019, 10900.00, EstadoVehiculo.DISPONIBLE, 0.00, CONCESIONARIA));
        vehiculos.add(new Motocicleta(MotoCategoria.DEPORTIVA, "Honda", "CRM-250", 2022, TipoMotor.GASOLINA, 4000.00, EstadoVehiculo.DISPONIBLE, 500.00, CONCESIONARIA));
        vehiculos.add(new Motocicleta(MotoCategoria.TODOTERRENO, "Yamaha", "DT-200", 2020, TipoMotor.GASOLINA, 2500.00, EstadoVehiculo.DISPONIBLE, 100.00, CONCESIONARIA));
        vehiculos.add(new Camion(12000.00, "Chevrolet", "Frigorifico", 2017, TipoMotor.GASOLINA, 6, 25000.00, EstadoVehiculo.DISPONIBLE, 0.00, CONCESIONARIA));
        vehiculos.add(new Motocicleta(MotoCategoria.SCOOTER, "Kawasaki", "CRF450X", 2018, TipoMotor.GASOLINA, 4500.00, EstadoVehiculo.DISPONIBLE, 0.00, CONCESIONARIA));
        vehiculos.add(new Camion(20000.00, "Hyundai", "Plataforma", 2020, TipoMotor.GASOLINA, 8, 30000.00, EstadoVehiculo.DISPONIBLE, 0.00, CONCESIONARIA));
        vehiculos.add(new Tractor(true, TipoTransmision.MECANICA, "Fendt", "Neumaticos", 2021, 15000.00, EstadoVehiculo.DISPONIBLE, 0.00, "Case IH"));
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

    public static Supervisor getSupervisor() {
        ArrayList<Supervisor> supervisor = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Supervisor) {
                supervisor.add((Supervisor) usuario);
            }
        }
        return supervisor.get(0);
    }

    public static JefeDeTaller getJefeDeTaller() {
        ArrayList<JefeDeTaller> jefeDeTaller = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof JefeDeTaller) {
                jefeDeTaller.add((JefeDeTaller) usuario);
            }
        }
        return jefeDeTaller.get(0);
    }

}
