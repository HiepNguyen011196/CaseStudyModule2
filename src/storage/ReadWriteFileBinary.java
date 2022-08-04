package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileBinary<E> implements ReadWriteData<E> {
    private static ReadWriteFileBinary instance = null;

    private ReadWriteFileBinary() {
    }

    public static ReadWriteFileBinary getInstance(){
        if (instance == null) instance = new ReadWriteFileBinary();
        return instance;
    }
    @Override
    public List<E> readData(String path) {
        List<E> e = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            e = (List<E>) ois.readObject();
            fis.close();
            ois.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public void writeData(String path, List<E> e) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e);
            oos.close();
            fos.close();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
