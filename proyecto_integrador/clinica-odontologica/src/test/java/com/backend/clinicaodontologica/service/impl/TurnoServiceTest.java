package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Test
    @Order(1)
    void deberiaDevolverUnaListaVaciaDeTurnos(){

        List<TurnoSalidaDto> turnosDto = turnoService.listarTurnos();

        assertTrue(turnosDto.isEmpty());

    }



}