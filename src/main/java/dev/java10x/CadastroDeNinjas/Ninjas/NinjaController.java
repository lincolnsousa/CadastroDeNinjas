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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os Ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas() {
        return ninjaService.listarNinja();
    }

    // Mostrar Ninjas por Id
    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarDdadosNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.alterarPorId(id, ninjaDTO);
    }

    // Deletar Ninjas por ID
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaID(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }

}
