package com.walmartapi.mapper;

public interface CustomObjectManager <E, D> {

    E mapToEntity(D dto);
    D mapToDto(E entity);

}
