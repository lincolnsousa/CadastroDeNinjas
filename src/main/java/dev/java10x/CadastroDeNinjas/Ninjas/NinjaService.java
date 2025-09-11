package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Metodo Listar
    public List<NinjaModel> listarNinja() {
        return ninjaRepository.findAll();
    }
    // Metodo Listar por Id
    public NinjaModel listarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
    // Metodo Criar
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
            NinjaModel ninja = ninjaMapper.map(ninjaDTO);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
    }
    // Metodo Deletar
    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Metodo Alterar
    public NinjaModel alterarPorId(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
