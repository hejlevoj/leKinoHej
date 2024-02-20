package cz.cvut.fit.tjv.lekinohej.dao;

import cz.cvut.fit.tjv.lekinohej.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
