package com.vicente.vmotion.ControllerViews;

import com.vicente.vmotion.Main;
import com.vicente.vmotion.Management.ControllerViewInterface;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class MainManagement {
    static String direccionServidor = "localhost";
    static int puerto = 1234;
    private static Socket userSocket;
    private static BufferedReader entrada;
    private static PrintWriter salida;

    // Constructor privado para evitar instancias innecesarias
    public MainManagement() {}

    public static boolean connectServer() {
        try {
            userSocket = new Socket(direccionServidor, puerto);
            entrada = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
            salida = new PrintWriter(userSocket.getOutputStream(), true);

            System.out.println("Conectado al servidor");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static BufferedReader getEntrada() {
        return entrada;
    }

    public static void setEntrada(BufferedReader entrada) {
        MainManagement.entrada = entrada;
    }

    public static PrintWriter getSalida() {
        return salida;
    }

    public static void setSalida(PrintWriter salida) {
        MainManagement.salida = salida;
    }

    public static void enviarDatos(Object o) {
        if (salida != null) {
            System.out.println("o = " + o.toString());
            salida.println(o); // Convertir el objeto a String antes de enviarlo
        } else {
            System.out.println("No hay conexión establecida. No se pueden enviar datos.");
        }
    }

    public static Object recibirDatos() throws IOException {
        return entrada.readLine();
    }

    public static void showView(Main main, String viewName) {
        try {
            System.out.println(main.getClass().getResource("Views/" + viewName + ".fxml"));
            FXMLLoader loader = new FXMLLoader(main.getClass().getResource("Views/" + viewName + ".fxml"));
            Parent view = loader.load();

            // Obtener el controlador y pasarle la referencia a la clase Main
            Object controller = loader.getController();
            ((ControllerViewInterface) controller).setMainApp(main);

            // Cambiar la vista al nuevo nodo
            main.root.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}