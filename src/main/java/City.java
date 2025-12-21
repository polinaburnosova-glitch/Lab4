import java.util.Objects;
public class City {
    private String name;
    private int dangerLevel;

    public City(String name, int dangerLevel) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("У города должно быть название");
        }
        if (dangerLevel < 0 || dangerLevel > 100) {
            throw new IllegalArgumentException("Значение не удовлетворяет диапазону");
        }
        this.name = name;
        this.dangerLevel = dangerLevel;
    }

    public String description() {
        if (dangerLevel >= 0 && dangerLevel <= 30) {
            return getName() + " безопасен";
        }
        else if (dangerLevel <= 50) {
            return getName() + " не очень безопасен";
        }
        else if (dangerLevel <=80) {
            return getName() + " опасен";
        }
        else {
            return getName() + " очень опасен";
        }
    }

    public String getName() {
        return name;
    }
    public int getDangerLevel() {
        return dangerLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        City city = (City) obj;
        return Objects.equals(name, city.name) &&
                dangerLevel == city.dangerLevel;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, dangerLevel);
    }
    @Override
    public String toString() {
        return "main.java.City{" + "name=" + name + ", dangerLevel=" + dangerLevel + "}";
    }
}
