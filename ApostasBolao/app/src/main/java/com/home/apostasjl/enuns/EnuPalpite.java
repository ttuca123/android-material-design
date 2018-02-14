package com.home.apostasjl.enuns;

/**
 * Created by Artur on 10/01/2018.
 */

public enum EnuPalpite {

    CASA(0, "TIME DA CASA"), EMPATE(1, "EMPATE"), FORA(2, "TIME DE FORA");

    private Integer codigo;

    private String descricao;

    private EnuPalpite(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static String getDescricao(int codigo) {

        for (EnuPalpite enuPalpite : EnuPalpite.values()) {
            if (codigo == enuPalpite.getCodigo()) {
                return enuPalpite.getDescricao();
            }

        }
        return "Ops, nenhum item encontrado!!!";
    }

    public static Integer getCodigo(String descricao) {

        for (EnuPalpite EnuPalpite : EnuPalpite.values()) {
            if (EnuPalpite.getDescricao().equals(descricao.trim())) {
                return EnuPalpite.getCodigo();
            }
        }
        return 0;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
