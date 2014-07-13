package fr.exemple.test.model.repository;

import fr.exemple.test.model.domain.Test;
import fr.exemple.test.model.repository.global.MyRepository;

public interface TestRepository extends MyRepository<Test, String> {
	
}
