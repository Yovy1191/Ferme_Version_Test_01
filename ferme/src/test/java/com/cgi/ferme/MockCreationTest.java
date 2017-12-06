
package com.cgi.ferme;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cgi.ferme.domain.Ferme;
import com.cgi.ferme.service.IFermeService;

import static org.junit.Assert.*;

public class MockCreationTest {

	@Mock
	private IFermeService fermeService;

	@Mock
	private Ferme ferme;

	@Before
	public void setupMOck() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testMockCreation() {
		assertNotNull(ferme);
		assertNotNull(fermeService);
	}

}
