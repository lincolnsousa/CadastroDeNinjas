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
@Getter
@Setter
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

    // Construtores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
