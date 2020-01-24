package ug.edu.pl.react;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Flower f) {
        flowerService.create(f);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Flower>> findById(@PathVariable("id") Integer id) {
        Mono<Flower> f = flowerService.findById(id);
        HttpStatus status = f != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Flower>>(f, status);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Flux<Flower> findByName(@PathVariable("name") String name) {
        return flowerService.findByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Flower> findAll() {
        Flux<Flower> fs = flowerService.findAll();
        return fs;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Flower> update(@RequestBody Flower f) {
        return flowerService.update(f);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        flowerService.delete(id).subscribe();
    }

}