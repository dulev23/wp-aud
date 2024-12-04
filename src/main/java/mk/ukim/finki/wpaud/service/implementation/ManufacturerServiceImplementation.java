package mk.ukim.finki.wpaud.service.implementation;

import mk.ukim.finki.wpaud.model.Manufacturer;
import mk.ukim.finki.wpaud.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wpaud.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImplementation(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(String name, String address) {
        return Optional.of(manufacturerRepository.save(new Manufacturer(name, address)));
    }

    @Override
    public void deleteById(long id) {
        this.manufacturerRepository.deleteById(id);
    }
}