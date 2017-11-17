/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.factory;

import infra.adaptee.StorageWriter;
import infra.Adpter.Writer;

/**
 *
 * @author Joao
 */
public class StorageFactoryWriter {
    public Writer selectStorage(String type){
        Writer writer;
        if(type.equals("file")){
            writer = StorageWriter.get_instance();
            return writer;
        }else{
            return null;
        }
    }
}
