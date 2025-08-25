package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private char dificuldade;

    // Uma funcionalidade para varias variáveis.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;



}
