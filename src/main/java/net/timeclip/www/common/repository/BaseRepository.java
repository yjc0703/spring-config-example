package net.timeclip.www.common.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository<T, ID, R extends BaseMapper<T, ID>> {

    @Autowired
    private R repository;
    
    protected ID saveAndGetId(T t) {
        return repository.save(t);
    }
    
    protected Long update(T t) {
        return repository.update(t);
    }
    
    public T findOne(ID id) {
        return repository.findOne(id);
    }
    
    public List<T> findAll() {
        return repository.findAll();
    }
    
    public void delete(ID id) {
        repository.delete(id);
    }
    
    public void deleteAll() {
        repository.deleteAll();
    }
    
    public abstract T save(T t);


    
    
    
}
