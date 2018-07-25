package com.liyz.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @ClassName: WaterMarkUtils
 * @Description 加水印
 * @author  YixinCapital -- yangfei02
 * @date  2018年5月24日 上午9:59:37
 *
 */
public class WaterMarkUtils {

    private final static Logger logger = LoggerFactory.getLogger(WaterMarkUtils.class);
    
    /**
     *
     * @Description: 加水印
     * @param srcImgPath
     * @param tarImgPath
     * @param waterMarkContent
     * @param markContentColor
     * @param font void
     * @throws
     * @author YixinCapital -- yangfei02
     *	       2018年5月24日 上午9:59:20
     */
    public static byte[] addWaterMark(byte[] fileSource,String fileType, String waterMarkContent) {
        ByteArrayInputStream in = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            in = new ByteArrayInputStream(fileSource);
            Image srcImg = ImageIO.read(in);// 文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);// 获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);// 获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(new Color(255, 255, 255, 128)); // 根据图片的背景设置水印颜色
            g.setFont(new Font("微软雅黑", Font.PLAIN, 35)); // 设置字体

            int contentLength = g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
            
            // 设置水印的坐标
            int x = srcImgWidth - 2 * contentLength<0?0:srcImgWidth - 2 * contentLength;
            int y = srcImgHeight - 5;
            g.drawString(waterMarkContent, x, y); // 画出水印
            g.dispose();
            
            ImageIO.write(bufImg, fileType, bos);
            byte[] targetResource = bos.toByteArray();
            bos.close();
            in.close();
            return targetResource;
        } catch (Exception e) {
            // 不处理
            logger.error("添加水印出错",e);
        } finally{
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    // 不处理
                    logger.error("图片添加水印后关闭流异常",e);
                }
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    // 不处理
                    logger.error("图片添加水印后关闭流异常", e);
                }
            }
        }
        return fileSource;
    }
}
