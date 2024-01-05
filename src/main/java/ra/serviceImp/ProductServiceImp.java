package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Images;
import ra.model.Product;
import ra.repository.ImagesRepository;
import ra.repository.ProductRepository;
import ra.service.ProductService;
import ra.service.UploadFileService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private ImagesRepository imagesRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String proId) {
        return productRepository.findById(proId).get();
    }

    @Override
    public List<Product> findProByNameOrPrice(String findName) {
        return productRepository.findByNameContainsAndAndPrice(findName);
    }

    @Override
    public List<Product> sort() {
        return null;
    }

    @Override
    public boolean save(Product product, MultipartFile avatar, MultipartFile[] otherImages) {
        //1.upload avartar và otherImages lên firebase và lấy lại đường link
        //Upload ảnh avatar
        String avartar_link = uploadFileService.uploadFile(avatar);
        //2.set link vào product
        product.setAvatarImage(avartar_link);
        //3.thêm mới sản phẩm
        Product proNew = productRepository.save(product);
        //Thêm mới các ảnh phụ vào Images
        for (MultipartFile file : otherImages) {
            String link = uploadFileService.uploadFile(file);
            Images images = new Images();
            images.setImageLink(link);
            images.setProduct(proNew);
            imagesRepository.save(images);
        }
        return proNew != null ? true : false;

    }

    @Override
    public boolean update(Product product) {
        Product proUpdate = productRepository.findById(product.getId()).get();
        proUpdate.setName(product.getName());
        proUpdate.setPrice(product.getPrice());
        proUpdate.setTitle(product.getTitle());
        proUpdate.setDescription(product.getDescription());
        proUpdate.setAvatarImage(product.getAvatarImage());
        proUpdate.setUnit(product.getUnit());
        proUpdate.setStatus(product.isStatus());
        Product pro = productRepository.save(proUpdate);
        return pro != null ? true : false;
    }

    @Override
    public boolean delete(String proId) {
        boolean result = false;
        try {
            productRepository.deleteById(proId);
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
