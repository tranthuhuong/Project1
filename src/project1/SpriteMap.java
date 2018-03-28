/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Huong Thu Tran
 */
public class SpriteMap  {
 
    public static void join(String inputPath, String outputPath) throws IOException {
        //mở file
        inputPath = inputPath.replace("\\", "/");

        File directory = new File(inputPath);
        // lấy tất cả các file trong thư mục vào mảng 1 chiều
        File[] files = directory.listFiles();
        int amountImage=files.length;
        int count=0;
        File[][] files2=new File[5][5];
        for(int i=0;i<amountImage/2;i++){
            for(int j=0;j<amountImage/2;j++){
                files2[i][j]=files[count];
                count++;
            }
        }
        //lấy thông tin của 1 hình nhỏ chiều rộng chiều cao
        BufferedImage sprite = ImageIO.read(files2[0][0]);
        
        int width = sprite.getWidth() * (files2.length)/2;
        int height = sprite.getHeight()*(files2.length)/2;
 
        BufferedImage spriteMap = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = spriteMap.createGraphics();
        
        
        for(int i=0;i<amountImage/2;i++){
            int x = 0;
            int y = sprite.getHeight()*i;
            for(int j=0;j<amountImage/2;j++){
                sprite = ImageIO.read(files2[i][j]);
                g2d.drawImage(sprite, null, x, y);
                x+=sprite.getWidth();
            }
        }
        //ghi spriteMap
        ImageIO.write(spriteMap, "png", new File(outputPath));    
    }
}