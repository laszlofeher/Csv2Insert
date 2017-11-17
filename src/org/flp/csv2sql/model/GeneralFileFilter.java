/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.csv2sql.model;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author feherlaszlo
 */
public class GeneralFileFilter extends FileFilter{

    private String[] extensions ;
    
    public GeneralFileFilter(String... extension) {
        extensions = extension;
    }
    
    
    
    @Override
    public boolean accept(File file) {
        if(file != null){
            for (int i = 0; i < extensions.length; i++) {
                if(file.getName().lastIndexOf(extensions[i]) > 0 || file.isDirectory()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        String extensionDescriptor = "";
        for (int i = 0; i < extensions.length; i++) {
            extensionDescriptor += "(*."+extensions[i]+ ")  file";
        }
        
        
        
        
        
        
        return extensionDescriptor;
    }
    
}
