package ohm.softa.a06;


import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface CNJDBApi {
	@GET("random")
	Call<Joke> getRandomJoke();
	@GET("random?category={categories}")
	Call<Joke> getRandomJoke(@Path("categories") List<String> categories);
	@GET("search?query={query}")
	Call<List<Joke>> getJokesBySearch(@Path("query") String query);
	@GET("{id}")
	Call<Joke> getJoke(@Path("id") String id);
}
