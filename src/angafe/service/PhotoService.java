package angafe.service;

import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;

import angafe.meta.PhotoMeta;
import angafe.model.Photo;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;


public class PhotoService {

    private PhotoMeta ph = new PhotoMeta();

    public Photo uploadPhoto(FileItem file) {
        if (file == null) {
            return null;
        }

        Photo photo = new Photo();
        photo.setKey(Datastore.allocateId(ph));
        photo.setFileName(file.getShortFileName());
        photo.setLength(file.getData().length);
        byte[] bytes = file.getData();
        photo.setBytes(bytes);

        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx, photo);
        tx.commit();
        return photo;
    }

    public Photo getPhoto(Key key) {
        return Datastore.get(ph, key);
    }

}
