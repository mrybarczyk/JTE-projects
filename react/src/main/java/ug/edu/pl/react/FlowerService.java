package ug.edu.pl.react;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlowerService implements IFlowerService {

    @Autowired
    FlowerRepository fr;

    public void create(Flower e) {
        fr.save(e).subscribe();
    }

    public Mono<Flower> findById(Integer id) {
        return fr.findById(id);
    }

    public Flux<Flower> findByName(String name) {
        return fr.findByName(name);
    }

    public Flux<Flower> findAll() {
        return fr.findAll();
    }

    public Mono<Flower> update(Flower e) {
        return fr.save(e);
    }

    public Mono<Void> delete(Integer id) {
        return fr.deleteById(id);
    }

}