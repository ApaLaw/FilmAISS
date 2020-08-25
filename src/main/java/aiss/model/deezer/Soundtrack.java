package aiss.model.deezer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
 
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "total",
    "next"
})
public class Soundtrack {
 
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("next")
    private String next;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
 
    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }
 
    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }
 
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }
 
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }
 
    @JsonProperty("next")
    public String getNext() {
        return next;
    }
 
    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
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