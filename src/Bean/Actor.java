package Bean;

import java.util.List;

public class Actor {
    private String name;
    private String actFilm;
    private List<String> role;

    public Actor(String name,String actFilm, List<String> role){
        this.name = name;
        this.actFilm = actFilm;
        this.role = role;
    }

    public String getActFilm() {
        return actFilm;
    }

    public List<String> getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
