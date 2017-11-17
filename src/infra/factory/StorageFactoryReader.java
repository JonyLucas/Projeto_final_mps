/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra.factory;

import infra.Adpter.Reader;
import infra.adaptee.StorageReader;

/**
 *
 * @author Joao
 */
public class StorageFactoryReader {
    public static Reader selectStorage(String type){
        Reader reader;
        if(type.equals("file")){
            reader = StorageReader.get_instance();
            return reader;
        }else{
            return null;
        }
    }
}
