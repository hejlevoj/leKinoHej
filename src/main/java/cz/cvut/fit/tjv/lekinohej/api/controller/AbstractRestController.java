package cz.cvut.fit.tjv.lekinohej.api.controller;

import cz.cvut.fit.tjv.lekinohej.service.AbstractCrudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractRestController <T,T_DTO,T_REQDTO,ID>{
    protected AbstractCrudService<T, T_DTO, T_REQDTO, ID> service;

    public AbstractRestController( AbstractCrudService<T, T_DTO, T_REQDTO, ID> service ) { this.service = service; }

    @PostMapping
    public ResponseEntity<T_DTO> create (@Valid @RequestBody T_REQDTO entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public T_DTO find (@PathVariable ID id) { return service.findById(id);}

    @GetMapping
    public List<T_DTO> findAll() {return service.findAll();}

    @PutMapping("/{id}")
    public T_DTO update(@RequestBody T_REQDTO entity, @PathVariable ID id) {
        return service.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public T_DTO delete(@PathVariable ID id) { return service.delete(id);}
}
