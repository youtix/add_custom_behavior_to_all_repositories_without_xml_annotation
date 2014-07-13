package fr.exemple.test.model.repository.global;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MappingMongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;

public class MyRepositoryFactoryBean<R extends MongoRepository<T, I>, T, I extends Serializable>
		extends MongoRepositoryFactoryBean<R, T, I> {

	@Override
	protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
		return new MyRepositoryFactory<T, I>(operations);
	}

	private static class MyRepositoryFactory<T, I extends Serializable> extends
			MongoRepositoryFactory {

		private MongoOperations mongoOperations;

		public MyRepositoryFactory(MongoOperations mongoOperations) {
			super(mongoOperations);
			this.mongoOperations = mongoOperations;
		}

		protected Object getTargetRepository(RepositoryMetadata metadata) {
			TypeInformation<T> information =  ClassTypeInformation.from((Class<T>)metadata.getDomainType());
            MongoPersistentEntity<T> pe = new BasicMongoPersistentEntity<T>(information);
            MongoEntityInformation<T,I> mongometa = new MappingMongoEntityInformation<T, I>(pe);
			return new MyRepositoryImpl<T, I>(mongometa, mongoOperations);
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return MyRepository.class;
		}
	}
}
