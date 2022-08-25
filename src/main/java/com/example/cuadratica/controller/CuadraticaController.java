package com.example.cuadratica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuadratica.service.CuadraticaService;

@RestController
@RequestMapping("/cuadratica")
public class CuadraticaController {
    private final CuadraticaService objCuadraticaService;

    public CuadraticaController( @Autowired CuadraticaService x )
    //inyecta las dependencias
    {
        this.objCuadraticaService = x;
    }

    @GetMapping
    public ResponseEntity<CuadraticaDTO> serieCalculada(){
        return ResponseEntity.ok(objCuadraticaService.entregarResultado());
    }
}
