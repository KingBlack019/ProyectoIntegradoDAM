package com.vicente.vmotion.Management;

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
}
