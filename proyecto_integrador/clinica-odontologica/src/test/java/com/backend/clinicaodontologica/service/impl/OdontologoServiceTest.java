package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologo() {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("Juan", "Perez", "123456");


        OdontologoSalidaDto odontologoGuardado = odontologoService.guardarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoGuardado);
    }

    @Test
    @Order(2)
    void alIntentarEliminarUnOdontologoConId1YaEliminado_deberiaLanzarUnaResourceNotFoundException() {

        try {
            odontologoService.eliminarOdontologo(1L);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }

    @Test
    @Order(3)
    public void eliminarOdontologo() throws ResourceNotFoundException {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("Francisco", "Heredia", "123456");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.guardarOdontologo(odontologoEntradaDto);

        odontologoService.eliminarOdontologo(1L);

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));

    }


}