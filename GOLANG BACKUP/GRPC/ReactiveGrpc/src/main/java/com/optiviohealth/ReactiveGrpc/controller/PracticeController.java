package com.optiviohealth.ReactiveGrpc.controller;

import com.optiviohealth.ReactiveGrpc.model.Practice;
import com.optiviohealth.ReactiveGrpc.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/practices")
public class PracticeController {
    private final PracticeService practiceService;

    @Autowired
    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @PostMapping
    public Mono<Practice> createPractice(@RequestBody Practice practice) {
        return practiceService.createPractice(practice);
    }

    @GetMapping("/{id}")
    public Mono<Practice> getPractice(@PathVariable Long id) {
        return practiceService.getPracticeById(id);
    }

    @GetMapping
    public Flux<Practice> getAllPractices() {
        return practiceService.getAllPractices();
    }

//    @PutMapping("/{id}")
//    public Mono<Practice> updatePractice(@PathVariable Long id, @RequestBody Practice practiceDTO) {
//        return practiceService.updatePractice(id, practiceDTO);
//    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePractice(@PathVariable Long id) {
        return practiceService.deletePractice(id);
    }
}
