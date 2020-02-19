package stanislaw.appdemo.admin;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    private MultipartFile filename;


    public MultipartFile getFilename(){
        return filename;
    }

    private void setFilename(MultipartFile filename){
        this.filename = filename;
    }
}
