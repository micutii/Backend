package com.Map.data.jpa.service.Photo;

import com.Map.data.jpa.domain.Photo;
import com.Map.data.jpa.domain.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
@Component
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public List<Photo> getAllFromPin(int idPin) {
        return photoRepository.getByIdPin(idPin);
    }

    @Override
    public boolean savePhoto(Photo photo) {
        if(photoRepository.save(photo) != null ){
            return true;
        }
        return false;
    }

    @Override
    public Photo getPhoto(int idPhoto) {
        return photoRepository.findById(idPhoto).get();
    }

    @Override
    public void removePin(int idPhoto) {
        photoRepository.deleteById(idPhoto);
    }
}
