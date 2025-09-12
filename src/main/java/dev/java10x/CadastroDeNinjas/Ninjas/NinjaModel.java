package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

// Entity transforma uma classe em uma Entidade do Banco de Dados.
@Entity
// Criar uma tabela e definir o seu nome.
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    // Id é usado pra gerar um id pra cada elemento da tabela. Ele sempre deve ser colocado acima do Long Id.
    @Id
    // É usado para gerar um valor automático para Id. O ENUM strategy Identity cria Id de forma sequencial.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_do_ninja") // Usado para definir o nome da nossa coluna no Banco de Dados
    private Long id;

    @Column(name = "nome_do_ninja")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    // Múltiplas funcionalidades para uma variável.
    @ManyToOne
    // Juntar colunas
    @JoinColumn(name = "missoes_id") // Foreing Key ou Chave Estrangeira;
    private MissoesModel missoes;

}
