package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Images;
import ra.repository.ImagesRepository;
import ra.service.ImagesService;

import java.util.List;

@Service
public class ImagesServiceImp implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Override
    public boolean save(Images images) {
        return false;
    }

    @Override
    public List<Images> findAllByProductImageId(String id) {

        return imagesRepository.findAllByProductImageId(id);
    }
}
