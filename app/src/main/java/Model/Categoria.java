package Model;

import java.io.Serializable;
import java.util.function.Consumer;

public class Categoria implements Serializable {
    private String id;
    private String nombreCategoria;
    private int color;
    private int icon;

    public Categoria() {   }

    public Categoria(Consumer<Categoria> c){
        c.accept(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
