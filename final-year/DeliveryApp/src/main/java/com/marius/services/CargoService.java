package com.marius.services;

import com.marius.model.Cargo;
import com.marius.model.Load;
import com.marius.repositories.CargoRepository;
import com.marius.repositories.CargoRepository;
import com.marius.utils.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    private final LoadService loadService;

    public Cargo getCargoById(int loadId) {
        return cargoRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Cargo not found"));
    }

    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    public Cargo addCargo(ItemRequest request) {
        Load load = loadService.getLoadById(request.getLoadId());
        return cargoRepository.save(Cargo.builder()
                        .details(request.getDetails())
                        .load(load)
                .build());
    }

    public void removeCargoById(int loadId) {
        cargoRepository.deleteById(loadId);
    }

}
