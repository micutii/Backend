package com.Map.data.jpa.service.Type;

import com.Map.data.jpa.domain.Type;
import com.Map.data.jpa.domain.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
@Component
public class TypeServiceImpl implements  TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type getType(int id){
        return typeRepository.findOne(id);
    }

    @Override
    public List<Type> getTypes(){
        return typeRepository.findAll();
    }

    public boolean saveType(Type type){
        if(typeRepository.save(type) != null){
            return true;
        }
        return false;
    }

    public void removeType(int idType){
        typeRepository.delete(idType);
    }
}
