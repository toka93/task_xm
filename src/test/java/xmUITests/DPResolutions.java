package xmUITests;

import org.testng.annotations.DataProvider;

public class DPResolutions {

	Object resolutionMedium = (Object) new int[] { 1024, 768 }; 
	Object resolutionSmall = (Object) new int[] { 800, 600 }; 

	Object resolutionMaximum = (Object) new String("Maximum");

	@DataProvider(name = "resolutionData")
	public Object[][] resolutionData() {
		return new Object[][] { { resolutionMaximum }

				, { resolutionMedium }, { resolutionSmall }

		};
	}
}
