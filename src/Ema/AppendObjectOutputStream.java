/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ema;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


class AppendObjectOutputStream extends ObjectOutputStream{
    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    @Override
    public void writeStreamHeader() throws IOException {
        
    }
}
