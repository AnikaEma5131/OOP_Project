/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema;

import java.io.Serializable;

/*
 * @author EMA
 */
public class Content implements Serializable{
    private String Title;
    private byte[] VideoData;

    public Content(String Title, byte[] VideoData) {
        this.Title = Title;
        this.VideoData = VideoData;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public byte[] getVideoData() {
        return VideoData;
    }

    public void setVideoData(byte[] VideoData) {
        this.VideoData = VideoData;
    }
    
    
    
}
