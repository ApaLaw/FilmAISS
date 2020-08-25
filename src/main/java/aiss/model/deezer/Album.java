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
    "title",
    "cover",
    "cover_small",
    "cover_medium",
    "cover_big",
    "cover_xl",
    "tracklist",
    "type"
})
public class Album {
 
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("cover")
    private String cover;
    @JsonProperty("cover_small")
    private String coverSmall;
    @JsonProperty("cover_medium")
    private String coverMedium;
    @JsonProperty("cover_big")
    private String coverBig;
    @JsonProperty("cover_xl")
    private String coverXl;
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
 
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
 
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
 
    @JsonProperty("cover")
    public String getCover() {
        return cover;
    }
 
    @JsonProperty("cover")
    public void setCover(String cover) {
        this.cover = cover;
    }
 
    @JsonProperty("cover_small")
    public String getCoverSmall() {
        return coverSmall;
    }
 
    @JsonProperty("cover_small")
    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }
 
    @JsonProperty("cover_medium")
    public String getCoverMedium() {
        return coverMedium;
    }
 
    @JsonProperty("cover_medium")
    public void setCoverMedium(String coverMedium) {
        this.coverMedium = coverMedium;
    }
 
    @JsonProperty("cover_big")
    public String getCoverBig() {
        return coverBig;
    }
 
    @JsonProperty("cover_big")
    public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }
 
    @JsonProperty("cover_xl")
    public String getCoverXl() {
        return coverXl;
    }
 
    @JsonProperty("cover_xl")
    public void setCoverXl(String coverXl) {
        this.coverXl = coverXl;
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