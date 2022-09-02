package ru.deevdenis.flowershop.servises;

import ru.deevdenis.flowershop.models.Category;
import ru.deevdenis.flowershop.models.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> getAllFlowers();

    void saveFlower(Flower flower);

    Flower getFlower(int id);

    void delete(int id);

    void deleteById(int id);

    List<Flower> getFlowersByCategory(String categoryName);
}

