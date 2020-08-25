
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
    "quality",
    "videoURL"
})
public class Quality {

    @JsonProperty("quality")
    private String quality;
    @JsonProperty("videoURL")
    private String videoURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


	@JsonProperty("quality")
    public String getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(String quality) {
        this.quality = quality;
    }

    @JsonProperty("videoURL")
    public String getVideoURL() {
        return videoURL;
    }

    @JsonProperty("videoURL")
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
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
