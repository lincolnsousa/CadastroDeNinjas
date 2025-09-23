package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Retorna uma mensagem de boas vindas ao usuário.")
    public String boasVinda() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo Ninja", description = "Cria um novo ninja gerando para um mesmo um Id mais atributos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja.")
    })
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
    @Operation(summary = "Altera a informação de um Ninja", description = "Altera as informações dos Ninjas no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<?> alterarDdadosNinja(@Parameter(description = "Usuário manda o id no caminho da requisição.")
                                                    @PathVariable Long id,
                                                @Parameter(description = "Usuário manda a informações que deseja ser alterada no Ninja.")
                                                @RequestBody NinjaDTO ninjaDTO) {
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
