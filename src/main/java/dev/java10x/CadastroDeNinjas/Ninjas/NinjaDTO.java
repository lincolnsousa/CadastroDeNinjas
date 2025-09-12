package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
