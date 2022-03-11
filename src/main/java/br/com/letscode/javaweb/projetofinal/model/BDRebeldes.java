package br.com.letscode.javaweb.projetofinal.model;

import br.com.letscode.javaweb.projetofinal.dto.RequestOferta;

import java.util.*;

public class BDRebeldes {
    private static List<Rebelde> rebeldeList = new ArrayList<>();

    public void adiciona(Rebelde rebelde){
        BDRebeldes.rebeldeList.add(rebelde);
    }

    public List<Rebelde> buscaRebeldes() {
        return BDRebeldes.rebeldeList;
    }

    public Rebelde detalhesRebelde(UUID id) throws Exception {
        Optional<Rebelde> resultRebelde = BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id)).findAny();
        if (resultRebelde.isPresent()) {
            return resultRebelde.get();
        } else {
            throw new Exception("Rebelde não encontrado");
        }
    }

    public Rebelde atualizaLocalizacao(UUID id, Localizacao localizacao) throws Exception {
        BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id))
                .forEach(rebelde -> rebelde.setLocalizacao(localizacao));
        return detalhesRebelde(id);
    }

    public void reportaTraidor(UUID id) {
        BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), id))
                .forEach(rebelde -> {
                    if (!rebelde.getTraidor()) {
                        rebelde.setContadorReportes(rebelde.getContadorReportes() + 1);
                        if (rebelde.getContadorReportes() == 3) {
                            rebelde.setTraidor(true);
                        }
                    }
                });
    }

    public void negocia(RequestOferta ofertas) throws Exception {

        if (!isTraidor(ofertas.getOferta1().getIdRebelde()) &&
            !isTraidor(ofertas.getOferta2().getIdRebelde()) &&
            confereQuantidadeItens(ofertas.getOferta1()) &&
            confereQuantidadeItens(ofertas.getOferta2()) &&
            verificaPontosOfertas(ofertas)) {
            BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), ofertas.getOferta1().getIdRebelde()))
                    .forEach(rebelde -> {
                        retiraItensInventarioRebelde(rebelde, ofertas.getOferta1().getItens());
                        colocaItensInventarioRebelde(rebelde, ofertas.getOferta2().getItens());
                    }
            );
            BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), ofertas.getOferta2().getIdRebelde()))
                    .forEach(rebelde -> {
                                retiraItensInventarioRebelde(rebelde, ofertas.getOferta2().getItens());
                                colocaItensInventarioRebelde(rebelde, ofertas.getOferta1().getItens());
                    }
            );
        }

        else {
            throw new Exception("Negocio não realizado");
        }
    }

    public Boolean confereQuantidadeItens(Oferta oferta) {
        List<Boolean> resultAllItens = new ArrayList<>();
        BDRebeldes.rebeldeList.stream().filter(rebelde -> Objects.equals(rebelde.getId(), oferta.getIdRebelde()))
                .forEach(rebelde -> {
                    for ( Item itemOferta : oferta.getItens()) {
                        for ( Item itemRebelde : rebelde.getInventario() ) {
                            if (itemOferta.getTipoItem() == itemRebelde.getTipoItem()) {
                                if (itemOferta.getQuantidade() <= itemRebelde.getQuantidade()){
                                    resultAllItens.add(true);
                                }
                                else {
                                    resultAllItens.add(false);
                                }
                            }
                        }
                    }
                });

        return !resultAllItens.contains(false);
    }

    public Boolean isTraidor(UUID id) throws Exception {
        Rebelde rebelde = detalhesRebelde(id);
        return rebelde.getTraidor();
    }

    public Boolean verificaPontosOfertas(RequestOferta ofertas) {
        int pontos1 = 0, pontos2 = 0;
        for (Item item1: ofertas.getOferta1().getItens()) {
            pontos1 += (item1.getPontos() * item1.getQuantidade());
        }
        for (Item item2: ofertas.getOferta2().getItens()) {
            pontos2 += (item2.getPontos() * item2.getQuantidade());
        }
        return pontos1 == pontos2;
    }

    public void retiraItensInventarioRebelde(Rebelde rebelde, List<Item> itemList) {
        for ( Item itemARetirar : itemList) {
            for ( Item itemRebelde : rebelde.getInventario() ) {
                if (itemARetirar.getTipoItem() == itemRebelde.getTipoItem()) {
                    itemRebelde.setQuantidade(itemRebelde.getQuantidade() - itemARetirar.getQuantidade());
                }
            }
        }
    }

    public void colocaItensInventarioRebelde(Rebelde rebelde, List<Item> itemList) {
        for ( Item itemARetirar : itemList) {
            for ( Item itemRebelde : rebelde.getInventario() ) {
                if (itemARetirar.getTipoItem() == itemRebelde.getTipoItem()) {
                    itemRebelde.setQuantidade(itemRebelde.getQuantidade() + itemARetirar.getQuantidade());
                }
            }
        }
    }

}
