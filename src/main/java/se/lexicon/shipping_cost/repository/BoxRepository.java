package se.lexicon.shipping_cost.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.shipping_cost.entity.Box;

public interface BoxRepository extends CrudRepository<Box,String> {
}
