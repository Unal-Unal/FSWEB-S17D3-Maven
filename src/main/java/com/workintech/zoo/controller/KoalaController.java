package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Integer, Koala> koalas = new HashMap<>();

    @GetMapping
    public List<Koala> getAll() {
        return new ArrayList<>(koalas.values());
    }


    @GetMapping("/{id}")
    public Koala getById(@PathVariable int id) { return koalas.get(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Koala save(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala updated) {
        koalas.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        koalas.remove(id);
        return "Deleted Koala with id: " + id;
    }
}
