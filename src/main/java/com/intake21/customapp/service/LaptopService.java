package com.intake21.customapp.service;

import com.intake21.customapp.dto.requests.LaptopDTO;
import com.intake21.customapp.models.Laptop;

import java.util.List;
import java.util.UUID;

public interface LaptopService {
    List<Laptop> getAllLaptops();
    Laptop getLaptopById(UUID id);
    Laptop createLaptop(LaptopDTO laptop);
}

