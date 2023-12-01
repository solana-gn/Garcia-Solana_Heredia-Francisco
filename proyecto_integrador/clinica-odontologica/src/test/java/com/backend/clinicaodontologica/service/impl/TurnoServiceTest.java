package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaDevolverUnaListaVaciaDeTurnos(){

        List<TurnoSalidaDto> turnosDto = turnoService.listarTurnos();

        assertTrue(turnosDto.isEmpty());

    }

    @Test
    @Order(2)
    public void registrarTurno() throws MethodArgumentNotValidException, BadRequestException {
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan", "Perez", 123456789, LocalDate.of(2023, 12, 24), new DomicilioEntradaDto("calle", 1234, "Localidad", "Provincia"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("Francisco", "Heredia", "123456");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.guardarOdontologo(odontologoEntradaDto);
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(LocalDateTime.of(2023, 12, 16, 16, 25, 25), 1L, 1L);
        TurnoSalidaDto turnoGuardado = turnoService.registrarTurno(turnoEntradaDto);

        assertNotNull(turnoGuardado);
    }

}