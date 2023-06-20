package com.cybersoft.cozastoreJava21.controller;

import com.cybersoft.cozastoreJava21.Exception.Filenotfoundexception;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/demo")
public class DemoUploadFileController {
    //Path: chứa toàn bộ hàm hỗ trợ sẵn liên quan tới đường dẫn
    @Value("${path.root}")
    private String spath;
    @GetMapping("/{filename}")
    public ResponseEntity<?> loadFile(@PathVariable String filename){
        try {
            // đường dẫn folder root luu hinh

            Path rootpath=Paths.get(spath);
            Resource resource=new UrlResource(rootpath.resolve(filename).toUri()) ;
            if (resource.exists()) {
                //nếu tồn tại thì mới cho phép download
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
//            return new ResponseEntity<>(resource,HttpStatus.OK);
            }else {
                // khi ném exception thì code sẽ dừng và văng ra lỗi
                throw new Filenotfoundexception(200,"file not found");

            }
        }catch (Exception e) {
            throw new Filenotfoundexception(200,"file not found");

        }


    }
@PostMapping("/uploadfile")
    public ResponseEntity<?> uploadfile(
        @RequestParam MultipartFile file
        ){
    //định nghĩa đường dẫn
    Path rootPath= Paths.get(spath);
    System.out.println(spath);
try {
    if(!Files.exists(rootPath)){
//tạo folder ứng với lại đường dẫn nếu k tồn tại
        Files.createDirectories(rootPath);}
        // C:\Users\Administrator\Desktop\ImgJava21
        // resolve tương đường với dấu "/"
        // file.getOriginalFilename(): lấy tên file và định dạng
        String filename=file.getOriginalFilename();
        Files.copy(file.getInputStream(),rootPath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("upload thanh cong");
}catch (Exception e) {
    System.out.println("loi"+e.getLocalizedMessage());
}

    return new ResponseEntity<>("", HttpStatus.OK);
}
}
