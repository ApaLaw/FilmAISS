
package aiss.model.restdb;

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
    "_id",
    "Nombre",
    "Mensaje",
    "Pelicula"
})
public class Restdb {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Mensaje")
    private String mensaje;
    @JsonProperty("Pelicula")
    private String pelicula;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("Nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("Mensaje")
    public String getMensaje() {
        return mensaje;
    }

    @JsonProperty("Mensaje")
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @JsonProperty("Pelicula")
    public String getPelicula() {
        return pelicula;
    }

    @JsonProperty("Pelicula")
    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	public Restdb(String id, String nombre, String mensaje, String pelicula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Restdb [id=" + id + ", nombre=" + nombre + ", mensaje=" + mensaje + ", pelicula=" + pelicula + "]";
	}
    
	
    

}
