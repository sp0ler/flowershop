package ru.deevdenis.flowershop.servises.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deevdenis.flowershop.DAO.FlowerDAO;
import ru.deevdenis.flowershop.models.Flower;
import ru.deevdenis.flowershop.servises.FlowerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerDAO flowerDAO;

    @Override
    @Transactional
    public List<Flower> getAllFlowers() {
        return flowerDAO.findAll();
    }

    @Override
    @Transactional
    public void saveFlower(Flower flower) {
        flowerDAO.save(flower);
    }

    @Override
    @Transactional
    public Flower getFlower(int id) {
        return flowerDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        flowerDAO.delete(id);
    }

    @Override
    public void deleteById(int id) {
        flowerDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<Flower> getFlowersByCategory(String categoryName) {
        return flowerDAO.getFlowersByCategory(categoryName);
    }

    @Override
    @Transactional
    public List<Flower> findAllByTitleContainsIgnoreCase(String title) {
        return flowerDAO.findAllByTitleContainsIgnoreCase(title);
    }


}

