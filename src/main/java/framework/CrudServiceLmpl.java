package framework;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;



public abstract class CrudServiceLmpl<T,ID> implements CrudServiceImpl<T,ID> {
    public abstract JpaRepository<T,ID> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public T save(T t) {
        preSave(t);
        t = getRepository().save(t);
        postSave(t);
        return t;
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void preSave(T t) {

    }

    @Override
    public void postSave(T t) {

    }
}
