package br.com.aaefl.pfm.midias.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum TipoUsuario {

    ALUNO(1, "Aluno"),
    PROFESSOR(2, "Professor"),
    ADMIN(3,"Admin");

    private int cod;
    private String descricao;

    public static TipoUsuario toEnum(Integer cod){
        if(cod==null)
            return null;

        for (TipoUsuario tipoCliente: TipoUsuario.values()) {
            if(cod.equals(tipoCliente.getCod())){
                return tipoCliente;
            }
            
        }

        throw new IllegalArgumentException("Id Inválido:" + cod);
    }

}
