package com.example.cuadratica.service;

import com.example.cuadratica.controller.CuadraticaDTO;

public interface CuadraticaService {
    CuadraticaDTO entregarResultado();
    //throws IOException; NO aplica en este caso porque vamos a controlar los errores o excepciones de división por cero por ejemplo

    
}
