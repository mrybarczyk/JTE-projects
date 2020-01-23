package ug.edu.pl.react;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FlowerRepository extends ReactiveMongoRepository<Flower, Integer> {
    @Query("{ 'name': ?0 }")
    Flux<Flower> findByName(final String name);
}