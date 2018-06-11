package Bean;

public class Actor {
    private String nameID;
    private String actFilmID;
    private String[] role;

    public Actor(String name,String actFilm, String[] role){
        this.nameID = name;
        this.actFilmID = actFilm;
        this.role = role;
    }

    public String getActFilm() {
        return actFilmID;
    }

    public String[] getRole() {
        return role;
    }

    public String getNameID() {
        return nameID;
    }
}
