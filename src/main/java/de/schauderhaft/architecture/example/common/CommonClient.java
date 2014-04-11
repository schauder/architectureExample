package de.schauderhaft.architecture.example.common;

/**
 * 
 */
public interface CommonClient {
	/**
	 * Sends word to Server and receive total points.
	 * 
	 * @param word
	 * @return
	 */
	int sendToServer(String word);
}
