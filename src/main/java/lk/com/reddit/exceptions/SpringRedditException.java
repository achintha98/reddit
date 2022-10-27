package lk.com.reddit.exceptions;

/**
 * @author Achintha Kalunayaka
 * @since 10/27/2022
 */
public class SpringRedditException extends RuntimeException{
    public SpringRedditException(String message) {
        super(message);
    }
}
