package ra.modelMap;

public interface MapperGeneric <E,U,V> {
    //E: entity
    //U: request
    //V: response
    E mapperRequestToEntity(U u);
    V mapperEntityToResponse(E e);

}
