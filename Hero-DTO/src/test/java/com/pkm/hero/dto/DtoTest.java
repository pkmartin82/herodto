package com.pkm.hero.dto;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DtoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Hero testHero = new Hero();
		
		testHero.setHeroId(1);
		testHero.setHeroName("testHero");
		testHero.setCatchphrase("testing!");
		testHero.setSecretIdentity("pop quiz");
		testHero.setUniverseId(2);
		testHero.setNumOthersWhoKnowSecret(3);
		testHero.setInsertUser("insertUser");
		testHero.setInsertTime(new Date());
		testHero.setUpdateUser("updateUser");
		testHero.setUpdateTime(new Date());
		
		Gson gson = getGson();

		String testHeroString = gson.toJson(testHero);

		System.out.println(testHeroString);
		
		assertNotNull(testHeroString);
	}

	/**
	 * Returns a Gson object that has been configured to handle the data our
	 * rest client is returning
	 * 
	 * @return Gson
	 */
	protected Gson getGson() {

		// Creates the json object which will manage the information
		// received
		GsonBuilder gsonBuilder = new GsonBuilder();

		// Register an adapter to manage the date types as long values
		gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(json.getAsJsonPrimitive().getAsLong());
			}
		});

		// Set DateFormat to an 'easily digestible' format that can be
		// deserialized by a application server
		gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		Gson gSon = gsonBuilder.create();

		return (gSon);
	}
}
