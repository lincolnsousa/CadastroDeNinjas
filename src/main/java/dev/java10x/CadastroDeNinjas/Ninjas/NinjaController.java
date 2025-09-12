package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
       NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body("Ninja com o ID: " + ninjaDTO.getId() + " criado com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas() {
        List<NinjaDTO> lista = ninjaService.listarNinja();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        NinjaDTO ninjaListado = ninjaService.listarPorId(id);
        if (ninjaListado != null) {
            return ResponseEntity.ok(ninjaListado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado.");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarDdadosNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.alterarPorId(id, ninjaDTO);
        if (ninja != null) {
            ninjaService.alterarPorId(id, ninjaDTO);
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja com o ID: " + id + " não foi encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaID(@PathVariable Long id) {
        ninjaService.listarPorId(id);
        if (listarPorId(id) != null) {
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não foi encontrado.");
        }

    }

}
