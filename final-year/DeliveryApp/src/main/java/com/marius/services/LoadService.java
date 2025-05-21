package com.marius.services;

import com.marius.model.Load;
import com.marius.repositories.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class LoadService {

    private final LoadRepository loadRepository;

    public Load getLoadById(int loadId) {
        return loadRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    public void removeLoadById(int loadId) {
        loadRepository.deleteById(loadId);
    }

}
