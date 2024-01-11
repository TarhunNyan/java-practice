package multhiThreading.objectMethod.execution;

import multhiThreading.util.format.CollectionFormat;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Printed> storage;

    public Storage() {
        storage = new ArrayList<>();
    }

    public void add(Printed printed) {
        System.out.printf(
                "В хранилище добавлена реализация дизайна {%s} номер {%d} ...\n",
                printed.getDesign().name(),
                printed.getNumber()
        );
        storage.add(printed);
    }

    public String toString() {
        String res = CollectionFormat.collectionToString(
                storage,
                "Хранилище\n", "\n",
                "\t", ",\n"
        );
        return res;
    }

}
