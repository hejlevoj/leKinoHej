package cz.cvut.fit.tjv.lekinohej.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<E, E_DTO,E_DTOREQ,K> {

    protected CrudRepository<E, K> repository;
    protected  Class<E> E_type;
    protected Class<E_DTO> EDTO_type;

    protected Class<E_DTOREQ> EDTOREQ_type;

    @Autowired
    protected ModelMapper modelMapper;

    protected AbstractCrudService(CrudRepository<E, K> repository, Class<E> type, Class<E_DTO> typeDto, Class<E_DTOREQ> typeReqDto) {
        this.repository = repository;
        this.E_type = type;
        this.EDTO_type = typeDto;
        this.EDTOREQ_type = typeReqDto;
    }

    public E_DTO create(E_DTOREQ e_DTOREQ) {
        return modelMapper.map(repository.save(modelMapper.map(e_DTOREQ,E_type)),EDTO_type);
    }

    public E_DTO findById(K id) {
        return modelMapper.map(repository.findById(id).orElseThrow(EntityNotFoundException::new),EDTO_type);
    }

    public E findByIdReturnEntity(K id){
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<E_DTO> findAll() {
        List<E_DTO> return_list = new ArrayList<>();
        for(E entity : repository.findAll()) {
            return_list.add(modelMapper.map(entity,EDTO_type));
        }
        return return_list;
    }

    @Transactional
    public E_DTO update(E_DTOREQ dto, K id) {
        E entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(dto,entity);
        repository.save(entity);
        return modelMapper.map(entity,EDTO_type);
    }

    @Transactional
    public E_DTO delete(K id) {
        Optional<E> tmp = repository.findById(id);
        if (tmp.isEmpty()) {
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
        return modelMapper.map(tmp,EDTO_type);
    }
}
