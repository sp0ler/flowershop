package ru.deevdenis.flowershop.servises.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deevdenis.flowershop.DAO.FlowerImagesDAO;
import ru.deevdenis.flowershop.models.Flower;
import ru.deevdenis.flowershop.models.FlowerImages;
import ru.deevdenis.flowershop.servises.FlowerImagesService;

import javax.transaction.Transactional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class FlowerImagesServiceImpl implements FlowerImagesService {
    @Autowired
    private FlowerImagesDAO flowerImagesDAO;

    @Override
    @Transactional
    public void save(FlowerImages flowerImages) {
        flowerImagesDAO.save(flowerImages);
    }

    @Override
    @Transactional
    public void delete(int id) {
        flowerImagesDAO.delete(id);
    }
}
