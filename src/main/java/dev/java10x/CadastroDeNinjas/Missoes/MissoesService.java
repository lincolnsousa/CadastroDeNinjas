package dev.java10x.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;

public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Metodo Criar
    public MissoesModel criarMissoes(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    // Metodo Listar
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    // Listar por ID
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesId = missoesRepository.findById(id);
        return missoesId.orElse(null);
    }

    // Metodo Deletar
    public void deletarMissoesId(Long id) {
        missoesRepository.deleteById(id);
    }
}
