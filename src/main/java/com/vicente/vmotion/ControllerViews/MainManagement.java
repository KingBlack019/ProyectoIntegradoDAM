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
    private Socket userSocket;
    private BufferedReader entrada;
    private PrintWriter salida;


    public MainManagement(Socket userSocket) {
        this.userSocket = userSocket;
    }

    public Socket getUserSocket() {
        return userSocket;
    }

    public void setUserSocket(Socket userSocket) {
        this.userSocket = userSocket;
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

    public static boolean connectServer() {
        try (Socket socket = new Socket(direccionServidor, puerto);


             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Conectado al servidor");

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public void setEntrada(BufferedReader entrada) {
        this.entrada = entrada;
    }

    public PrintWriter getSalida() {
        return salida;
    }

    public void setSalida(PrintWriter salida) {
        this.salida = salida;
    }

    public void enviarDatos(Object o){
        salida.println(o);
    }
}
