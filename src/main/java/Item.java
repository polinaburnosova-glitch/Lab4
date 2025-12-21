import java.util.Objects;
public class Item {
    private String name;

    public Item(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        this.name = name;
    }

    public String use() {
        return "Предмет " + name + " использован.";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return Objects.equals(name, item.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public String toString() {
        return "main.java.Item{" + "name=" + name + "}";
    }
}
