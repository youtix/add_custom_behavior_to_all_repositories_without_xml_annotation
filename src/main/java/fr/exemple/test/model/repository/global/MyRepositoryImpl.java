package fr.exemple.test.model.repository.global;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class MyRepositoryImpl<T, ID extends Serializable> extends
		SimpleMongoRepository<T, ID> implements MyRepository<T, ID> {

	private Log log = LogFactory.getLog(MyRepositoryImpl.class);
	private MongoOperations mongoOperations;

	public MyRepositoryImpl(MongoEntityInformation<T, ID> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.mongoOperations = mongoOperations;
	}

	@Override
	public void sharedCustomMethod(ID id) {
		log.info(id);
	}
}
