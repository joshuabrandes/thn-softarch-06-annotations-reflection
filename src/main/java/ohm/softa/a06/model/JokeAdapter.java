package ohm.softa.a06.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

public class JokeAdapter extends TypeAdapter<Joke> {

	/* Example:
	{
		"icon_url" : "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
		"id" : "O-M07w1JTTWLnWBHeRk9Kg",
		"url" : "",
		"value" : "SNAKE PLISSKIN MAKES CHUCK NORRIS LOOK LIKE A SCHOOL GIRL BABY BACK BITCH !!!!!!"
	}
	 */

	@Override
	public void write(JsonWriter out, Joke value) throws IOException {
		out.beginObject();
		out.name("id").value(value.getIdentifier());
		out.name("content").value(value.getContent());
		out.endObject();
	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		var joke = new Joke();

		in.beginObject();
		while(in.hasNext()) {
			if (Objects.equals(in.nextName(), "id")) {
				joke.setIdentifier(in.nextString());
			} else if (Objects.equals(in.nextName(), "value")) {
				joke.setContent(in.nextString());
			} else in.skipValue();
		}
		in.endObject();

		return joke;
	}
}
