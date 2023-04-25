package ohm.softa.a06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import ohm.softa.a06.model.JokeAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		var gson = new GsonBuilder()
			.registerTypeAdapter(Joke.class, new JokeAdapter())
			// List Adapter
			.create();
		var client = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io/jokes/")
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build();
		var result = client.create(CNJDBApi.class)
			.getRandomJoke()
			.execute();

		Joke joke = result.body();

		assert joke != null;
		System.out.println(joke.getContent());
	}

}
