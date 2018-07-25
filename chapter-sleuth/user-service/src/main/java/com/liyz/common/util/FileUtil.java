package com.liyz.common.util;

import com.alibaba.fastjson.JSONObject;
import com.liyz.fallInLove.dto.common.AttachmentDTO;
import com.yixin.common.utils.InvokeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lianghaoguan on 2018/5/21.
 * 文件工具类
 */
@Component
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    /**
     * 文件服务器路径
     */
    @Value("${fileServiceURL}")
    private String fileServiceURL;

    /**
     * 上传文件到文件服务器
     *
     * @param file
     * @param waterFlag 是否添加水印
     * @param zoomMap 是否压缩以及压缩规定的宽度，Integer zoonFlag：是否压缩 1：是，其他所有都是否；Integer newWidth：压缩以后的宽度
     * @return 返回存储的文件id
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月21日 下午8:09:57
     */
    public String uploadWebFile(MultipartFile file, boolean waterFlag, Map<String, Integer> zoomMap) throws IOException {
        if(file.isEmpty()){
            logger.error("上传文件失败，文件内容为空");
            return null;
        }
        String url = fileServiceURL+"/fileserver/api/fileUpload/uploadFile";
        byte[] fileSource = file.getBytes();
        String sourceFileName = file.getOriginalFilename();
        String fileType = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1, sourceFileName.length());
        if(zoomMap != null){
            Integer zoonFlag = (Integer)zoomMap.get("zoonFlag");
            Integer newWidth = (Integer)zoomMap.get("newWidth");
            if(zoonFlag !=null && zoonFlag==1 && newWidth != null ){
                
                fileSource = zoomImageScale(fileSource, fileType, newWidth);
            }
        }
        
        //添加水印
        if(waterFlag){
            fileSource = WaterMarkUtils.addWaterMark(fileSource, fileType, CommConstant.WATER_MARK_CONTENT);
        }
        
        AttachmentDTO attachmentDTOReq = new AttachmentDTO();
        attachmentDTOReq.setSourceFileName(sourceFileName);
        attachmentDTOReq.setFileSource(fileSource);
        String response = RestUtil.sendRequest(url,attachmentDTOReq);

        InvokeResult<?> iResult = JSONObject.parseObject(response, InvokeResult.class);
        if (iResult == null || iResult.getData() == null || !iResult.isSuccess()) {
            logger.error("上传文件到文件服务器失败");
            return null;
        }

        JSONObject jSONObject = JSONObject.parseObject((iResult.getData().toString()));
        return jSONObject.get("fileId").toString();
    }

    /**
     * 返回文件的存储绝对路径
     *
     * @param fileId
     * @return 返回存储的绝对路径
     * @author YixinCapital -- lianghaoguan
     *	       2018年5月21日 下午8:09:57
     */
    public String getFileUrl(String fileId){
        return fileServiceURL+"/fileserver/file/getFile?fileId="+ fileId ;
    }

    /**
     * 按指定宽度 等比例缩放图片
     *
     * @param imageFile
     * @param newPath
     * @param newWidth 新图的宽度
     * @throws IOException
     */
    private static byte[] zoomImageScale(byte[] fileSource,String fileType, int newWidth) throws IOException {
        ByteArrayInputStream in = null;
        in = new ByteArrayInputStream(fileSource);
        byte[] targetSource = null;
        try{
            BufferedImage bufferedImage = ImageIO.read(in);// 文件转化为图片
            if (null == bufferedImage)
                return null;
            
            int originalWidth = bufferedImage.getWidth();
            int originalHeight = bufferedImage.getHeight();
            double scale = (double)originalWidth / (double)newWidth;    // 缩放的比例
            
            int newHeight =  (int)(originalHeight / scale);

            targetSource = zoomImageUtils(fileType, bufferedImage, newWidth, newHeight);
            in.close();
        } catch (Exception e){
            logger.error("图片压缩出现异常");
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // 不处理
                    logger.error("图片压缩后关闭流异常");
                    e.printStackTrace();
                }
            }
        }
        
        return targetSource;
    }
    private static byte[] zoomImageUtils(String suffix, BufferedImage bufferedImage, int width, int height)
            throws IOException{
        byte[] targetResource = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
         // 处理 png 背景变黑的问题
            if(suffix != null && (suffix.trim().toLowerCase().endsWith("png") || suffix.trim().toLowerCase().endsWith("gif"))){
                BufferedImage to= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = to.createGraphics();
                to = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
                g2d.dispose();
                
                g2d = to.createGraphics();
                Image from = bufferedImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
                g2d.drawImage(from, 0, 0, null);
                g2d.dispose();
                
                ImageIO.write(to, suffix, bos);
                targetResource = bos.toByteArray();
                
            }else{
                BufferedImage newImage = new BufferedImage(width, height, bufferedImage.getType());
                Graphics g = newImage.getGraphics();
                g.drawImage(bufferedImage, 0, 0, width, height, null);
                g.dispose();
                
                ImageIO.write(newImage, suffix, bos);
                targetResource = bos.toByteArray();
            }
        }catch (Exception e){
        
        }finally{
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    // 不处理
                    logger.error("图片压缩后关闭流异常");
                    e.printStackTrace();
                }
            }
        }
        
        return targetResource;
    }
}
