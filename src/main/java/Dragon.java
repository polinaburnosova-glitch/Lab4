import java.util.Objects;
public class Dragon {
    private boolean exists;
    private int scaryLevel;

    public Dragon(boolean exists, int scaryLevel) {
        this.exists = exists;
        this.scaryLevel = scaryLevel;
    }

    public Dragon(boolean exists) {
        this.exists = exists;

        if (exists) {
            this.scaryLevel = 80;
        } else {
            this.scaryLevel = 0;
        }
    }

    public String threaten() {
        if (exists) {
            return "Стоголовый дракон скоро прикончит всех малышек, а затем примется за малышей";
        }
        else {
            return "Дракона не существует на самом деле";
        }
    }

    public String appear(int scaryLevel) {
        if (!exists) {
            return "Дракон не существует, не может появиться";
        }
        else {
            if (scaryLevel > 40) {
                return "Дракон появится";
            }
            else {
                return "Дракон не появится";
            }
        }
    }

    public boolean isReal() {
        return exists;
    }
    public int getScaryLevel() {
        return scaryLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dragon that = (Dragon) obj;
        return exists == that.exists &&
                scaryLevel == that.scaryLevel;
    }
    @Override
    public int hashCode() {
        return Objects.hash(exists, scaryLevel);
    }
    @Override
    public String toString() {
        return "main.java.Dragon{" +
                "exists=" + exists +
                ", scaryLevel= " + scaryLevel + "}";
    }
}
