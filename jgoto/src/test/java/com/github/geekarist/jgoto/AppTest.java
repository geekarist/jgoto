package com.github.geekarist.jgoto;

import java.io.IOException;

import org.junit.Test;

import junit.framework.Assert;

public class AppTest {

	@Test
	public void testApp() throws IOException {
		App app = new App();
		String duration = app.from("9, Rue de la Croix Faubin, 75011, Paris")
				.to("63, bd de Brandebourg, 94200, Ivry-sur-Seine").duration();
		String msg = String.format("Incorrect duration [%s]", duration);
		Assert.assertTrue(msg, duration.matches("[0-9]* mn"));
	}
}
