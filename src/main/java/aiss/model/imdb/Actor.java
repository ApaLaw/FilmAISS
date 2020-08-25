
package aiss.model.imdb;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actorName",
    "urlProfile",
    "urlPhoto",
    "actorId",
    "character",
    "urlCharacter",
    "main"
})
public class Actor {

    @JsonProperty("actorName")
    private String actorName;
    @JsonProperty("urlProfile")
    private String urlProfile;
    @JsonProperty("urlPhoto")
    private String urlPhoto;
    @JsonProperty("actorId")
    private String actorId;
    @JsonProperty("character")
    private String character;
    @JsonProperty("urlCharacter")
    private String urlCharacter;
    @JsonProperty("main")
    private Boolean main;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("actorName")
    public String getActorName() {
        return actorName;
    }

    @JsonProperty("actorName")
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @JsonProperty("urlProfile")
    public String getUrlProfile() {
        return urlProfile;
    }

    @JsonProperty("urlProfile")
    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    @JsonProperty("urlPhoto")
    public String getUrlPhoto() {
        if(urlPhoto.equals("")) {
        	return "https://m.media-amazon.com/images/G/01/imdb/images/nopicture/32x44/name-2138558783._CB468460248_.png";
        }else{
        	return urlPhoto;
        }
    }

    @JsonProperty("urlPhoto")
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @JsonProperty("actorId")
    public String getActorId() {
        return actorId;
    }

    @JsonProperty("actorId")
    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    @JsonProperty("character")
    public String getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(String character) {
        this.character = character;
    }

    @JsonProperty("urlCharacter")
    public String getUrlCharacter() {
        return urlCharacter;
    }

    @JsonProperty("urlCharacter")
    public void setUrlCharacter(String urlCharacter) {
        this.urlCharacter = urlCharacter;
    }

    @JsonProperty("main")
    public Boolean getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Boolean main) {
        this.main = main;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
