package com.gy.shop.shopapi.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaoyun
 * 2018/4/19 21:07
 * 描述:将图片转为base64
 */
public class FileEncode64 {

    public static String getEncode(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extUpp = (fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase());
        //根据扩展名判断是否为要求的图片
        String encode = null;
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage bi = null;
        try {
            assert inputStream != null;
            bi = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            encode = encoder.encode(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        encode = "data:img/jpg;base64," + encode;
        return encode;
    }
}
