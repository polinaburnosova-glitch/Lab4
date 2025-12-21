import java.util.Objects;
public class Friend extends Malysh {
    private boolean beFound;
    private String location;

    public Friend(String name, CharacterType characterType, int bravery) {
        super(name, characterType, bravery);
        this.location = "Воздушный шар";
        this.beFound = false;
    }

    @Override
    public String doAction() {
        if (beFound) {
            return "Найден Знайкой";
        }
        else {
            if (getBravery() > 50) {
                return "Тоже пытается найти Знайку";
            }
            return "Летит на воздушном шаре в неизвестном направлении";
        }
    }

    public String getFound() {
        if (!beFound) {
            beFound = true;
            location = "Вместе со Знайкой";
            return "Был найден Знайкой";
        }
        else {
            return getName() + "уже найден";
        }
    }

    public String getLocation() {
        return location;
    }
    public boolean beFound() {
        return beFound;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Friend that = (Friend) obj;
        return beFound == that.beFound &&
                Objects.equals(location, that.location);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beFound, location);
    }
    @Override
    public String toString() {
        return "main.java.Znayka{" +
                "name=" + getName() +
                ", characterType= " + getCharacterType() +
                ", bravery=" + getBravery() +
                ", beFound=" + beFound +
                ", location=" + location + "}";
    }
}
