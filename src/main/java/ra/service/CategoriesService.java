package ra.service;

import ra.model.Categories;

import java.util.List;


public interface CategoriesService {
    List<Categories> findAll( );
    Categories findById(int catalogId);
    List<Categories> findCateByName(String catalogName, int page, int size);
    //sort co phan trang nhe
    /*
    * sortDir: ASC - tang dan, DESC - giam dan
    * sortBy: sap xep theo tieu chi nao (name, id....)
    * page: trang hien thi (trang 0, 1,2, 3...)
    * size: so du lieu hien thi tren 1 trang
    * */
    List<Categories> findAllSort(String sortDir, String sortBy, int page, int size);
    boolean save(Categories categories);
    boolean update (Categories categories);
    boolean delete(int catalogId);
    long countCate();


}
