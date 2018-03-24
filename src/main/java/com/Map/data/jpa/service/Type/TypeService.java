package com.Map.data.jpa.service.Type;

import com.Map.data.jpa.domain.Type;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
public interface TypeService {

    Type getType(int id);

    List<Type> getTypes();

    boolean saveType(Type type);

    void removeType(int idType);
}
