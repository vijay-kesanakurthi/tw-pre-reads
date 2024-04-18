class ResistorColor {
    int colorCode(String color) {
        String[] colors = colors();
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color)) {
                return i;
            }
        }
        return -1;
    }

    String[] colors() {
        return new String[] { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
    }
}
