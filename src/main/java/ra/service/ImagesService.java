package ra.service;

import ra.model.Images;

import java.util.List;

public interface ImagesService {
    boolean save (Images images);
    List<Images> findAllByProductImageId(String id);
}
