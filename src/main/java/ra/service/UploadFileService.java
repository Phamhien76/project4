package ra.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    //upload file từ client lên 1 thư mục của server và trả về đường dẫn thư mục
    String uploadFile(MultipartFile multipartFile);
    //Upload file từ server lên firebase và trả về đường dẫn URL của ảnh trên firebase
    String uploadFileLocalToFirebase(String localFilePath);
}
