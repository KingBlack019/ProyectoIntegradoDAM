package com.vicente.vmotion.Management;

import com.vicente.vmotion.Main;

public interface ControllerViewInterface {
    void setMainApp(Main app);
    void enviarDatos(Object o);
    Object recibirDatos();
}
