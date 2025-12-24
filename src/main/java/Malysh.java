import java.util.Objects;
public abstract class Malysh{
    protected String name;
    protected CharacterType characterType;
    protected int bravery;

    public Malysh(String name, CharacterType characterType, int bravery) {
        if (name == null || name.isBlank()) {
            throw new InvalidAttributeException("Имя не может быть пустым");
        }
        if (bravery < 0 || bravery >100) {
            throw new InvalidAttributeException("Смелость не удовлетворяет диапазону");
        }
        this.name = name;
        this.characterType = characterType;
        this.bravery = bravery;
    }

    public String getName() {
        return name;
    }
    public CharacterType getCharacterType() {
        return characterType;
    }
    public int getBravery() {
        return bravery;
    }
    public abstract String doAction();

    public String goToCity(City city) throws TravelException {
        if (city == null) {
            throw new TravelException("Пункт назначения не указан", "Неизвестное место");
        }
        double chance = bravery + Math.random()*50;
        if (chance <= 50) {
            throw new TravelException("Боиться идти", city.getName());
        }
        return name + "отправился в " + city.getName();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Malysh that = (Malysh) obj;
        return bravery == that.bravery &&
                Objects.equals(name, that.name) &&
                characterType == that.characterType;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, characterType, bravery);
    }
    @Override
    public String toString() {
        return "main.java.Malysh{" + "name=" + name + ", characterType= " + characterType + ", bravery=" + bravery + "}";
    }
}


