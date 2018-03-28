/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;

/**
 *
 * @author Huong Thu Tran
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            String[] chuoi = {"..\\image", "..\\image\\output1.png"};
            SpriteMap.join(chuoi[0], chuoi[1]);
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
}
