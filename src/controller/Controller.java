package controller;

import model.Binnacle;

import java.util.Scanner;

public class Controller {

    private Binnacle modelo = new Binnacle();
    private Scanner sc = new Scanner(System.in);

    public void launch() {
        boolean active = true;
        while(active) {
            try {
                System.out.println("Hay "+modelo.getPerson().getAllData().size()+" registros");
                System.out.print("Ingresa una opción: ");
                var opcion = sc.nextLine();
                switch (opcion) {
                    case "0" -> active = false;
                    case "1" -> crear();
                    case "2" -> buscar();
                    case "3" -> eliminar();
                    default -> System.out.println("Ingresa una opción válida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void crear() {
        System.out.print("Ingresa los nombres: ");
        var nombres = sc.nextLine();
        System.out.print("Ingresa los apellidos: ");
        var apellidos = sc.nextLine();
        System.out.print("Ingresa el email: ");
        var email = sc.next();
        try {
            modelo.create(modelo.getPerson().getAllData().size()+1, nombres, apellidos, email);
        } catch (Exception e) {
            System.out.println("No se puede crear la persona");
        }
        sc.nextLine();
    }

    public void buscar() {
        System.out.print("Ingresa el o los apellidos: ");
        var apellidos = sc.nextLine();
        var resultados = modelo.getPerson().searchbyLastname(apellidos);
        System.out.println("ID \t| Nombre Completo \t| email");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i).getId()+" \t| "+resultados.get(i).getNames()+" " +
                    ""+resultados.get(i).getLastname()+" \t| " + resultados.get(i).getEmail()+" ");
        }
    }

    public void eliminar() {
        System.out.print("Ingresa el ID: ");
        var id = sc.nextInt();
        try {
            modelo.delete(id);
        } catch (Exception e) {
            System.out.println("No se puede eliminar");
        }
        sc.nextLine();
    }
}

class Launcher {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.launch();
    }
}
