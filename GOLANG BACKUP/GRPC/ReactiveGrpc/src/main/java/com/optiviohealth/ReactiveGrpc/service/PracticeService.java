package com.optiviohealth.ReactiveGrpc.service;

import com.optiviohealth.ReactiveGrpc.entity.PracticeEntity;
import com.optiviohealth.ReactiveGrpc.mapper.PracticeMapper;
import com.optiviohealth.ReactiveGrpc.model.Practice;
import com.optiviohealth.ReactiveGrpc.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PracticeService {
    private final PracticeRepository practiceRepository;
    private final PracticeMapper practiceMapper;
@Autowired
    public PracticeService(PracticeRepository practiceRepository, PracticeMapper practiceMapper) {
        this.practiceRepository = practiceRepository;
        this.practiceMapper = practiceMapper;
    }

    public Mono<Practice> createPractice(Practice practice) {
        PracticeEntity practiceEntity = practiceMapper.mapToEntity(practice);
        return practiceRepository.save(practiceEntity)
                .map(practiceMapper::mapToModel);
    }

    public Mono<Practice> getPracticeById(Long id) {
        return practiceRepository.findById(id)
                .map(practiceMapper::mapToModel);
    }

    public Flux<Practice> getAllPractices() {
        return practiceRepository.findAll()
                .map(practiceMapper::mapToModel);
    }

//    public Mono<Practice> updatePractice(Long id, Practice practice) {
//        return practiceRepository.findById(id)
//                .flatMap(existingPractice -> {
//                    PracticeEntity updatedPractice = practiceMapper.mapToEntity(practice);
//                    existingPractice.setPracticeName(updatedPractice.getPracticeName());
//                    existingPractice.setAddress(updatedPractice.getAddress());
//                    existingPractice.setPhoneNumber(updatedPractice.getPhoneNumber());
//                    existingPractice.setEmail(updatedPractice.getEmail());
//                    return practiceRepository.save(existingPractice);
//                })
//                .map(practiceMapper::mapToModel);
//    }

    public Mono<Void> deletePractice(Long id) {
        return practiceRepository.deleteById(id);
    }
}
