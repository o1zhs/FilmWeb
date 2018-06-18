package Bean;

import java.util.List;

public class Person {

    private String personID;
    private String name;
    private String birth;

    private int intID;
    private String[] director;
    private String[] voice;
    private List<Actor> actors; //用于查询一个演员演过的所有电影及角色
    private Actor actor;        //用于查询某一部电影内的演员所有角色

    public Person(String personID,String name,String birth,String[] director,String[] voice,List<Actor> actors, int intID){
        this.personID = personID;
        this.name = name;
        this.birth = birth;
        this.director = director;
        this.voice = voice;
        this.actors = actors;
        this.intID = intID;
    }

    public Person(String personID,String name,String birth,String[] director,String[] voice,List<Actor> actors){
        this.personID = personID;
        this.name = name;
        this.birth = birth;
        this.director = director;
        this.voice = voice;
        this.actors = actors;
    }


    public String getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public int getIntID() {
        return intID;
    }

    public String[] getDirector() {
        return director;
    }

    public String[] getVoice() {
        return voice;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
