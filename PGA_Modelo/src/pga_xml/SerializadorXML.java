package pga_xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Clase de conveniencia para la serializacion de un objeto a un archivo o viceversa.
 */
public class SerializadorXML {
    static public void escribe(Object f, String filename) throws Exception {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        encoder.writeObject(f);
        encoder.close();
    }

    static public Object lee(String filename) throws Exception {
        XMLDecoder decoder =new XMLDecoder(new BufferedInputStream( new FileInputStream(filename)));
        Object o = (Object)decoder.readObject();
        decoder.close();
        return o;
    }
}
