package ug.edu.pl.react;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFlowerService
{
    void create(Flower e);

    Mono<Flower> findById(Integer id);

    Flux<Flower> findByName(String name);

    Flux<Flower> findAll();

    Mono<Flower> update(Flower e);

    Mono<Void> delete(Integer id);
}