package storage;

import java.util.List;

public interface ReadWriteData<E> {
    List<E> readData(String path);
    void writeData(String path, List<E> e);
}
