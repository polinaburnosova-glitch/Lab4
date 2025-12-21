import java.util.List;
import java.util.Arrays;
import java.util.Objects;
public class Znayka extends Malysh {
    private List<String> friends;
    private int luck;
    private boolean isLost;
    private boolean foundFriends;

    public Znayka(String name, CharacterType characterType, int luck, int bravery) {
        super(name, characterType, bravery);
        this.friends = Arrays.asList("Тюбик", "Гусля", "Шпунтик");
        this.luck = luck;
        this.isLost = true;
        this.foundFriends = false;
    }
    @Override
    public String doAction() {
        if (isLost) {
            return searchForFriends();
        } else {
            return getName() + " Вернулся домой";
        }
    }

    public String searchForFriends() {
        double chance = luck + Math.random()*20;
        if (chance > 70 && !foundFriends) {
            return foundFriends();
        }
        else if (chance > 40) {
            return getName() + " Нашел палатку друзей";
        }
        else {
            getLost();
            return getName() + " Не удается найти друзей";
        }
    }

    public String foundFriends() {
        double chance = luck + Math.random()*30;
        if (chance > 60) {
            foundFriends = true;
            isLost = false;
            return "Знайка смог найти всех своих друзей";
        }
        else {
            return "Знайка продолжает поиски";
        }
    }
    public String getLost() {
        int lostChance = 100 - luck;
        if (lostChance > 60 && !isLost) {
            isLost = true;
            return "Знайка совсем потерялся";
        }
        else {
            return "Знайка почти выбрался";
        }
    }
    public String decideToSearch() {
        if (getCharacterType() == CharacterType.BRAVE || getCharacterType() == CharacterType.CURIOUS) {
            searchForFriends();
            return "Это отважное решение";
        }
        else {
            if (luck > 40) {
                searchForFriends();
                return "Это опасная идея";
            }
            else {
                return "Передумал, слишком страшно";
            }
        }
    }

   public int getLuck() {
        return luck;
   }
   public boolean isLost() {
        return isLost;
   }
   public boolean isFoundFriends() {
        return foundFriends;
   }
   public List<String> getFriends() {
        return friends;
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Znayka that = (Znayka) obj;
        return luck == that.luck &&
                Objects.equals(friends, that.friends) &&
                characterType == that.characterType &&
                isLost == that.isLost &&
                foundFriends == that.foundFriends;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), luck, friends, isLost, foundFriends);
    }
    @Override
    public String toString() {
        return "main.java.Znayka{" +
                "name=" + getName() +
                ", characterType= " + getCharacterType() +
                ", bravery=" + getBravery() +
                ", luck=" + luck +
                ", isLost=" + isLost +
                ", foundFriends=" + foundFriends +
                ", friends=" + friends +"}";
    }
}
