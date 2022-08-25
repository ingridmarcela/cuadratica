package com.example.cuadratica.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cuadratica.controller.CuadraticaDTO;
import com.example.cuadratica.service.CuadraticaService;

@Service //ojooo sin esto no encuentra el service del proyecto
public class CudraticaServiceImpl implements CuadraticaService{

    @Override
    public CuadraticaDTO entregarResultado() {
        // TODO Auto-generated method stub
        LocalDateTime locaDate = LocalDateTime.now();
        int hours  = locaDate.getHour(); //para el ejemplo del DTO este campo sería = 15
        int minutes = locaDate.getMinute();//segun ejemplo=28
        int seconds = locaDate.getSecond();//segundos=59
        
         //ejemplo de hora 15:28:59, con % sacamos el valor restante de dividir
        int a = hours % 10; //15 % 10 = 5
        int b = minutes % 10; //28 % 10 = 8
        int c = seconds % 10; //59 % 10 = 9
        
        System.out.println("Hora actual : " + hours  + ":"+ minutes +":"+seconds); 
        String hora = String.valueOf(hours) + ":"+ minutes +":"+seconds;

        List<Integer> valoresUsados = new ArrayList<>(); //vamos a almacenar en la lista los valores obtenidos
        //así se debe ver la lista al ppio [] y aca le agregamos lo que tenemos a ,b y c

        valoresUsados.add(a); //llenamos la lista con los valores
        valoresUsados.add(b);
        valoresUsados.add(c);

        Integer operacionRaiz = b*b - 4*a*c; //para obtener la raiz cuadrada de b=8
        double resultadoNumerador = (b *(-1)) + Math.sqrt(operacionRaiz);
        Integer resultadoDenominador = (2*a);
        
        double resultado = resultadoNumerador / resultadoDenominador;
        
        if (operacionRaiz < 0) {
            //String operacionRaiz = String.valueOf(operacionRaiz);
            //String resultadoDenominador = String.valueOf(resultadoDenominador);
            if (resultadoDenominador == 0){
                return new CuadraticaDTO(
                hora,
                valoresUsados,
                "No es posible obtener raiz cuadrada porque es negativo",
                "La operació no es posible con raiz negativa",
                "La operación no es posible con división por 0", 
                "La operación no es posible con raiz negativa y división por cero");
            }
            return new CuadraticaDTO(
                hora,
                valoresUsados,
                "No es posible obtener raiz cuadrada porque es negativo",
                "La operació no es posible con raiz negativa",
                String.valueOf(resultadoDenominador), 
                "La operación no es posible con raiz negativa");
        }
        else {
            if (resultadoDenominador == 0){
                return new CuadraticaDTO(
                hora,
                valoresUsados,
                String.valueOf(operacionRaiz),
                String.valueOf(resultadoNumerador),
                "La operación no es posible con división por 0", 
                "La operación no es posible con división por cero");
            }
           return new CuadraticaDTO(
                hora,
                valoresUsados,
                String.valueOf(operacionRaiz),
                String.valueOf(resultadoNumerador),
                String.valueOf(resultadoDenominador), 
                String.valueOf(resultado)); //*/"1","1","1","1");
        }
        //return null;
    }
    
}
