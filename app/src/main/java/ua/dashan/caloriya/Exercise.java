package ua.dashan.caloriya;

public class Exercise {
    private String name;
    private String description;
    private int photo;
    public Exercise(){}
    public Exercise(String name,String description,int photo){
        this.name=name;
        this.description=description;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
