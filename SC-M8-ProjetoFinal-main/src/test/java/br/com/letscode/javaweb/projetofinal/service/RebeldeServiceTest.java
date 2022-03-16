package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class RebeldeServiceTest {

    @Mock
    BDRebeldes bdRebeldes;

    @InjectMocks
    RebeldeService rebeldeService;

    @Captor
    private ArgumentCaptor<Rebelde> rebeldeArgumentCaptor;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveRetornarListaRebeldeVazia(){
        when(bdRebeldes.buscaRebeldes()).thenReturn(new ArrayList<>());
        List<Rebelde> clientes = rebeldeService.buscaTodosRebeldes();
        Assertions.assertTrue(clientes.isEmpty());
        verify(bdRebeldes, times(1)).buscaRebeldes();
        verifyNoMoreInteractions(bdRebeldes);
    }

    @Test
    public void deveRetornarListaRebeldePreenchida() {

        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = new Rebelde(requestRebelde);

        when(bdRebeldes.buscaRebeldes()).thenReturn(Arrays.asList(rebelde));

        List<Rebelde> rebeldes = rebeldeService.buscaTodosRebeldes();

        assertEquals(Arrays.asList(rebelde), rebeldes);
        verify(bdRebeldes, times(1)).buscaRebeldes();
    }

    @Test
    public void cadastraRebelde(){
        RequestRebelde requestRebelde = new RequestRebelde(
                "Jeferson", 34, 'M',
                new Localizacao(100.0, 200.0, "Via Lactea"),
                new Inventario(1, 100, 10,10));

        Rebelde rebelde = rebeldeService.cadastraRebelde(requestRebelde);

        assertEquals(requestRebelde.getNome(), rebelde.getNome());
        assertNotNull(rebelde.getId());
    }


}
