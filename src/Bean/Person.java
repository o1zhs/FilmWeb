package Bean;

public class Person {

    private String personID;
    private String name;
    private String birth;

    private String[] director;
    private String[] voice;
    private Actor[] actors;

    public Person(String personID,String name,String birth,String[] director,String[] voice,Actor[] actors){
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

    public String[] getDirector() {
        return director;
    }

    public String[] getVoice() {
        return voice;
    }

    public Actor[] getActors() {
        return actors;
    }
}
