package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.entity.Odontologo;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologo() {

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto();
        odontologoEntradaDto.setMatricula("325");
        odontologoEntradaDto.setNombre("Adolfo");
        odontologoEntradaDto.setApellido("Guemes");

        OdontologoSalidaDto odontologoGuardado = odontologoService.guardarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoGuardado);
        assertEquals(1L, odontologoGuardado.getId());
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

    /*

    @Test
    @Order(3)
    public void actualizarOdontologo() {
        OdontologoModificacionEntradaDto odontologoModificacionDto = new OdontologoModificacionEntradaDto();
        odontologoModificacionDto.setId(2L);
        odontologoModificacionDto.setNombre("Maria");
        odontologoModificacionDto.setApellido("Perez");

        OdontologoSalidaDto odontologoActualizado = odontologoService.actualizarOdontologo(odontologoModificacionDto);

        assertNotNull(odontologoActualizado);
        assertEquals("Maria", odontologoActualizado.getNombre());

    }

     */





}

