package com.beon.controller;

import com.beon.data.pojo.ErrorMessage;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by leo on 14-4-7.
 *
 * @author Leo
 */
@Controller
public class PictureController {

    public static final String FILEPATH = "src/webapp/upload";

    @RequestMapping(value = "/picture/upload", method = RequestMethod.POST)
    @ResponseBody
    public ErrorMessage handleFileUpload(
            @RequestParam("file") MultipartFile file) {// ,@RequestParam(value = "type", required = false) String type){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File newfile = new File(FILEPATH + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(newfile));

                stream.write(bytes);
                stream.close();
                ErrorMessage errorMessage = new ErrorMessage(0, "upload success");
                return errorMessage;

            } catch (Exception e) {
                return new ErrorMessage(1, "upload failed");
            }
        } else {
            return new ErrorMessage(1, "upload failed");
        }
    }

    @RequestMapping(value = "/picture/get/{file_name}/", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("file_name") String fileName,
            HttpServletResponse response) {
        try {
            // get your file as InputStream
            System.out.println(fileName);
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(FILEPATH + File.separator + fileName)));
            // copy it to response's OutputStream
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            System.out.println("Error writing file to output stream. Filename was '" + fileName + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
