package com.intake21.customapp.serviceImpls;

import com.intake21.customapp.dto.requests.LaptopDTO;
import com.intake21.customapp.exceptions.NotFoundException;
import com.intake21.customapp.models.Laptop;
import com.intake21.customapp.models.Student;
import com.intake21.customapp.repositories.LaptopRepository;
import com.intake21.customapp.repositories.StudentRepository;
import com.intake21.customapp.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final StudentRepository studentRepository;
    @Override
    public List<Laptop> getAllLaptops() {
        try {
            return laptopRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Laptop getLaptopById(UUID id) {
        try {
            return laptopRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Laptop createLaptop(LaptopDTO laptop) {
        try {
            Student student =  studentRepository.findById(laptop.getStudentId()).orElseThrow(
                    () -> new NotFoundException("The student with the given id was not found")
            );
            Laptop laptopEntity = new Laptop();
            laptopEntity.setBrand(laptop.getBrand());
            laptopEntity.setSerialNumber(laptop.getSerialNumber());
            laptopEntity.setStudent(student);
            return laptopRepository.save(laptopEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
