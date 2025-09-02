package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVinda() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninjas
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os Ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar Ninjas";
    }

    // Mostrar Ninjas por Id
    @GetMapping("/ninjaid")
    public String mostrarNinjasPorId() {
        return "Mostrar Ninja por Id";
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterar")
    public String alterarDdadosNinja() {
        return "Alterar dados do Ninja";
    }

    // Deletar Ninjas por ID
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Ninja deletado";
    }

}
