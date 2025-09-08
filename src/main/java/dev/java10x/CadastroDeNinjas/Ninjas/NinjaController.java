package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjar();
    }

    // Mostrar Ninjas por Id
    @GetMapping("/listarid")
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
