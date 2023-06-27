class Teacher {
    private String name;
    private String lab;

    // Add here
    Teacher(){
        this.name = "竹内先生";
        this.lab = "ゲーム情報学研究室";
    }
    String getName(){
        return this.name;
    }
    String getLab(){
        return this.lab;
    }

    void setName(String name){
        this.name = name;
    }
    void setLab(String lab){
        this.lab = lab;
    }
}
