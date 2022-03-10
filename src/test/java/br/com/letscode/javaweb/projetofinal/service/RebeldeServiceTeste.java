package br.com.letscode.javaweb.projetofinal.service;

import br.com.letscode.javaweb.projetofinal.dto.RequestRebelde;
import br.com.letscode.javaweb.projetofinal.model.BDRebeldes;
import br.com.letscode.javaweb.projetofinal.model.Inventario;
import br.com.letscode.javaweb.projetofinal.model.Localizacao;
import br.com.letscode.javaweb.projetofinal.model.Rebelde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

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
                new Inventario()
        ));
        assertEquals("cliente", rebeldeArgumentCaptor.getValue().getNome());
        verify(bdRebeldes, times(1)).adiciona(ArgumentMatchers.any(Rebelde.class));

    }

}
