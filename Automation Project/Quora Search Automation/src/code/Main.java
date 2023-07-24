package code;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {

		Process p = new Process();
		p.readInputs();
		p.searchSelection();
		p.searchResults();
		p.signIn();
		p.signUpWithEmail();
		p.screenShots();
		p.quit();

	}

}
