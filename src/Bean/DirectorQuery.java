package Bean;

public class DirectorQuery {
    private String PersonName;
    private String PersonBirth;
    private String FilmName;

    public DirectorQuery(String PersonName, String PersonBirth, String FilmName) {
        this.PersonName = PersonName;
        this.PersonBirth = PersonBirth;
        this.FilmName = FilmName;
    }

    public String getPersonName() {
        return this.PersonName;
    }

    public String getPersonBirth() {
        return PersonBirth;
    }

    public String getFilmName() {
        return FilmName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public void setPersonBirth(String personBirth) {
        PersonBirth = personBirth;
    }

    public void setFilmName(String filmName) {
        FilmName = filmName;
    }
}
