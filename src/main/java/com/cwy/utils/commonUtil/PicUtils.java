package com.cwy.utils.commonUtil;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.commons.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import net.coobird.thumbnailator.Thumbnails;

/**
 * @author siawase
 * @date 2020-06-04 01:53
 * 图片压缩Utils
 */
public class PicUtils {




        private static Logger logger = LoggerFactory.getLogger(PicUtils.class);
        private static long desFileSize=1024;

        public static void main(String[] args) throws IOException {
            String filePath="D:\\upload/14mm.PNG";
            PicUtils.compressPic(filePath);// 图片小于300kb
        }


        public static void compressPic(String filePath) {
            logger.info("开始压缩图片，filePath"+filePath);
            File f=new File(filePath);
            FileInputStream fin = null;
            ByteArrayInputStream inputStream = null;
            ByteArrayOutputStream outputStream=null;
            try {
                if(f.exists()){
                    fin = new FileInputStream(f);
                    byte[] imageBytes  = new byte[fin.available()];
                    fin.read(imageBytes);
                    if (imageBytes == null || imageBytes.length <= 0 || imageBytes.length < desFileSize * 1024) {
                        return ;
                    }
                    logger.info("图片大小："+imageBytes.length);
                    /*                long length = (long)imageBytes.length;*/
                    for(int i=0;i<3&&imageBytes.length > desFileSize * 1024;i++){
                        float accuracy = desFileSize  / (float)(imageBytes.length/1024);
                        inputStream = new ByteArrayInputStream(imageBytes);
                        outputStream = new ByteArrayOutputStream(imageBytes.length);
                        //Thumbnails.of(inputStream)
                                //.scale(1f)
                                //.outputQuality(accuracy)
                                //.toOutputStream(outputStream);
                        imageBytes = outputStream.toByteArray();
                    }

                    logger.info("图片原大小:+"+imageBytes.length/1024+"kb | 压缩后大小="+imageBytes.length/1024+"kb");
                    f.delete();
                    //FileUtils.writeByteArrayToFile(new File(filePath), imageBytes);
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("【图片压缩】msg=图片压缩失败!", e);
            }finally{
                try {
                    if(fin!=null){
                        fin.close();
                    }
                    if(inputStream!=null){
                        inputStream.close();
                    }
                    if(outputStream!=null){
                        outputStream.close();
                    }
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            }
        }
}
