
package aiss.model.mapquest;

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
    "maxResults",
    "thumbMaps",
    "ignoreLatLngInput"
})
public class Options {

    @JsonProperty("maxResults")
    private Integer maxResults;
    @JsonProperty("thumbMaps")
    private Boolean thumbMaps;
    @JsonProperty("ignoreLatLngInput")
    private Boolean ignoreLatLngInput;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxResults")
    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonProperty("maxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    @JsonProperty("thumbMaps")
    public Boolean getThumbMaps() {
        return thumbMaps;
    }

    @JsonProperty("thumbMaps")
    public void setThumbMaps(Boolean thumbMaps) {
        this.thumbMaps = thumbMaps;
    }

    @JsonProperty("ignoreLatLngInput")
    public Boolean getIgnoreLatLngInput() {
        return ignoreLatLngInput;
    }

    @JsonProperty("ignoreLatLngInput")
    public void setIgnoreLatLngInput(Boolean ignoreLatLngInput) {
        this.ignoreLatLngInput = ignoreLatLngInput;
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
