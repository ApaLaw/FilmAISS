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
    "readable",
    "title",
    "title_short",
    "title_version",
    "link",
    "duration",
    "rank",
    "explicit_lyrics",
    "explicit_content_lyrics",
    "explicit_content_cover",
    "preview",
    "artist",
    "album",
    "type"
})
public class Datum {
 
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("readable")
    private Boolean readable;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_short")
    private String titleShort;
    @JsonProperty("title_version")
    private String titleVersion;
    @JsonProperty("link")
    private String link;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("explicit_lyrics")
    private Boolean explicitLyrics;
    @JsonProperty("explicit_content_lyrics")
    private Integer explicitContentLyrics;
    @JsonProperty("explicit_content_cover")
    private Integer explicitContentCover;
    @JsonProperty("preview")
    private String preview;
    @JsonProperty("artist")
    private Artist artist;
    @JsonProperty("album")
    private Album album;
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
 
    @JsonProperty("readable")
    public Boolean getReadable() {
        return readable;
    }
 
    @JsonProperty("readable")
    public void setReadable(Boolean readable) {
        this.readable = readable;
    }
 
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
 
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
 
    @JsonProperty("title_short")
    public String getTitleShort() {
        return titleShort;
    }
 
    @JsonProperty("title_short")
    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }
 
    @JsonProperty("title_version")
    public String getTitleVersion() {
        return titleVersion;
    }
 
    @JsonProperty("title_version")
    public void setTitleVersion(String titleVersion) {
        this.titleVersion = titleVersion;
    }
 
    @JsonProperty("link")
    public String getLink() {
        return link;
    }
 
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }
 
    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }
 
    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
 
    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }
 
    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }
 
    @JsonProperty("explicit_lyrics")
    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }
 
    @JsonProperty("explicit_lyrics")
    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }
 
    @JsonProperty("explicit_content_lyrics")
    public Integer getExplicitContentLyrics() {
        return explicitContentLyrics;
    }
 
    @JsonProperty("explicit_content_lyrics")
    public void setExplicitContentLyrics(Integer explicitContentLyrics) {
        this.explicitContentLyrics = explicitContentLyrics;
    }
 
    @JsonProperty("explicit_content_cover")
    public Integer getExplicitContentCover() {
        return explicitContentCover;
    }
 
    @JsonProperty("explicit_content_cover")
    public void setExplicitContentCover(Integer explicitContentCover) {
        this.explicitContentCover = explicitContentCover;
    }
 
    @JsonProperty("preview")
    public String getPreview() {
        return preview;
    }
 
    @JsonProperty("preview")
    public void setPreview(String preview) {
        this.preview = preview;
    }
 
    @JsonProperty("artist")
    public Artist getArtist() {
        return artist;
    }
 
    @JsonProperty("artist")
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
 
    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }
 
    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
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