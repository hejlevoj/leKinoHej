package cz.cvut.fit.tjv.lekinohej.api.controller;

import cz.cvut.fit.tjv.lekinohej.DTO.OwnerDTO;
import cz.cvut.fit.tjv.lekinohej.DTO.request.OwnerRequestDTO;
import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import cz.cvut.fit.tjv.lekinohej.service.OwnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController extends AbstractRestController<Owner,OwnerDTO, OwnerRequestDTO,Long>{
    public OwnerController(OwnerService service) {
        super(service);
    }
}
