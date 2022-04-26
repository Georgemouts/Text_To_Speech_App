/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javattsapplication;

import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Ammar Mansab
 */
public class Model 
{
    //List read;
    List<XWPFParagraph> read;

    public void setRead(List read) {
        this.read = read;
    }

    public List getRead() {
        return read;
    }

    public Model() {
    }
}
