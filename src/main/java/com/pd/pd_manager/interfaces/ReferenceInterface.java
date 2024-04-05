package com.pd.pd_manager.interfaces;

import java.util.List;

/*
    Типовой интерфейс для справочников.
*/
public interface ReferenceInterface<Object> {
    public List<Object> getAll();

    public Object getById(Long id);

    public void add(Object object);

    public void delete(Long id);

    public void update(Long id, Object object);

}
