package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    public KangarooController() {
        kangaroos = new HashMap<>();
    }

    @GetMapping
    public List<Kangaroo> getAll() {
        return new ArrayList<>(kangaroos.values());
    }


    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable int id) {
        Kangaroo k = kangaroos.get(id);
        if (k == null) {
            throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        }
        return k;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kangaroo save(@RequestBody Kangaroo kangaroo) {
        if (kangaroo.getId() <= 0 || kangaroo.getName() == null) {
            throw new ZooException("Invalid Kangaroo data", HttpStatus.BAD_REQUEST);
        }
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id, @RequestBody Kangaroo updated) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        }
        kangaroos.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable int id) {
        Kangaroo removed = kangaroos.remove(id);
        if (removed == null) {
            throw new ZooException("Kangaroo not found", HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Deleted Kangaroo");
        response.put("id", removed.getId());
        return response;
    }
}
