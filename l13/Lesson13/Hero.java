class Hero {

    private String name;
    private int level;

    public Hero() {
        this.name = "名無し";
        this.level = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    // Lesson13_4
    public void setName(String name) throws NameOutOfBoundsException{
        if (2 <= name.length() && name.length() <= 8) {
            this.name = name;
        } else {
            throw new NameOutOfBoundsException(name);
        }
    }

    public void setLevel(int level) throws LevelOutOfBoundsException{
        if (1 <= level && level <= 100) {
            this.level = level;
        } else {
            throw new LevelOutOfBoundsException(level);
        }
    }
}
