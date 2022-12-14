package controller.filetable;

import java.util.HashMap;

public class FileTable<Str, Reader> implements IFileTable<Str, Reader> {

    private HashMap<Str, Reader> filetable;

    public FileTable() {
        this.filetable = new HashMap<>();
    }

    @Override
    public void add(Str filename, Reader buffer) {
        this.filetable.put(filename, buffer);
    }

    @Override
    public Reader get(Str filename) {
        return this.filetable.get(filename);
    }

    @Override
    public HashMap<Str, Reader> getAll() {
        return this.filetable;
    }

    @Override
    public void remove(Str filename) {
        for (Str k : this.filetable.keySet()) {
            if (k.equals(filename)) {
                this.filetable.remove(k);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String rez = "";
        if (filetable.size() == 0) {
            return "";
        }
        for (Str k : this.filetable.keySet()) {
            rez += k.toString() + " " + this.get(k).toString() + "| ";
        }
        return rez;
    }

}