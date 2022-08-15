package TournamentOrganizer.models;

public enum TypeOfTournament {

    WOMEN_ONLY_TEAM_PLAY("Women only: team play"),
    WOMEN_ONLY_SINGLE_PLAY("Women only: single play"),
    MEN_ONLY_TEAM_PLAY("Men only: team play"),
    MEN_ONLY_SINGLE_PLAY("Men only: single play"),
    GIRLS_ONLY_TEAM_PLAY("Girls only: team play"),
    GIRLS_ONLY_SINGLE_PLAY("Girls only: single play"),
    BOYS_ONLY_TEAM_PLAY("Boys only: team play"),
    BOYS_ONLY_SINGLE_PLAY("Boys only: single play"),
    MEN_WOMEN_MIX_TEAM_PLAY("Men / Women mix: team play"),
    MEN_WOMEN_MIX_SINGLE_PLAY("Men / Women mix: single play"),
    BOYS_GIRLS_MIX_TEAM_PLAY("Boys / Girls mix: team play"),
    BOYS_GIRLS_MIX_SINGLE_PLAY("Boys / Girls mix: single play"),
    MEN_VS_WOMEN_TEAM_PLAY("Men V.S. Women: team play"),
    MEN_VS_WOMEN_SINGLE_PLAY("Men V.S. Women: single play"),
    BOYS_VS_GIRLS_TEAM_PLAY("Boys V.S. Girls: team play"),
    BOYS_VS_GIRLS_SINGLE_PLAY("Boys V.S. Girls: single play"),
    FAMILY_TEAM_PLAY("Family against family: team play");

    private final String displayName;

    TypeOfTournament(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
