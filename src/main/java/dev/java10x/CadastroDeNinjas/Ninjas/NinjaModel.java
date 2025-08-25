package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

// Entity transforma uma classe em uma Entidade do Banco de Dados.
@Entity
// Criar uma tabela e definir o seu nome.
@Table(name = "tb_cadastro")
public class NinjaModel {

    // Id é usado pra criar um id pra cada elemento da tabela. Ele sempre deve ser colocado acima do Long Id.
    @Id
    // É usado para gerar um valor automático para Id. O ENUM strategy Identity cria Id de forma sequencial.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;
    // Múltiplas funcionalidades para uma variável.
    @ManyToOne
    // Juntar colunas
    @JoinColumn(name = "missoes_id") // Foreing Key ou Chave Estrangeira;
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
