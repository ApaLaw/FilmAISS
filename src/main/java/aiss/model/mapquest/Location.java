
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
    "street",
    "adminArea6",
    "adminArea6Type",
    "adminArea5",
    "adminArea5Type",
    "adminArea4",
    "adminArea4Type",
    "adminArea3",
    "adminArea3Type",
    "adminArea1",
    "adminArea1Type",
    "postalCode",
    "geocodeQualityCode",
    "geocodeQuality",
    "dragPoint",
    "sideOfStreet",
    "linkId",
    "unknownInput",
    "type",
    "latLng",
    "displayLatLng",
    "mapUrl"
})
public class Location {

    @JsonProperty("street")
    private String street;
    @JsonProperty("adminArea6")
    private String adminArea6;
    @JsonProperty("adminArea6Type")
    private String adminArea6Type;
    @JsonProperty("adminArea5")
    private String adminArea5;
    @JsonProperty("adminArea5Type")
    private String adminArea5Type;
    @JsonProperty("adminArea4")
    private String adminArea4;
    @JsonProperty("adminArea4Type")
    private String adminArea4Type;
    @JsonProperty("adminArea3")
    private String adminArea3;
    @JsonProperty("adminArea3Type")
    private String adminArea3Type;
    @JsonProperty("adminArea1")
    private String adminArea1;
    @JsonProperty("adminArea1Type")
    private String adminArea1Type;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("geocodeQualityCode")
    private String geocodeQualityCode;
    @JsonProperty("geocodeQuality")
    private String geocodeQuality;
    @JsonProperty("dragPoint")
    private Boolean dragPoint;
    @JsonProperty("sideOfStreet")
    private String sideOfStreet;
    @JsonProperty("linkId")
    private String linkId;
    @JsonProperty("unknownInput")
    private String unknownInput;
    @JsonProperty("type")
    private String type;
    @JsonProperty("latLng")
    private LatLng latLng;
    @JsonProperty("displayLatLng")
    private DisplayLatLng displayLatLng;
    @JsonProperty("mapUrl")
    private String mapUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("adminArea6")
    public String getAdminArea6() {
        return adminArea6;
    }

    @JsonProperty("adminArea6")
    public void setAdminArea6(String adminArea6) {
        this.adminArea6 = adminArea6;
    }

    @JsonProperty("adminArea6Type")
    public String getAdminArea6Type() {
        return adminArea6Type;
    }

    @JsonProperty("adminArea6Type")
    public void setAdminArea6Type(String adminArea6Type) {
        this.adminArea6Type = adminArea6Type;
    }

    @JsonProperty("adminArea5")
    public String getAdminArea5() {
        return adminArea5;
    }

    @JsonProperty("adminArea5")
    public void setAdminArea5(String adminArea5) {
        this.adminArea5 = adminArea5;
    }

    @JsonProperty("adminArea5Type")
    public String getAdminArea5Type() {
        return adminArea5Type;
    }

    @JsonProperty("adminArea5Type")
    public void setAdminArea5Type(String adminArea5Type) {
        this.adminArea5Type = adminArea5Type;
    }

    @JsonProperty("adminArea4")
    public String getAdminArea4() {
        return adminArea4;
    }

    @JsonProperty("adminArea4")
    public void setAdminArea4(String adminArea4) {
        this.adminArea4 = adminArea4;
    }

    @JsonProperty("adminArea4Type")
    public String getAdminArea4Type() {
        return adminArea4Type;
    }

    @JsonProperty("adminArea4Type")
    public void setAdminArea4Type(String adminArea4Type) {
        this.adminArea4Type = adminArea4Type;
    }

    @JsonProperty("adminArea3")
    public String getAdminArea3() {
        return adminArea3;
    }

    @JsonProperty("adminArea3")
    public void setAdminArea3(String adminArea3) {
        this.adminArea3 = adminArea3;
    }

    @JsonProperty("adminArea3Type")
    public String getAdminArea3Type() {
        return adminArea3Type;
    }

    @JsonProperty("adminArea3Type")
    public void setAdminArea3Type(String adminArea3Type) {
        this.adminArea3Type = adminArea3Type;
    }

    @JsonProperty("adminArea1")
    public String getAdminArea1() {
        return adminArea1;
    }

    @JsonProperty("adminArea1")
    public void setAdminArea1(String adminArea1) {
        this.adminArea1 = adminArea1;
    }

    @JsonProperty("adminArea1Type")
    public String getAdminArea1Type() {
        return adminArea1Type;
    }

    @JsonProperty("adminArea1Type")
    public void setAdminArea1Type(String adminArea1Type) {
        this.adminArea1Type = adminArea1Type;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("geocodeQualityCode")
    public String getGeocodeQualityCode() {
        return geocodeQualityCode;
    }

    @JsonProperty("geocodeQualityCode")
    public void setGeocodeQualityCode(String geocodeQualityCode) {
        this.geocodeQualityCode = geocodeQualityCode;
    }

    @JsonProperty("geocodeQuality")
    public String getGeocodeQuality() {
        return geocodeQuality;
    }

    @JsonProperty("geocodeQuality")
    public void setGeocodeQuality(String geocodeQuality) {
        this.geocodeQuality = geocodeQuality;
    }

    @JsonProperty("dragPoint")
    public Boolean getDragPoint() {
        return dragPoint;
    }

    @JsonProperty("dragPoint")
    public void setDragPoint(Boolean dragPoint) {
        this.dragPoint = dragPoint;
    }

    @JsonProperty("sideOfStreet")
    public String getSideOfStreet() {
        return sideOfStreet;
    }

    @JsonProperty("sideOfStreet")
    public void setSideOfStreet(String sideOfStreet) {
        this.sideOfStreet = sideOfStreet;
    }

    @JsonProperty("linkId")
    public String getLinkId() {
        return linkId;
    }

    @JsonProperty("linkId")
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    @JsonProperty("unknownInput")
    public String getUnknownInput() {
        return unknownInput;
    }

    @JsonProperty("unknownInput")
    public void setUnknownInput(String unknownInput) {
        this.unknownInput = unknownInput;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("latLng")
    public LatLng getLatLng() {
        return latLng;
    }

    @JsonProperty("latLng")
    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @JsonProperty("displayLatLng")
    public DisplayLatLng getDisplayLatLng() {
        return displayLatLng;
    }

    @JsonProperty("displayLatLng")
    public void setDisplayLatLng(DisplayLatLng displayLatLng) {
        this.displayLatLng = displayLatLng;
    }

    @JsonProperty("mapUrl")
    public String getMapUrl() {
        return mapUrl;
    }

    @JsonProperty("mapUrl")
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
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
