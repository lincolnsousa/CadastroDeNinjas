package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;
    }


}
