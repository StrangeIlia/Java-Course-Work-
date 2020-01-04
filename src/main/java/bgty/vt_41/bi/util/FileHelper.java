package bgty.vt_41.bi.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper {
    public static String saveFile(MultipartFile file, String basePath)
    {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String path = basePath + "/" + dateFormat.format(date);
        String newFileName = Integer.toString((date.toString() + file.getName()).hashCode()) + "." + extension;
        File savedFile = new File(path + "/" + newFileName );
        try {
            file.transferTo(savedFile);
        } catch (IOException e) {
            return "";
        }
        return newFileName;
    }
}
