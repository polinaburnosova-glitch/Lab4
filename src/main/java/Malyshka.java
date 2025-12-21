import java.util.Objects;
public class Malyshka extends Malysh implements CanBeScared, CanReactToDragon {
    private boolean inDanger;
     public Malyshka(String name, CharacterType characterType, int bravery) {
         super(name, characterType, bravery);
         this.inDanger = true;
     }

     public boolean isInDanger() {
         return inDanger;
     }

     public String beSaved() {
         if (inDanger) {
             double saved = getBravery() + Math.random() * 20;
             if (saved > 50) {
                 inDanger = false;
                 return getName() + " спаслась от дракона";
             }
             else {
                 return getName() + " не смогла спастись от дракона";
             }
         }
         else {
             return getName() + " в безопасности";
         }
     }

    @Override
    public String doAction() {
         if (inDanger) {
             return "нуждается в помощи";
         }
         else {
             return "в безопасности";
         }
     }

    @Override
    public boolean isScared() {
         return inDanger;
    }

    @Override
    public boolean getScared() {
         if (!inDanger) {
             this.inDanger = true;
             return true;
         }
         return false;
    }

    @Override
    public String reactToDragon(Dragon dragon) {
         if (dragon == null) {
             return getName() + " считает, что дракон не существует";
         }
         else if (dragon.isReal()) {
             getScared();
             return getName() + " в ужасе";
         }
         else {
             return getName() + " не верят, что дракон настоящий";
         }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Malyshka that = (Malyshka) obj;
        return inDanger == that.inDanger;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inDanger);
    }
    @Override
    public String toString() {
        return "main.java.Malyshka{" +
                "name=" + getName() +
                ", characterType= " + getCharacterType() +
                ", bravery=" + getBravery() +
                ", inDanger=" + inDanger + "}";
    }
}
