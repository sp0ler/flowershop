package ru.deevdenis.flowershop.servises;

import ru.deevdenis.flowershop.models.Flower;
import ru.deevdenis.flowershop.models.FlowerImages;

public interface FlowerImagesService {
    void save(FlowerImages flowerImages);

    void delete(int id);
}
