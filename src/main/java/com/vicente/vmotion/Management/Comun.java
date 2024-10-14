package com.vicente.vmotion.Management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comun {

    // TODO quiza es mejor ponerlo todo en String y transformarlo a Date para mejorar la gestion
    public LocalDate getFechaActual(){
        return LocalDate.now();
    }

    public LocalDateTime getFechaActualPrecisa(){
        return LocalDateTime.now();
    }

    public static ObservableList<String> roleChoiceBox(){
        String[] opcionesArray = {"CONSUMIDOR", "OFERTANTE"};
        return FXCollections.observableArrayList(opcionesArray);
    }

    public static void ButtonLoginStyle(Button button){
        // TODO METER EL MOUSTE ENTERED Y EXITED CON SUS DISEÑOS
    }

    public static boolean mismoTexto(String txt1, String txt2){
        return txt1.compareTo(txt2) == 0;
    }
}
