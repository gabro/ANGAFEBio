package angafe.controller.angafe;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import angafe.model.Photo;
import angafe.service.PhotoService;

import com.google.appengine.api.datastore.Key;

public class ImageController extends Controller {
    
    PhotoService service = new PhotoService();
    
    @Override
    public Navigation run() throws Exception {
        long imgId = Long.parseLong((String)request.getParameter("imgId"));
        Key imgKey = Datastore.createKey(Photo.class, imgId);
        Photo photo = service.getPhoto(imgKey);
        
        if (photo != null) {
            // Set the appropriate Content-Type header and write the raw bytes
            // to the response's output stream
            response.setContentType("image/jpeg");
            response.getOutputStream().write(photo.getBytes());
        } else {
            // If no image is found with the given title, redirect the user to
            // a static image
            response.sendRedirect("/resources/noimage.jpg");
        }
        return null;
    }
}
