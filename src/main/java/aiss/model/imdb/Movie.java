
package aiss.model.imdb;

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
    "title",
    "year",
    "releaseDate",
    "directors",
    "writers",
    "runtime",
    "urlPoster",
    "countries",
    "languages",
    "genres",
    "plot",
    "simplePlot",
    "actors",
    "idIMDB",
    "urlIMDB",
    "rating",
    "metascore",
    "filmingLocations",
    "rated",
    "trailer",
    "votes",
    "type"
})
public class Movie {

    @JsonProperty("title")
    private String title;
    @JsonProperty("year")
    private String year;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("directors")
    private List<Director> directors = null;
    @JsonProperty("writers")
    private List<Writer> writers = null;
    @JsonProperty("runtime")
    private String runtime;
    @JsonProperty("urlPoster")
    private String urlPoster;
    @JsonProperty("countries")
    private List<String> countries = null;
    @JsonProperty("languages")
    private List<String> languages = null;
    @JsonProperty("genres")
    private List<String> genres = null;
    @JsonProperty("plot")
    private String plot;
    @JsonProperty("simplePlot")
    private String simplePlot;
    @JsonProperty("actors")
    private List<Actor> actors = null;
    @JsonProperty("idIMDB")
    private String idIMDB;
    @JsonProperty("urlIMDB")
    private String urlIMDB;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("metascore")
    private String metascore;
    @JsonProperty("filmingLocations")
    private List<FilmingLocation> filmingLocations = null;
    @JsonProperty("rated")
    private String rated;
    @JsonProperty("trailer")
    private Trailer trailer;
    @JsonProperty("votes")
    private String votes;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        String fecha =  releaseDate;
        return fecha.substring(6) + "/" + fecha.substring(4,6) + "/" + fecha.substring(0,4);
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("directors")
    public List<Director> getDirectors() {
        return directors;
    }

    @JsonProperty("directors")
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @JsonProperty("writers")
    public List<Writer> getWriters() {
        return writers;
    }

    @JsonProperty("writers")
    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    @JsonProperty("runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("urlPoster")
    public String getUrlPoster() {
        return urlPoster;
    }

    @JsonProperty("urlPoster")
    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    @JsonProperty("countries")
    public List<String> getCountries() {
        return countries;
    }

    @JsonProperty("countries")
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("plot")
    public String getPlot() {
        return plot;
    }

    @JsonProperty("plot")
    public void setPlot(String plot) {
        this.plot = plot;
    }

    @JsonProperty("simplePlot")
    public String getSimplePlot() {
        return simplePlot;
    }

    @JsonProperty("simplePlot")
    public void setSimplePlot(String simplePlot) {
        this.simplePlot = simplePlot;
    }

    @JsonProperty("actors")
    public List<Actor> getActors() {
        return actors;
    }

    @JsonProperty("actors")
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @JsonProperty("idIMDB")
    public String getIdIMDB() {
        return idIMDB;
    }

    @JsonProperty("idIMDB")
    public void setIdIMDB(String idIMDB) {
        this.idIMDB = idIMDB;
    }

    @JsonProperty("urlIMDB")
    public String getUrlIMDB() {
        return urlIMDB;
    }

    @JsonProperty("urlIMDB")
    public void setUrlIMDB(String urlIMDB) {
        this.urlIMDB = urlIMDB;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("metascore")
    public String getMetascore() {
        return metascore;
    }

    @JsonProperty("metascore")
    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    @JsonProperty("filmingLocations")
    public List<FilmingLocation> getFilmingLocations() {
        return filmingLocations;
    }

    @JsonProperty("filmingLocations")
    public void setFilmingLocations(List<FilmingLocation> filmingLocations) {
        this.filmingLocations = filmingLocations;
    }

    @JsonProperty("rated")
    public String getRated() {
        return rated;
    }

    @JsonProperty("rated")
    public void setRated(String rated) {
        this.rated = rated;
    }

    @JsonProperty("trailer")
    public Trailer getTrailer() {
        return trailer;
    }

    @JsonProperty("trailer")
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    @JsonProperty("votes")
    public String getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(String votes) {
        this.votes = votes;
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
