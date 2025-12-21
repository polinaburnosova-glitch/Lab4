import java.util.Objects;
public class Zhitely extends Malysh implements CanBeScared, CanReactToDragon {
    private String homeCity;
    private boolean hearGossip;
    private boolean beScared;

    public Zhitely(String name, CharacterType characterType, int bravery, String homeCity) {
        super(name, characterType, bravery);
        this.homeCity = homeCity;
        this.hearGossip = false;
        this.beScared = false;
    }



    public void hearGossip(Gossip gossip) {
        this.hearGossip = true;
        if (gossip.isScary()) {
            getScared();
        }
    }

    @Override
    public String doAction() {
        if (beScared) {
            return getName() + " Боится и прячется дома";
        }
        else if (hearGossip) {
            return getName() + "Обсуждает слухи с соседями";
        }
        else {
            return getName() + "Не обращает внимания";
        }
    }

    public String toGoToZeleniyGorod() {
        double chance = bravery + Math.random()*15;
        if (chance > 50) {
            beScared = false;
            return getName() + " Решается пойти";
        }
        else {
            beScared = true;
            return getName() + " Испугался и остался дома";
        }
    }

    public String reactToDragon(Dragon dragon) {
        if (dragon == null) {
            Gossip rumor = new Gossip("Дракона не существует", 1, true);
            hearGossip(rumor);
            return getName() + " считает, что дракона не существует" + rumor.getFormattedContent();
        }

        int scaryLevel;
        if (dragon.isReal()) {
            scaryLevel = 8;
        }
        else {
            scaryLevel = 3;
        }
        Gossip rumor = new Gossip("Дракон появился в " + homeCity, scaryLevel, dragon.isReal());
        hearGossip(rumor);
        switch (getCharacterType()) {
            case SCARED:
                beScared = true;
                return getName() + " испытвает ужас " + rumor.getFormattedContent();
            case BRAVE:
                beScared = false;
                return getName() + " не обращает внимания " + rumor.getFormattedContent();
            case CURIOUS:
                beScared = false;
                return getName() + " хочет проверить слухи " + rumor.getFormattedContent();
            case TRUSTFUL:
                beScared = true;
                return getName() + " поверил в слухи о драконе и боится " + rumor.getFormattedContent();
            default:
                beScared = false;
                return getName() + " услышал слух о драконе " + rumor.getFormattedContent();
        }


        }



    public String meetStranger() {
        if (getCharacterType() == CharacterType.CURIOUS) {
            return getName() + " подходит познакомиться и расспросить";
        }
        else if (getCharacterType() == CharacterType.BRAVE) {
            return getName() + " подходит познакомиться";
        }
        else {
            return getName() + " наблюдает издалека со страхом";
        }
    }

    @Override
    public boolean isScared() {
        return beScared;
    }

    @Override
    public boolean getScared() {
        if (!beScared) {
            this.beScared = true;
            return true;
        }
        return false;
    }

    public String getHomeCity() {
        return homeCity;
    }
    public boolean hasHearGossip() {
        return hearGossip;
    }
    public boolean beScared() {
        return beScared;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Zhitely that = (Zhitely) obj;
        return Objects.equals(homeCity, that.homeCity) &&
                hearGossip == that.hearGossip &&
                beScared == that.beScared;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), homeCity, hearGossip, beScared);
    }
    @Override
    public String toString() {
        return "main.java.Zhitely{" +
                "name=" + getName() +
                ", characterType= " + getCharacterType() +
                ", bravery=" + getBravery() +
                ", homeCity=" + homeCity +
                ", hearGossip=" + hearGossip +
                ", beScared=" + beScared + "}";
    }
}



