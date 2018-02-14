package com.home.apostasjl.enuns;

/**
 * Created by Tuca on 10/01/2018.
 */

public enum EnuResultado {

    PERDEU(0), GANHOU(1), EMPATOU(2), SEM_RESULTADO(3);

    private Integer codigo;

    private EnuResultado(Integer codigo) {

        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
