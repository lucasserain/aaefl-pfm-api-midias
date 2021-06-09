package br.com.aaefl.pfm.midias.core.service;

import br.com.aaefl.pfm.midias.adapter.datastore.entity.UsuariosEntity;
import br.com.aaefl.pfm.midias.adapter.datastore.mapper.UsuariosMapper;
import br.com.aaefl.pfm.midias.adapter.datastore.repository.UsuariosPageRepository;
import br.com.aaefl.pfm.midias.core.model.Disciplina;
import br.com.aaefl.pfm.midias.core.model.Usuarios;
import br.com.aaefl.pfm.midias.core.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuariosPageRepository usuariosPageRepository;

    public List<Usuarios> findUsuarios(int size, int page, Optional<String> nome, int tipo) {
        Pageable paginacao = PageRequest.of(page,size);

        if(nome.isEmpty()) {
            return UsuariosMapper.INSTANCE.usuarioEntityPageToUsuarios(usuariosPageRepository.findAllAlunos(paginacao,tipo));
        }else{
            return UsuariosMapper.INSTANCE.usuarioEntityPageToUsuarios(usuariosPageRepository.findAlunosName(nome.get(),paginacao,tipo));
        }



    }

    public Usuarios findUsuarioById(String idUsuario, int size, int page) {
        Pageable paginacao = PageRequest.of(page,size);
        Optional<UsuariosEntity> user = usuariosPageRepository.findById(idUsuario);
        if(user.isEmpty()){
            throw new ObjectNotFoundException("Não há disciplinas para esse usuário! Id: " + idUsuario + ", Tipo: " + Disciplina.class.getName());
        }
        return UsuariosMapper.INSTANCE.entityToUsuario(user.get());
    }
}
