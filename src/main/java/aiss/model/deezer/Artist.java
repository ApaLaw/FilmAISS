package aiss.model.deezer;
 
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
    "id",
    "name",
    "link",
    "picture",
    "picture_small",
    "picture_medium",
    "picture_big",
    "picture_xl",
    "tracklist",
    "type"
})
public class Artist {
 
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("picture_small")
    private String pictureSmall;
    @JsonProperty("picture_medium")
    private String pictureMedium;
    @JsonProperty("picture_big")
    private String pictureBig;
    @JsonProperty("picture_xl")
    private String pictureXl;
    @JsonProperty("tracklist")
    private String tracklist;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
 
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
 
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
 
    @JsonProperty("name")
    public String getName() {
        return name;
    }
 
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
 
    @JsonProperty("link")
    public String getLink() {
        return link;
    }
 
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }
 
    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }
 
    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }
 
    @JsonProperty("picture_small")
    public String getPictureSmall() {
        return pictureSmall;
    }
 
    @JsonProperty("picture_small")
    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }
 
    @JsonProperty("picture_medium")
    public String getPictureMedium() {
        return pictureMedium;
    }
 
    @JsonProperty("picture_medium")
    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }
 
    @JsonProperty("picture_big")
    public String getPictureBig() {
        return pictureBig;
    }
 
    @JsonProperty("picture_big")
    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }
 
    @JsonProperty("picture_xl")
    public String getPictureXl() {
        return pictureXl;
    }
 
    @JsonProperty("picture_xl")
    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
    }
 
    @JsonProperty("tracklist")
    public String getTracklist() {
        return tracklist;
    }
 
    @JsonProperty("tracklist")
    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }
 
    @JsonProperty("type")
    public String getType() {
        return type;
    }
 
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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