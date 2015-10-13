package net.timeclip.www.common.repository;

import java.util.List;

public interface BaseMapper<T, ID> {
    void deleteAll();
    void delete(ID id);
    ID save(T t);
    Long update(T t);
    List<T> findAll();
    T findOne(ID id);
}
