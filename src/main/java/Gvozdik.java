import java.util.Objects;
public class Gvozdik extends Malysh {
    private boolean returned;

    public Gvozdik(String name, CharacterType characterType, int bravery) {
        super(name, characterType, bravery);
        this.returned = false;
    }

    @Override
    public String doAction() {
        if (returned) {
            return getName() + " дома";
        }
        else {
            return getName() + " пропал в Зеленом городе";
        }
    }

    public String goToGreenCity() {
        if (bravery > 50) {
            returned = true;
            return getName() + " отправляется в Зеленый город без сомнений";
        }
        else {
            returned = false;
            disappear();
            return getName() + " передумал, очень страшно";
        }
    }

    public void disappear() {
        returned = false;
    }

    public boolean hasReturned() {
        return returned;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Gvozdik that = (Gvozdik) obj;
        return returned == that.returned;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), returned);
    }
    @Override
    public String toString() {
        return "main.java.Gvozdik{" +
                "name=" + getName() +
                ", characterType= " + getCharacterType() +
                ", bravery= " + getBravery() +
                ", returned=" + returned + "}";
    }
}
