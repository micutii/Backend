package com.Map.data.jpa.service.Photo;

import com.Map.data.jpa.domain.Photo;

import java.util.List;

/**
 * Created by easyw on 25-Mar-18.
 */
public interface PhotoService {

    List<Photo> getAllFromPin(int idPin);

    boolean savePhoto(Photo photo);

    Photo getPhoto(int idPhoto);

    void removePin(int idPhoto);
}
