package Bean;

public class ActorQuery {
    private String Role;
    private String FilmName;
    private String PersonName;
    private String PersonBirth;

    public ActorQuery(String Role, String FilmName, String PersonName, String PersonBirth) {
        this.Role = Role;
        this.FilmName = FilmName;
        this.PersonName = PersonName;
        this.PersonBirth = PersonBirth;
    }

    public String getRole() {
        return Role;
    }


    public String getFilmName() {
        return FilmName;
    }

    public String getPersonBirth() {
        return PersonBirth;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setFilmName(String filmName) {
        FilmName = filmName;
    }

    public void setPersonBirth(String personBirth) {
        PersonBirth = personBirth;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }
}
