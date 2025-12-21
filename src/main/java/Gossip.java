public record Gossip(String content, int scaryLevel, boolean isTrue) {
    public String getFormattedContent() {
        String beginning = switch(scaryLevel) {
            case 1, 2, 3, 4 -> "[Обычный]";
            case 5, 6 -> "[Пугающий]";
            case 7, 8, 9 -> "[Очень опасный]";
            default -> "[Неизвестный]";
        };
        return beginning + "Слух:" + content;
    }
    public boolean isScary() {
        return scaryLevel >= 5;
    }
}

