package Bean;

public class VoiceQuery {
    private String PersonName;
    private String PersonBirth;
    private String FilmName;

    public VoiceQuery(String PersonName, String PersonBirth, String FilmName) {
        this.PersonName = PersonName;
        this.PersonBirth = PersonBirth;
        this.FilmName = FilmName;
    }

    public String getPersonName() {
        return this.PersonName;
    }
}
