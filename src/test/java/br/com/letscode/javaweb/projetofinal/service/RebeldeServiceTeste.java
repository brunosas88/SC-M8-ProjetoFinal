package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RebeldeServiceTeste {

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
    @DisplayName("Cadastrar Rebelde")
    public void cadastraRebeldeTeste() {
        Rebelde rebelde = rebeldeService.cadastraRebelde( new RequestRebelde(
           "cliente", 35, 'M',
                new Localizacao(100.00,200.00, "Andromeda"),
                List.of(new Item(TipoItem.ARMA, 5), new Item(TipoItem.MUNICAO, 20))
        ));
        assertEquals("cliente", rebelde.getNome());
        verify(bdRebeldes, times(1)).adiciona(ArgumentMatchers.any(Rebelde.class));
    }

}
